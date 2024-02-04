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
        // Check if the indices are within the grid bounds before setting the state
        if (x >= 0 && x < height && y >= 0 && y < length) {
            grid[x][y] = state; // Corrected to use 'y' instead of '1'
        } else {
            // Optionally, throw an exception or log an error if indices are out of bounds
            System.err.println("Index out of bounds: (" + x + ", " + y + ")");
        }
    }


    // Méthode pour mettre à jour la grille entière
    public void setGrid(int[][] newGrid) {
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

