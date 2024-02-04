package window;

import metier.Automate1D;
import metier.FeuDeForet;
import util.Automate1D_info;
import util.FeuDeForetInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Fenêtre principale de l'application qui affiche le menu permettant à l'utilisateur de choisir entre différentes simulations.
 * Cette fenêtre sert de point d'entrée pour lancer les simulations d'Automate Cellulaire 1D et de Feu de Forêt.
 */
public class WindowMain extends JFrame {
    /**
     * Hauteur de la fenêtre principale.
     */
    private final int height = 450;

    /**
     * Largeur de la fenêtre principale.
     */
    private final int width = 450;

    /**
     * Modèle d'Automate1D utilisé pour la simulation d'automate cellulaire 1D.
     */
    Automate1D modele;

    /**
     * Initialise et configure la fenêtre principale avec les boutons permettant de lancer les simulations d'Automate Cellulaire 1D et de Feu de Forêt.
     *
     * @param modele            Le modèle d'Automate1D pour la simulation d'automate cellulaire 1D.
     * @param modeleFeuDeForet  Le modèle de FeuDeForet pour la simulation de feu de forêt.
     */
    public WindowMain(Automate1D modele, FeuDeForet modeleFeuDeForet) {
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
        button_2.addActionListener(new FeuDeForetInfo(this,new FeuDeForet()));
    }
}
