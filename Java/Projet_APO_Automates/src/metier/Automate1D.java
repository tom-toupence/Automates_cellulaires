package metier;

public class Automate1D extends AutomateCellulaire1D {
    private Cellule[] cellules;
    private int[] regle;
    private String initialState;
    private int iterations;


    public Automate1D() {
        super(0, 0);
        this.regle = new int[8];
    }

    public Automate1D(String initialState, int ruleNumber) {
        super(ruleNumber, initialState.length());
        this.initialState = initialState;
        this.regle = new int[8];
        this.cellules = new Cellule[initialState.length()];
        for (int i = 0; i < initialState.length(); i++) {
            this.cellules[i] = new Cellule(Character.getNumericValue(initialState.charAt(i)));
        }

        String binaryString = Integer.toBinaryString(ruleNumber);
        binaryString = String.format("%8s", binaryString).replace(' ', '0');

        for (int i = 0; i < 8; i++) {
            regle[i] = binaryString.charAt(i) == '1' ? 1 : 0;
        }
        this.rule = ruleNumber;
    }

    @Override
    public void CalculProchain() {
        Cellule[] nouvelleGeneration = new Cellule[cellules.length];
        for (int i = 0; i < cellules.length; i++) {
            int gauche = i > 0 ? cellules[i - 1].getValue() : 0;
            int centre = cellules[i].getValue();
            int droite = i < cellules.length - 1 ? cellules[i + 1].getValue() : 0;

            int index = gauche * 4 + centre * 2 + droite;
            int nouvelleValeur = regle[7 - index];

            nouvelleGeneration[i] = new Cellule(nouvelleValeur);
        }
        cellules = nouvelleGeneration;
    }

    public String afficherEtat() {
        StringBuilder sb = new StringBuilder();
        for (Cellule cellule : cellules) {
            sb.append(cellule.getValue() == 1 ? "1" : "0");
        }
        return sb.toString();
    }


    public Cellule[] getCellules() {
        return cellules;
    }

    public void setCellules(Cellule[] cellules) {
        this.cellules = cellules;
    }

    public int[] getRegle() {
        return regle;
    }

    public void setRegle(int[] regle) {
        this.regle = regle;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
