package metier;


public class AutomateCellulaire2D extends AutomateCellulaire {
    protected int[][] grid;
    protected int height;

    public AutomateCellulaire2D(int length, int height) {
        super(length);
        this.height = height;
        this.grid = new int[height][length];
    }

    protected int getState(int x, int y) {
        return grid[x][y];
    }

    public String afficherEtat(){ return "noEtat";}

    protected void setState(int x, int y, int state) {
        if (x >= 0 && x < height && y >= 0 && y < length) {
            grid[x][y] = state;
        }
    }


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

