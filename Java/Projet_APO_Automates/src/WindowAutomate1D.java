import javax.swing.*;
import java.awt.*;

public class WindowAutomate1D extends JFrame {
    private int HAUTEUR=500;
    private int LARGEUR=500;
    WindowAutomate1DInfo window;
    Automate1D modele;

    public WindowAutomate1D(Automate1D modele, WindowAutomate1DInfo window) {
        try {
        //création modèle
        int rule = modele.getRule();
        String initialState = modele.getInitialState();
        int iterations = modele.getIterations();
        modele = new Automate1D(initialState, rule);

        this.window = window;
        this.setTitle("Automate 1D - Résultats");
        this.setSize(LARGEUR, HAUTEUR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

            //Menu en haut
            JMenuBar barre = new JMenuBar();
            JMenu MenuFichier = new JMenu("Fichier");
            JMenuItem EnregistrerSous = new JMenuItem("Enregistrer Sous");
            JMenuItem Ouvrir = new JMenuItem("Ouvrir");
            JMenu MenuExit = new JMenu("Édition");
            JMenuItem Exit = new JMenuItem("Fermer l'onglet");
            this.setJMenuBar(barre);
            barre.add(MenuFichier,"North");
            barre.add(MenuExit);
            MenuExit.add(Exit);
            MenuFichier.add(EnregistrerSous);
            MenuFichier.add(Ouvrir);
            //Fin Menu en haut

            //Menu en bas
            JPanel p_0 = new JPanel();

            JButton bouton_3 = new JButton("- Retour Menu -");
            p_0.add(bouton_3);

            JButton bouton_2 = new JButton("Paramètres");
            p_0.add(bouton_2);

            this.getContentPane().add(p_0,"South");
            //Fin Menu en bas

        ColorAutomate1D automatePanel = new ColorAutomate1D();
        automatePanel.addGeneration(modele.getCellules());
        JScrollPane scrollPane = new JScrollPane(automatePanel);
        scrollPane.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

        this.getContentPane().add(scrollPane,"Center");
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
    }catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(window, "Veuillez entrer des nombres valides pour la règle et les itérations.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
    }
    }
}
