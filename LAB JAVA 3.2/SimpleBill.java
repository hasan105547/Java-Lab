
import javax.swing.*;
import java.awt.*;

public class SimpleBill extends JFrame {
    String[] items = {"Biryani(250)", "Tehari(220)", "Chicken(300)",
                      "Soup(120)", "Naan(25)", "Drink(40)"};
    int[] price = {250, 220, 300, 120, 25, 40};
    int total = 0;

    JComboBox<String> menu = new JComboBox<>(items);
    JTextField qty = new JTextField("1", 5);
    JTextArea bill = new JTextArea(10, 20);

    public SimpleBill() {
        setTitle("Restaurant Bill");
        setLayout(new FlowLayout());

        JButton add = new JButton("Add Item");
        JButton finalBill = new JButton("Final Bill");

        add(new JLabel("Item:"));
        add(menu);
        add(new JLabel("Quantity:"));
        add(qty);
        add(add);
        add(new JScrollPane(bill));
        add(finalBill);

        add.addActionListener(e -> {
            int q = Integer.parseInt(qty.getText());
            int p = price[menu.getSelectedIndex()];
            total = total + p * q;
            bill.append(menu.getSelectedItem() + " = " + p * q + "\n");
        });

        finalBill.addActionListener(e -> {
            bill.append("\nTotal Bill: " + total);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleBill();
    }
}