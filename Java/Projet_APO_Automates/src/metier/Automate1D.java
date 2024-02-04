package metier;

/**
 * Classe représentant un automate cellulaire 1D, une extension spécifique d'un automate cellulaire.
 * <p>
 * Cette classe gère un ensemble de cellules dans un espace unidimensionnel où chaque cellule
 * peut être dans un état de 0 ou 1. L'évolution des états des cellules est déterminée par une règle
 * spécifique et l'état initial des cellules.
 * </p>
 */
public class Automate1D extends AutomateCellulaire1D {
    /**
     * Tableau de cellules représentant l'état actuel de l'automate.
     */
    private Cellule[] cellules;

    /**
     * Tableau représentant la règle de transition des états des cellules.
     */
    private int[] regle;

    /**
     * Chaîne de caractères représentant l'état initial des cellules de l'automate.
     */
    private String initialState;

    /**
     * Nombre d'itérations effectuées par l'automate.
     */
    private int iterations;

    /**
     * Constructeur par défaut qui initialise un automate avec une règle vide.
     */
    public Automate1D() {
        super(0, 0);
        this.regle = new int[8];
    }

    /**
     * Constructeur qui initialise un automate avec un état initial et un numéro de règle.
     * @param initialState Chaîne de caractères représentant l'état initial des cellules.
     * @param ruleNumber Numéro de la règle de transition à appliquer.
     */
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

    /**
     * Calcule la prochaine génération de cellules en fonction de la règle actuelle.
     */
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

    /**
     * Retourne une chaîne de caractères représentant l'état actuel des cellules.
     * @return L'état actuel des cellules sous forme de chaîne de caractères.
     */
    public String afficherEtat() {
        StringBuilder sb = new StringBuilder();
        for (Cellule cellule : cellules) {
            sb.append(cellule.getValue() == 1 ? "1" : "0");
        }
        return sb.toString();
    }

    /**
     * Retourne le tableau des cellules de l'automate.
     * @return Le tableau des cellules actuelles de l'automate.
     */
    public Cellule[] getCellules() {
        return cellules;
    }

    /**
     * Définit le tableau des cellules de l'automate.
     * @param cellules Le nouveau tableau de cellules de l'automate.
     */
    public void setCellules(Cellule[] cellules) {
        this.cellules = cellules;
    }

    /**
     * Retourne le tableau représentant la règle de transition des cellules.
     * @return Le tableau de règles utilisé pour la transition des cellules.
     */
    public int[] getRegle() {
        return regle;
    }

    /**
     * Définit le tableau de règles pour la transition des cellules.
     * @param regle Le nouveau tableau de règles.
     */
    public void setRegle(int[] regle) {
        this.regle = regle;
    }

    /**
     * Retourne l'état initial des cellules de l'automate sous forme de chaîne de caractères.
     * @return L'état initial des cellules.
     */
    public String getInitialState() {
        return initialState;
    }

    /**
     * Définit l'état initial des cellules de l'automate.
     * @param initialState La chaîne de caractères représentant l'état initial.
     */
    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    /**
     * Retourne le nombre d'itérations effectuées par l'automate.
     * @return Le nombre d'itérations.
     */
    public int getIterations() {
        return iterations;
    }

    /**
     * Définit le nombre d'itérations que l'automate doit effectuer.
     * @param iterations Le nouveau nombre d'itérations.
     */
    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
