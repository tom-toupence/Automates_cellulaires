package util;

import metier.Cellule;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe de composant graphique personnalisé pour afficher les générations d'un automate cellulaire 1D avec couleur.
 * <p>
 * Cette classe étend {@link JPanel} et est conçue pour représenter graphiquement les différentes générations d'un automate cellulaire 1D,
 * où chaque cellule peut être dans un état actif ou inactif, représenté par les couleurs noir ou blanc.
 * </p>
 */
public class ColorAutomate1D extends JPanel {
    /**
     * Liste stockant les générations successives de cellules de l'automate.
     */
    private ArrayList<Cellule[]> generations = new ArrayList<>();

    /**
     * Taille des cellules lors du rendu graphique.
     */
    private final int cellSize = 10;

    /**
     * Ajoute une nouvelle génération de cellules à la liste des générations pour l'affichage et déclenche un repaint du composant.
     *
     * @param cellules Le tableau de cellules représentant la nouvelle génération à ajouter.
     */
    public void addGeneration(Cellule[] cellules) {
        generations.add(cellules);
        repaint();
    }

    /**
     * Méthode surchargée de {@link JPanel} pour personnaliser le rendu graphique du composant.
     * <p>
     * Dessine chaque génération de cellules sur le composant, où chaque cellule est représentée par un carré de taille {@code cellSize}.
     * Les cellules actives sont dessinées en noir, tandis que les cellules inactives sont en blanc.
     * </p>
     *
     * @param g L'instance de {@link Graphics} utilisée pour le rendu graphique.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int gen = 0; gen < generations.size(); gen++) {
            Cellule[] cellules = generations.get(gen);
            for (int i = 0; i < cellules.length; i++) {
                g.setColor(cellules[i].getValue() == 1 ? Color.BLACK : Color.WHITE);
                int x = i * cellSize;
                int y = gen * cellSize;
                g.fillRect(x, y, cellSize, cellSize);
            }
        }
    }
}
