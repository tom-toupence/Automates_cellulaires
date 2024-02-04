package util;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de composant graphique personnalisé pour afficher les générations d'un automate cellulaire 2D avec couleurs.
 * <p>
 * Cette classe étend {@link JPanel} et permet de représenter graphiquement l'état d'un automate cellulaire 2D,
 * où chaque cellule peut être dans différents états, chacun associé à une couleur spécifique.
 * </p>
 */
public class ColorAutomate2D extends JPanel {

    /**
     * Taille des cellules lors du rendu graphique.
     */
    private int cellSize;

    /**
     * Nombre de cellules horizontalement dans la grille.
     */
    private int gridSizeX;

    /**
     * Nombre de cellules verticalement dans la grille.
     */
    private int gridSizeY;

    /**
     * Tableau des couleurs représentant l'état de chaque cellule dans la grille.
     */
    private Color[][] gridColors;

    /**
     * Constructeur pour initialiser le composant avec des valeurs par défaut.
     */
    public ColorAutomate2D() {
        super();
        cellSize = 10;
        gridSizeX = 10;
        gridSizeY = 10;
        gridColors = new Color[gridSizeY][gridSizeX];
        initializeGridColors();
    }

    /**
     * Définit la taille de chaque cellule pour le rendu graphique.
     *
     * @param cellSize La nouvelle taille des cellules en pixels.
     */
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Définit la taille de la grille pour l'automate cellulaire 2D.
     *
     * @param width  Largeur de la grille (nombre de cellules horizontalement).
     * @param height Hauteur de la grille (nombre de cellules verticalement).
     */
    public void setGridSize(int width, int height) {
        gridSizeX = width;
        gridSizeY = height;
        gridColors = new Color[gridSizeY][gridSizeX];
        initializeGridColors();
    }

    /**
     * Définit les couleurs de la grille à partir d'un tableau de couleurs.
     *
     * @param colors Tableau de couleurs représentant les états des cellules.
     */
    public void setGridColors(Color[][] colors) {
        if (colors.length == gridSizeY && colors[0].length == gridSizeX) {
            gridColors = colors;
        }
    }

    /**
     * Ajoute une nouvelle génération de cellules à la grille en fonction de leurs valeurs.
     *
     * @param gridValues Tableau des valeurs des cellules pour la génération actuelle.
     */
    public void addGeneration(int[][] gridValues) {
        if (gridValues.length == gridSizeY && gridValues[0].length == gridSizeX) {
            for (int i = 0; i < gridSizeY; i++) {
                for (int j = 0; j < gridSizeX; j++) {
                    gridColors[i][j] = getColorForValue(gridValues[i][j]);
                }
            }
            repaint();
        }
    }

    /**
     * Méthode surchargée de {@link JPanel} pour personnaliser le rendu graphique du composant.
     * <p>
     * Dessine la grille de cellules avec les couleurs correspondant à leurs états.
     * </p>
     *
     * @param g L'instance de {@link Graphics} utilisée pour le rendu graphique.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < gridSizeY; i++) {
            for (int j = 0; j < gridSizeX; j++) {
                g.setColor(gridColors[i][j]);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    /**
     * Initialise les couleurs de la grille avec la couleur blanche.
     */
    private void initializeGridColors() {
        for (int i = 0; i < gridSizeY; i++) {
            for (int j = 0; j < gridSizeX; j++) {
                gridColors[i][j] = Color.WHITE;
            }
        }
    }

    /**
     * Retourne la couleur associée à une valeur de cellule spécifique.
     *
     * @param value La valeur de la cellule.
     * @return La couleur correspondant à la valeur de la cellule.
     */
    public Color getColorForValue(int value) {
        switch (value) {
            case 0: return Color.GRAY;
            case 1: return Color.GREEN;
            case 2: return Color.RED;
            case 3: return Color.BLACK;
            default: return Color.GRAY;
        }
    }
}
