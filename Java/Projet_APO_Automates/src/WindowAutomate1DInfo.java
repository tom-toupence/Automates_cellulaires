import javax.swing.*;
import java.awt.*;

public class WindowAutomate1DInfo extends JFrame {
    private int HAUTEUR=150;
    private int LARGEUR=450;
    WindowMain window;
    Automate1D modele;

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

                new WindowAutomate1D(modele, this);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides pour la règle et les itérations.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
