package window;

import metier.Automate1D;
import metier.FeuDeForet;
import util.ColorAutomate2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowFeuDeForet extends JFrame {

    private int HAUTEUR = 500;
    private int LARGEUR = 500;
    private WindowFeuDeForetInfo window;
    private WindowMain window0;
    private FeuDeForet modele;
    private Timer timer;
    private int currentIteration;

    private FeuDeForet feuDeForet;
    private ColorAutomate2D automatePanel;
    private int largeur;
    private int hauteur;

    public WindowFeuDeForet(FeuDeForet modele, WindowFeuDeForetInfo window, WindowMain window0) {


        this.feuDeForet = modele;
        this.largeur = feuDeForet.getLength();
        this.hauteur = feuDeForet.getHeight();

        this.setTitle("Feu de Forêt");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        automatePanel = new ColorAutomate2D();
        automatePanel.setCellSize(10); // Taille des cellules
        automatePanel.setGridSize(largeur, hauteur);
        JScrollPane scrollPane = new JScrollPane(automatePanel);

        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton startButton = new JButton("Démarrer");
        startButton.addActionListener(e -> startSimulation());
        this.getContentPane().add(startButton, BorderLayout.SOUTH);

        this.setVisible(true);
        /*try {

            // Création du modèle
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

            // Menu en haut
            JMenuBar barre = new JMenuBar();
            JMenu MenuExit = new JMenu("Édition");
            JMenuItem Exit = new JMenuItem("Fermer l'onglet");
            this.setJMenuBar(barre);
            barre.add(MenuExit, "North");
            MenuExit.add(Exit);
            // Fin Menu en haut

            // Menu en bas
            JPanel p_0 = new JPanel();

            JButton bouton_3 = new JButton("- Retour Menu -");
            p_0.add(bouton_3);

            JButton bouton_2 = new JButton("Paramètres");
            p_0.add(bouton_2);

            this.getContentPane().add(p_0, "South");
            // Fin Menu en bas

            ColorAutomate1D automatePanel = new ColorAutomate1D();
            JScrollPane scrollPane = new JScrollPane(automatePanel);
            scrollPane.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

            this.getContentPane().add(scrollPane, "Center");
            this.setVisible(true);

            currentIteration = 0;

            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIteration < iterations) {
                        modele.CalculProchain();
                        automatePanel.addGeneration(modele.getCellules());
                        pack();
                        currentIteration++;
                    } else {
                        timer.stop(); // Arrête le timer une fois toutes les itérations terminées
                    }
                }
            });

            timer.start(); // Démarre le timer pour commencer l'animation

            bouton_3.addActionListener(new RetournerMenu(modele, window0, this));
            bouton_2.addActionListener(new Parametres(modele, window, this));
            Exit.addActionListener(new Exit(this));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(window, "Veuillez entrer des nombres valides pour la règle et les itérations.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        }
        */

    }


    private void startSimulation() {
        Timer timer = new Timer(100, e -> {
            feuDeForet.CalculProchain();
            int[][] grid = feuDeForet.getGrid();
            Color[][] gridColors = new Color[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int value = grid[i][j];
                    gridColors[i][j] = automatePanel.getColorForValue(value);
                }
            }

            automatePanel.setGridColors(gridColors);
            automatePanel.repaint();
        });

        timer.start();
    }







}
