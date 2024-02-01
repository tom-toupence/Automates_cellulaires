public class Automate1D {
    private Cellule[] cellules;
    private int[] regle = {1, 1, 1, 1, 1, 1, 1, 0};

    public Automate1D(String initialState) {
        this.cellules = new Cellule[initialState.length()];
        for (int i = 0; i < initialState.length(); i++) {
            this.cellules[i] = new Cellule(Character.getNumericValue(initialState.charAt(i)));
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

    public void AfficherEtat() {
        for (Cellule cellule : cellules) {
            System.out.print(cellule.getValue());
        }
        System.out.println();
    }
}
