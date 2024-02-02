import java.util.Arrays;

public class Automate1D{
    private Cellule[] cellules;
    private int[] regle;
    private int rule;
    private String initialState;
    private int iterations;

    //Constructeur par défaut
    public Automate1D(){
        this.regle = new int[8];
    }

    public Automate1D(String initialState, int ruleNumber) {
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
    }

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

    public String AfficherEtat() {
        StringBuilder sb = new StringBuilder();
        for (Cellule cellule : cellules) {
            sb.append(cellule.getValue() == 1 ? "1" : "0");
        }
        return sb.toString();
    }

    //Getteurs & Setteurs

    public Cellule[] getCellules() {
        return cellules;
    }

    public int getRule(){
        return this.rule;
    }

    public void setRule(int rule){
        this.rule = rule;
    }

    public String getInitialState(){
        return this.initialState;
    }

    public void setInitialState(String initialState){
        this.initialState = initialState;
    }

    public int getIterations(){
        return this.iterations;
    }

    public void setIterations(int iterations){
        this.iterations = iterations;
    }

}
