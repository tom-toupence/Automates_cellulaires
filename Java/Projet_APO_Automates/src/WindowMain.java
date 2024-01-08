import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame {
    private final int height = 450;
    private final int width = 450;

    public WindowMain() {
        this.setTitle("Automates - Menu");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(3);
        this.setLocation(475, 300);
        JPanel p = new JPanel();
        JLabel label = new JLabel();
        ImageIcon image_logo = new ImageIcon("logo-min.png");
        label.setIcon(image_logo);
        p.add(label);
        JButton button_1 = new JButton("Automate 1D");
        p.add(button_1);
        JButton button_2 = new JButton("Feu de Forêt");
        p.add(button_2);
        this.setBackground(Color.white);
        p.setBackground(Color.white);
        this.getContentPane().add(p);
    }
}
