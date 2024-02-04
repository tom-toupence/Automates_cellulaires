package window;

import metier.Automate1D;
import util.Automate1D_results;
import window.WindowMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Fenêtre pour saisir les informations et démarrer une simulation de l'Automate1D.
 * <p>
 * Cette classe étend {@link JFrame} pour créer une interface permettant à l'utilisateur de saisir les paramètres
 * d'une simulation de l'Automate1D, tels que la règle, la configuration initiale et le nombre d'itérations, avant de lancer la simulation.
 * </p>
 */
public class WindowAutomate1DInfo extends JFrame {
    /**
     * Hauteur de la fenêtre de configuration.
     */
    private int HAUTEUR = 150;

    /**
     * Largeur de la fenêtre de configuration.
     */
    private int LARGEUR = 450;

    /**
     * Fenêtre principale de l'application qui permet l'accès à différentes fonctionnalités.
     */
    WindowMain window;

    /**
     * Modèle d'Automate1D pour lequel configurer les paramètres et exécuter la simulation.
     */
    Automate1D modele;

    /**
     * Constructeur pour initialiser la fenêtre de saisie des informations de l'Automate1D.
     * <p>
     * Initialise la fenêtre avec un formulaire permettant à l'utilisateur de saisir les paramètres de la simulation.
     * Les paramètres incluent la règle de l'automate, la configuration initiale et le nombre d'itérations souhaitées.
     * </p>
     *
     * @param window La fenêtre principale de l'application, permettant de naviguer entre différentes vues.
     * @param modele Le modèle d'Automate1D à configurer pour la simulation, contenant la logique de l'automate.
     */
    public WindowAutomate1DInfo(WindowMain window, Automate1D modele){
        this.window=window;
        this.modele=modele;
        this.setTitle("Automate 1D");
        this.setSize(LARGEUR, HAUTEUR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel ruleLabel = new JLabel("Règle (0-255):");
        JTextField ruleField = new JTextField();
        JLabel initialStateLabel = new JLabel("Configuration initiale:");
        JTextField initialStateField = new JTextField();
        JLabel iterationsLabel = new JLabel("Nombre d'itérations:");
        JTextField iterationsField = new JTextField();
        JButton startButton = new JButton("Démarrer");

        // Ajoute les composants au panneau
        panel.add(ruleLabel);
        panel.add(ruleField);
        panel.add(initialStateLabel);
        panel.add(initialStateField);
        panel.add(iterationsLabel);
        panel.add(iterationsField);
        panel.add(new JLabel(""));
        panel.add(startButton);

        this.getContentPane().add(panel);
        this.setVisible(true);

        startButton.addActionListener(e -> {
            try {
                modele.setRule(Integer.parseInt(ruleField.getText()));
                modele.setInitialState(initialStateField.getText());
                modele.setIterations(Integer.parseInt(iterationsField.getText()));
                Automate1D_results resultsListener = new Automate1D_results(this, window, modele);
                resultsListener.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, null));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides pour la règle et les itérations.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
