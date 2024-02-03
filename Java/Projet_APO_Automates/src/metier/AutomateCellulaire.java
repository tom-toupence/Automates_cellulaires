package metier;

public abstract class AutomateCellulaire {
    protected int rule;
    protected int length;

    public AutomateCellulaire(int rule, int length) {
        this.rule = rule;
        this.length = length;
    }

    // Getters et setters
    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Méthode abstraite pour calculer la prochaine génération
    public abstract void CalculProchain();
}

