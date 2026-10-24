
import javax.swing.*;
import java.awt.*;

public class RestaurantBill extends JFrame {
    JTextField name = new JTextField(), price = new JTextField(),
               qty = new JTextField();
    JTextArea receipt = new JTextArea();

    RestaurantBill() {
        setTitle("Restaurant Billing System");
        setSize(380, 450);
        setLayout(new BorderLayout(10, 10));

        JPanel p = new JPanel(new GridLayout(4, 2, 8, 8));
        p.add(new JLabel("Food Name:")); p.add(name);
        p.add(new JLabel("Price (Tk):")); p.add(price);
        p.add(new JLabel("Quantity:")); p.add(qty);

        JButton btn = new JButton("Generate Receipt");
        p.add(btn);
        add(p, BorderLayout.NORTH);

        receipt.setEditable(false);
        receipt.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(receipt), BorderLayout.CENTER);

        btn.addActionListener(e -> {
            try {
                String food = name.getText();
                double sub = Double.parseDouble(price.getText())
                           * Integer.parseInt(qty.getText());
                double vat = sub * 0.05;

                receipt.setText("      MY RESTAURANT\n"
                    + "--------------------------\n"
                    + "Food: " + food + "\n"
                    + "Price: Tk " + price.getText() + "\n"
                    + "Quantity: " + qty.getText() + "\n"
                    + "--------------------------\n"
                    + String.format("Subtotal: Tk %.2f%n", sub)
                    + String.format("VAT (5%%): Tk %.2f%n", vat)
                    + "--------------------------\n"
                    + String.format("GRAND TOTAL: Tk %.2f%n", sub + vat)
                    + "--------------------------\n"
                    + "     Thank You! Visit Again");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid details!");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RestaurantBill();
    }
}
