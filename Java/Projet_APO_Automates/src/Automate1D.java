public class Automate1D {
    private Cellule[] Cellule;

    public Automate1D(int tailleCellule) {

        this.Cellule = new Cellule[tailleCellule];
        for (int i = 0; i < tailleCellule; i++) {
            Cellule[i] = new Cellule(0); // Initialisation à 0 par défaut de toutes les cases
            Cellule[tailleCellule / 2].setValue(1); // On initialise la case du milieu à 1
        }
    }

    public void CalculProchain() {
    }

    public void AfficherEtat() {

    }
}
