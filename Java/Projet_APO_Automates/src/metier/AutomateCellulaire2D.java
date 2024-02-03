package metier;

public class AutomateCellulaire2D extends AutomateCellulaire {
    protected int height;

    public AutomateCellulaire2D(int rule, int length, int height) {
        super(rule, length);
        this.height = height;
    }

    // Getter et setter pour height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void CalculProchain() {
        int a = 2;

    }
}

