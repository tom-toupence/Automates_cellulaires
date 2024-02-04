package metier;

public abstract class AutomateCellulaire {

    protected int length;

    public AutomateCellulaire( int length) {

        this.length = length;
    }

    // Getters et setters


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Méthode abstraite pour calculer la prochaine génération
    public abstract void CalculProchain();

    public abstract String afficherEtat();
}

