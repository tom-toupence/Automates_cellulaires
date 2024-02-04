package metier;


public class AutomateCellulaire2D extends AutomateCellulaire {
    protected int[][] grid; // Grille représentant l'état des cellules
    protected int height;

    public AutomateCellulaire2D(int length, int height) {
        super(length);
        this.height = height;
        this.grid = new int[height][length];
    }

    // Méthode pour obtenir l'état d'une cellule
    protected int getState(int x, int y) {
        return grid[x][y];
    }

    // Méthode pour définir l'état d'une cellule
    protected void setState(int x, int y, int state) {
        grid[x][y] = state;
    }

    // Méthode pour mettre à jour la grille entière
    protected void setGrid(int[][] newGrid) {
        this.grid = newGrid;
    }

    @Override
    public void CalculProchain() {

        int a =0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

