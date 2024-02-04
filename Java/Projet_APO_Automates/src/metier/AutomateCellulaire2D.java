package metier;

/**
 * Classe représentant un automate cellulaire 2D, une extension spécifique d'un automate cellulaire.
 * <p>
 * Cette classe gère une grille de cellules dans un espace bidimensionnel, où chaque cellule
 * peut être dans différents états. L'évolution des états des cellules est déterminée par des règles
 * spécifiques à implémenter dans les sous-classes.
 * </p>
 */
public class AutomateCellulaire2D extends AutomateCellulaire {
    /**
     * Grille représentant les états des cellules dans l'espace bidimensionnel.
     */
    protected int[][] grid;

    /**
     * Hauteur de la grille de cellules.
     */
    protected int height;

    /**
     * Constructeur pour initialiser un automate cellulaire 2D avec des dimensions spécifiques.
     * @param length Largeur de la grille de cellules.
     * @param height Hauteur de la grille de cellules.
     */
    public AutomateCellulaire2D(int length, int height) {
        super(length);
        this.height = height;
        this.grid = new int[height][length];
    }

    /**
     * Récupère l'état d'une cellule à une position donnée.
     * @param x Position X de la cellule dans la grille.
     * @param y Position Y de la cellule dans la grille.
     * @return L'état de la cellule à la position spécifiée.
     */
    protected int getState(int x, int y) {
        return grid[x][y];
    }

    /**
     * Définit l'état d'une cellule à une position donnée.
     * @param x Position X de la cellule dans la grille.
     * @param y Position Y de la cellule dans la grille.
     * @param state Nouvel état de la cellule.
     */
    protected void setState(int x, int y, int state) {
        if (x >= 0 && x < height && y >= 0 && y < length) {
            grid[x][y] = state;
        }
    }

    /**
     * Remplace la grille actuelle par une nouvelle grille.
     * @param newGrid La nouvelle grille de cellules.
     */
    public void setGrid(int[][] newGrid) {
        this.grid = newGrid;
    }

    /**
     * Retourne la hauteur de la grille de cellules.
     * @return La hauteur de la grille.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Définit la hauteur de la grille de cellules.
     * @param height La nouvelle hauteur de la grille.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Méthode abstraite pour calculer la prochaine génération de cellules.
     * Doit être implémentée par les sous-classes pour spécifier la logique d'évolution des cellules.
     */
    @Override
    public void CalculProchain() {
    }

    /**
     * Retourne un état représentatif de la grille pour l'affichage.
     * @return Une chaîne de caractères représentant l'état actuel de la grille.
     */
    @Override
    public String afficherEtat() {
        return "noEtat"; // Doit être implémenté pour retourner un état significatif.
    }
}
