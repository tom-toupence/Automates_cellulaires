import metier.Automate1D;
import metier.FeuDeForet;
import window.WindowMain;

public class Main {
    public static void main(String[] args) {


        Automate1D modele = new Automate1D();
        FeuDeForet modeleFeuDeForet = new FeuDeForet();
        WindowMain window = new WindowMain(modele,modeleFeuDeForet);
        window.setVisible(true);


/*

- ANCIEN SYSTEME DANS LE TERMINAL FEU DE FORÊT-

        int length = 20; // Largeur de la grille
        int height = 10; // Hauteur de la grille
        double densiteForet = 0.9; // Densité de forêt (60% des cellules sont des arbres)
        double probaSpontaneousFire = 0.5; // Probabilité d'enflamment spontané
        double ventDirection = 90; // Direction du vent (Est)
        double ventForce = 0.05; // Force du vent
        int initialFeux = 3; // Nombre initial de cellules en feu

        // Création de l'instance de FeuDeForet
        FeuDeForet simulation = new FeuDeForet(length, height, densiteForet,probaSpontaneousFire, ventDirection, ventForce, initialFeux);

        // Affichage de l'état initial de la forêt
        System.out.println("État initial de la forêt :");
        simulation.afficherForet();

        // Exécution de quelques cycles de simulation
        int nombreDeCycles = 5; // Nombre de cycles de simulation à exécuter
        for (int i = 0; i < nombreDeCycles; i++) {
            simulation.CalculProchain(); // Calcul du prochain état
            System.out.println("État de la forêt après le cycle " + (i + 1) + " :");
            simulation.afficherForet(); // Affichage de l'état actuel de la forêt
        }*/

        /*

        - ANCIEN SYSTEME DANS LE TERMINAL AUTOMATE 1D-

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
}

