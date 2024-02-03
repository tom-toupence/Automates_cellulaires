import metier.Automate1D;
import metier.FeuDeForet;
import window.WindowMain;

public class Main {
    public static void main(String[] args) {

        /*Automate1D modele = new Automate1D();
        WindowMain window = new WindowMain(modele);
        window.setVisible(true);*/

        int length = 10; // Largeur de la grille
        int height = 10; // Hauteur de la grille
        double densiteForet = 0.6; // Densité de la forêt
        double probaIgnition = 0.3; // Probabilité d'ignition d'une cellule forêt
        double probaSpontaneousFire = 0.05; // Probabilité qu'une cellule forêt s'enflamme spontanément

        // Création de l'instance de FeuDeForet
        FeuDeForet feuDeForet = new FeuDeForet(length, height, densiteForet, probaIgnition, probaSpontaneousFire);

        // Simulation sur plusieurs itérations
        for (int i = 0; i < 10; i++) {
            System.out.println("Itération " + (i + 1));
            feuDeForet.CalculProchain();
            // Affichage de l'état actuel de la forêt
            // Vous devez implémenter une méthode d'affichage dans FeuDeForet pour voir le résultat
            feuDeForet.afficherForet();
            // Pause pour visualisation
            try {
                Thread.sleep(1000); // 1000 millisecondes = 1 seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

        /*

        - ANCIEN SYSTEME DANS LE TERMINAL -

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle règle voulez vous utiliser ? (0-256):");
        int rule = Integer.parseInt(scanner.nextLine());
        System.out.println("Entrez la configuration initiale de l'automate (ex: 0011001011):");
        String initialState = scanner.nextLine();

        metier.Automate1D automate = new metier.Automate1D(initialState, rule);
        System.out.println("Configuration initiale:");
        automate.AfficherEtat();

        System.out.println("Combien d'itérations voulez-vous exécuter ?");
        int iterations = scanner.nextInt();
        automate.AfficherEtat();
        for (int i = 0; i < iterations; i++) {
            automate.CalculProchain();
            automate.AfficherEtat();
        }

        scanner.close();
         */
}

