import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    JTextField t = new JTextField();
    double a;
    String op = "";
    boolean reset;

    Calculator() {
        t.setFont(new Font("Arial", Font.BOLD, 28));
        t.setHorizontalAlignment(JTextField.RIGHT);
        t.setEditable(false);
        add(t, BorderLayout.NORTH);

        JPanel p = new JPanel(new GridLayout(4, 4, 5, 5));
        for (String s : "789/456*123-C0=+".split("")) {
            JButton b = new JButton(s);
            b.setFont(new Font("Arial", Font.BOLD, 22));
            b.addActionListener(e -> click(s));
            p.add(b);
        }
        add(p);

        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void click(String s) {
        if (s.matches("\\d")) {
            if (reset) { t.setText(""); reset = false; }
            t.setText(t.getText() + s);
        } else if (s.equals("C")) {
            t.setText(""); op = ""; a = 0;
        } else {
            calc();
            op = s.equals("=") ? "" : s;
            reset = true;
        }
    }

    void calc() {
        if (t.getText().isEmpty()) return;
        double b = Double.parseDouble(t.getText());
        switch (op) {
            case "+": a += b; break;
            case "-": a -= b; break;
            case "*": a *= b; break;
            case "/": a /= b; break;
            default: a = b;
        }
        t.setText(a == (long) a ? String.valueOf((long) a) : String.valueOf(a));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}