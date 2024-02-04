package metier;

public class AutomateCellulaire1D extends AutomateCellulaire {
    protected int rule;
    public AutomateCellulaire1D(int rule, int length) {
        super(length);
        setRule(rule);
    }
    public String  afficherEtat(){
     return "no etat";
    }

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }
    @Override
    public void CalculProchain() {
    }
}

