import metier.Automate1D;
import metier.FeuDeForet;
import window.WindowMain;

public class Main {
    public static void main(String[] args) {


        Automate1D modele = new Automate1D();
        FeuDeForet modeleFeuDeForet = new FeuDeForet();
        WindowMain window = new WindowMain(modele,modeleFeuDeForet);
        window.setVisible(true);



    }
}

