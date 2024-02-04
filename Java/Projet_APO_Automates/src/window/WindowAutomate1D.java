package window;

import metier.Automate1D;
import util.ColorAutomate1D;
import util.Exit;
import util.Parametres;
import util.RetournerMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre de visualisation pour un Automate Cellulaire 1D.
 * <p>
 * Cette classe étend {@link JFrame} pour créer une interface utilisateur dédiée à l'affichage des résultats d'une simulation
 * d'un Automate1D. Elle inclut des options pour retourner au menu principal, ajuster les paramètres de la simulation, et fermer l'application.
 * La fenêtre affiche les générations de l'automate sous forme graphique, permettant une visualisation dynamique de l'évolution de l'automate.
 * </p>
 */
public class WindowAutomate1D extends JFrame {
    /**
     * La hauteur de la fenêtre de visualisation.
     */
    private int HAUTEUR = 500;

    /**
     * La largeur de la fenêtre de visualisation.
     */
    private int LARGEUR = 500;

    /**
     * La fenêtre qui affiche les informations et les paramètres de l'automate.
     */
    WindowAutomate1DInfo window;

    /**
     * La fenêtre principale de l'application, servant de point de navigation.
     */
    WindowMain window0;

    /**
     * Le modèle d'Automate1D en cours de simulation.
     */
    Automate1D modele;

    /**
     * Constructeur pour initialiser et configurer la fenêtre de visualisation de l'Automate1D.
     *
     * @param modele Le modèle d'Automate1D dont les résultats seront visualisés.
     * @param window La fenêtre contenant les paramètres de l'automate, permettant à l'utilisateur de les ajuster.
     * @param window0 La fenêtre principale de l'application, offrant la navigation entre différentes simulations et configurations.
     */
    public WindowAutomate1D(Automate1D modele, WindowAutomate1DInfo window, WindowMain window0) {
        try {
            int rule = modele.getRule();
            String initialState = modele.getInitialState();
            int iterations = modele.getIterations();
            modele = new Automate1D(initialState, rule);

            this.window = window;
            this.window0 = window0;
            this.setTitle("Automate 1D - Résultats");
            this.setSize(LARGEUR, HAUTEUR);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            JMenuBar barre = new JMenuBar();
            JMenu MenuExit = new JMenu("Édition");
            JMenuItem Exit = new JMenuItem("Fermer l'onglet");
            this.setJMenuBar(barre);
            barre.add(MenuExit, "North");
            MenuExit.add(Exit);

            JPanel p_0 = new JPanel();

            JButton bouton_3 = new JButton("- Retour Menu -");
            p_0.add(bouton_3);

            JButton bouton_2 = new JButton("Paramètres");
            p_0.add(bouton_2);

            this.getContentPane().add(p_0, "South");

            ColorAutomate1D automatePanel = new ColorAutomate1D();
            automatePanel.addGeneration(modele.getCellules());
            JScrollPane scrollPane = new JScrollPane(automatePanel);
            scrollPane.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

            this.getContentPane().add(scrollPane, "Center");
            this.setVisible(true);

            for (int i = 0; i < iterations; i++) {
                modele.CalculProchain();
                automatePanel.addGeneration(modele.getCellules());
                this.pack();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

            bouton_3.addActionListener(new RetournerMenu(modele, window0, this));
            bouton_2.addActionListener(new Parametres(modele, window, this));
            Exit.addActionListener(new Exit(this));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(window, "Veuillez entrer des nombres valides pour la règle et les itérations.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        }
    }
}
