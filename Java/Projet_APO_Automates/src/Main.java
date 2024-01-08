public class Main {
    public Main() {
    }

    public static void main(String[] args) {
    /*
        WindowMain window = new WindowMain();
        window.setVisible(true);
    */

        int TailleAutomate1D = 10;
        Automate1D automate1D = new Automate1D(TailleAutomate1D);
        int NombreEtapes = 2;

        for(int etapes = 0; etapes < NombreEtapes; ++etapes) {
            automate1D.AfficherEtat();
            automate1D.CalculProchain();
        }

    }
}
