package window;

import metier.FeuDeForet;
import util.FeuDeForetResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WindowFeuDeForetInfo extends JFrame {

    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;

    private final WindowMain window;
    private final FeuDeForet modele;

    public WindowFeuDeForetInfo(WindowMain window, FeuDeForet modele) {
        this.window = window;
        this.modele = modele;

        setTitle("Feu de Forêt 2D");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // 6 lignes, 2 colonnes, avec espacements

        JLabel largeurHauteurLabel = new JLabel("Hauteur et Largeur de la grille :");
        JTextField largeurHauteurField = new JTextField();
        JLabel densiteForetLabel = new JLabel("Densité de la forêt :(0 à 1) ");
        JTextField densiteForetField = new JTextField();
        JLabel nbFeuInitiauxLabel = new JLabel("Nombre de feux initiaux :(1 à n) ");
        JTextField nbFeuInitiauxField = new JTextField();
        JLabel directionVentLabel = new JLabel("Direction du vent : (Nord,Sud,Est ou Ouest)");
        JTextField directionVentField = new JTextField();
        JLabel forceVentLabel = new JLabel("Force du vent : (0 à 1)");
        JTextField forceVentField = new JTextField();
        JLabel forceFeuLabel = new JLabel("Probabilité d'ignition par le feu : (0 à 1)");
        JTextField forceFeuField = new JTextField();


        inputPanel.add(largeurHauteurLabel);
        inputPanel.add(largeurHauteurField);
        inputPanel.add(densiteForetLabel);
        inputPanel.add(densiteForetField);
        inputPanel.add(nbFeuInitiauxLabel);
        inputPanel.add(nbFeuInitiauxField);
        inputPanel.add(directionVentLabel);
        inputPanel.add(directionVentField);
        inputPanel.add(forceVentLabel);
        inputPanel.add(forceVentField);
        inputPanel.add(forceFeuLabel);
        inputPanel.add(forceFeuField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton("Démarrer");
        buttonPanel.add(startButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);

        startButton.addActionListener(e -> {
            try {
                modele.setHeight(Integer.parseInt(largeurHauteurField.getText()));
                modele.setLength(Integer.parseInt(largeurHauteurField.getText()));

                modele.setDensiteForet(Double.parseDouble(densiteForetField.getText()));
                modele.setInitialFeux(Integer.parseInt(nbFeuInitiauxField.getText()));

                String ventDirection = directionVentField.getText().toLowerCase();
                switch (ventDirection) {
                    case "ouest":
                        modele.setVentDirection(180);
                        break;
                    case "nord":
                        modele.setVentDirection(0);
                        break;
                    case "sud":
                        modele.setVentDirection(90);
                        break;
                    case "est":
                        modele.setVentDirection(270);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Direction du vent invalide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                        return; // Sortir de la méthode en cas d'erreur
                }

                modele.setVentForce(Double.parseDouble(forceVentField.getText()));
                modele.setProbaFeu(Double.parseDouble(forceFeuField.getText()));
                int[][] grid = new int[Integer.parseInt(largeurHauteurField.getText())][Integer.parseInt(largeurHauteurField.getText())];
                modele.setGrid(grid);
                modele.initialiserForet(Double.parseDouble(densiteForetField.getText()),Integer.parseInt(nbFeuInitiauxField.getText()));

                FeuDeForetResult resultsListener = new FeuDeForetResult(this, window, modele);
                resultsListener.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, null));


            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}