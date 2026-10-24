import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentForm extends JFrame {
    JTextField id = new JTextField(15), name = new JTextField(15), email = new JTextField(15);
    JRadioButton male = new JRadioButton("Male"), female = new JRadioButton("Female");
    JComboBox<String> course = new JComboBox<>(new String[]{"CSE", "IT", "EEE", "BBA"});
    DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Email", "Gender", "Course"}, 0);

    StudentForm() {
        super("Student Form");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female);
        JButton submit = new JButton("Submit"), clear = new JButton("Clear");

        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        form.add(new JLabel("ID:"));     form.add(id);
        form.add(new JLabel("Name:"));   form.add(name);
        form.add(new JLabel("Email:"));  form.add(email);
        form.add(new JLabel("Gender:")); form.add(new JPanel() {{ add(male); add(female); }});
        form.add(new JLabel("Course:")); form.add(course);
        form.add(submit);                form.add(clear);

        submit.addActionListener(e -> {
            if (id.getText().isBlank() || name.getText().isBlank() || email.getText().isBlank()
                    || !(male.isSelected() || female.isSelected())) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
                return;
            }
            model.addRow(new Object[]{id.getText(), name.getText(), email.getText(),
                    male.isSelected() ? "Male" : "Female", course.getSelectedItem()});
            clear.doClick();
        });
        clear.addActionListener(e -> {
            id.setText(""); name.setText(""); email.setText("");
            bg.clearSelection(); course.setSelectedIndex(0);
        });

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(new JTable(model)), BorderLayout.CENTER);
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentForm().setVisible(true));
    }
}