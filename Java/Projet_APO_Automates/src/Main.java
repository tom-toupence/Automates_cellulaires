import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
    /*
        WindowMain window = new WindowMain();
        window.setVisible(true);
    */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la configuration initiale de l'automate (ex: 0011001011):");
        String initialState = scanner.nextLine();

        Automate1D automate = new Automate1D(initialState);
        System.out.println("Configuration initiale:");
        automate.AfficherEtat();

        System.out.println("Combien d'itérations voulez-vous exécuter ?");
        int iterations = scanner.nextInt();
        for (int i = 0; i < iterations; i++) {
            automate.CalculProchain();
            System.out.println("État après itération " + (i + 1) + " :");
            automate.AfficherEtat();
        }

        scanner.close();
    }
}
