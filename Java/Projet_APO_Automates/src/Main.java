import metier.Automate1D;
import metier.FeuDeForet;
import window.WindowMain;

/**
 * Classe principale du programme qui initialise et lance l'application.
 * <p>
 * Cette classe crée des instances des modèles Automate1D et FeuDeForet,
 * ainsi qu'une instance de WindowMain pour l'interface utilisateur. Elle configure
 * ensuite la fenêtre pour qu'elle soit visible, lançant ainsi l'interface utilisateur
 * de l'application.
 * </p>
 */
public class Main {
    /**
     * Point d'entrée principal du programme.
     * <p>
     * Cette méthode crée et initialise les modèles Automate1D et FeuDeForet,
     * ainsi que l'interface utilisateur principale de l'application. Elle rend
     * la fenêtre de l'application visible à l'utilisateur, démarrant ainsi
     * l'interaction avec l'application.
     * </p>
     * @param args Arguments de ligne de commande (non utilisés).
     */
    public static void main(String[] args) {


        Automate1D modele = new Automate1D();
        FeuDeForet modeleFeuDeForet = new FeuDeForet();
        WindowMain window = new WindowMain(modele,modeleFeuDeForet);
        window.setVisible(true);



    }
}

