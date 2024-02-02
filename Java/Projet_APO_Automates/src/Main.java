import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Automate1D modele = new Automate1D();
        WindowMain window = new WindowMain(modele);
        window.setVisible(true);


        /*

        - ANCIEN SYSTEME DANS LE TERMINAL -

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle règle voulez vous utiliser ? (0-256):");
        int rule = Integer.parseInt(scanner.nextLine());
        System.out.println("Entrez la configuration initiale de l'automate (ex: 0011001011):");
        String initialState = scanner.nextLine();

        Automate1D automate = new Automate1D(initialState, rule);
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
