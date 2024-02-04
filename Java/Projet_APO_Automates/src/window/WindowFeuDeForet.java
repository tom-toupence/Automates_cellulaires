package window;

import metier.Automate1D;
import metier.FeuDeForet;
import util.*;

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
        this.hauteur = feuDeForet.getHeight(); // CORRIGER ICI BUG LORS DU START MAIN L32


        this.setTitle("Feu de Forêt");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        automatePanel = new ColorAutomate2D();
        automatePanel.setCellSize(10); // Taille des cellules
        automatePanel.setGridSize(largeur, hauteur);
        JScrollPane scrollPane = new JScrollPane(automatePanel);

        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton startButton = new JButton("Démarrer");
        startButton.addActionListener(e -> startSimulation());
        this.getContentPane().add(startButton, BorderLayout.SOUTH);
        bouton_3.addActionListener(new RetournerMenuFeuDeForet(modele, window0, this));
        bouton_2.addActionListener(new ParametresFeuDeForet(modele, window, this));
        Exit.addActionListener(new Exit(this));
        this.setVisible(true);


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
