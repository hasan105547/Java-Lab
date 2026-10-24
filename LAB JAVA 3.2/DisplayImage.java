
import javax.swing.*;
import java.awt.*;

public class DisplayImage extends JFrame {

    DisplayImage() {
        ImageIcon image = new ImageIcon("photo.jpg");
        JLabel label = new JLabel(image);

        add(label);
        setTitle("Display Image");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayImage();
    }
}
