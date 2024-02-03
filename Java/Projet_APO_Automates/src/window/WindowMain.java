package window;

import metier.Automate1D;
import util.Automate1D_info;

import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame {
    private final int height = 450;
    private final int width = 450;
    Automate1D modele;

    public WindowMain(Automate1D modele) {
        this.modele=modele;
        this.setTitle("Automates - Menu");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);

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

        //ajouter des actions aux boutons
        button_1.addActionListener(new Automate1D_info(this, modele));
    }
}
