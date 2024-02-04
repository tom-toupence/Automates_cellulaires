package window;

import metier.Automate1D;
import metier.FeuDeForet;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre de visualisation pour la simulation d'un feu de forêt.
 * <p>
 * Cette classe fournit une interface graphique pour visualiser la progression d'une simulation de feu de forêt,
 * avec des fonctionnalités pour démarrer la simulation, la mettre en pause, et ajuster divers paramètres via une interface dédiée.
 * Elle intègre également des boutons pour retourner au menu principal et ajuster les paramètres de la simulation.
 * </p>
 */
public class WindowFeuDeForet extends JFrame {

    /**
     * Référence à la fenêtre d'informations et de paramètres pour la simulation du feu de forêt.
     */
    private WindowFeuDeForetInfo window;
    /**
     * Référence à la fenêtre principale de l'application.
     */
    private WindowMain window0;
    /**
     * Timer utilisé pour actualiser la visualisation de la simulation à intervalles réguliers.
     */
    private Timer timer;

    private int currentIteration;
    /**
     * Modèle de simulation de feu de forêt utilisé pour la visualisation.
     */
    private FeuDeForet feuDeForet;
    /**
     * Composant graphique personnalisé pour la visualisation de l'automate cellulaire en deux dimensions.
     */
    private ColorAutomate2D automatePanel;
    /**
     * Largeur par défaut de la fenêtre de visualisation.
     */
    private int largeur;
    /**
     * Hauteur par défaut de la fenêtre de visualisation.
     */
    private int hauteur;

    /**
     * Constructeur initialisant la fenêtre de visualisation avec les composants nécessaires.
     *
     * @param modele Le modèle de simulation de feu de forêt.
     * @param window La fenêtre d'informations pour le feu de forêt.
     * @param window0 La fenêtre principale de l'application.
     */
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

        JButton startButton = new JButton("Démarrer");
        p_0.add(startButton);

        JButton bouton_2 = new JButton("Paramètres");
        p_0.add(bouton_2);



        automatePanel = new ColorAutomate2D();
        automatePanel.setCellSize(10); // Taille des cellules
        automatePanel.setGridSize(largeur, hauteur);
        JScrollPane scrollPane = new JScrollPane(automatePanel);

        this.getContentPane().add(scrollPane, BorderLayout.CENTER);


        startButton.addActionListener(e -> startSimulation());
        this.getContentPane().add(p_0, BorderLayout.SOUTH);
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
