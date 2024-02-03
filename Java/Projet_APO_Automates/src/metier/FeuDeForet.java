package metier;

import java.util.Random;

public class FeuDeForet extends AutomateCellulaire2D {
    // États possibles pour chaque cellule
    private static final int VIDE = 0;
    private static final int FORET = 1;
    private static final int FEU = 2;
    private static final int BRULE = 3;

    private double probaIgnition; // Probabilité d'ignition d'une cellule forêt due aux voisins en feu
    private double probaSpontaneousFire; // Probabilité qu'une cellule forêt s'enflamme spontanément

    public FeuDeForet(int length, int height, double densiteForet, double probaIgnition, double probaSpontaneousFire) {
        super(0, length, height); // La règle n'est pas utilisée ici, mise à 0 par défaut
        this.probaIgnition = probaIgnition;
        this.probaSpontaneousFire = probaSpontaneousFire;
        initialiserForet(densiteForet);
    }

    private void initialiserForet(double densiteForet) {
        Random rand = new Random();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                setState(i, j, rand.nextDouble() < densiteForet ? FORET : VIDE);
            }
        }
    }

    @Override
    public void CalculProchain() {
        int[][] nouvelEtat = new int[getHeight()][getLength()];
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                int etat = getState(i, j);
                int nbVoisinsEnFeu = compterVoisinsEnFeu(i, j);
                double probaFeu = nbVoisinsEnFeu * probaIgnition + (etat == FORET ? probaSpontaneousFire : 0);

                switch (etat) {
                    case VIDE:
                        nouvelEtat[i][j] = VIDE;
                        break;
                    case FORET:
                        nouvelEtat[i][j] = Math.random() < probaFeu ? FEU : FORET;
                        break;
                    case FEU:
                        nouvelEtat[i][j] = BRULE;
                        break;
                    case BRULE:
                        nouvelEtat[i][j] = BRULE;
                        break;
                }
            }
        }
        setGrid(nouvelEtat);
    }

    private int compterVoisinsEnFeu(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the cell itself
                int nx = x + i;
                int ny = y + j;
                // Check boundaries
                if (nx >= 0 && nx < getHeight() && ny >= 0 && ny < getLength()) {
                    if (getState(nx, ny) == FEU) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void afficherForet() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                switch (getState(i, j)) {
                    case VIDE:
                        System.out.print(" . "); // Représentation d'une cellule vide
                        break;
                    case FORET:
                        System.out.print(" F "); // Représentation d'une cellule de forêt
                        break;
                    case FEU:
                        System.out.print(" * "); // Représentation d'une cellule en feu
                        break;
                    case BRULE:
                        System.out.print(" x "); // Représentation d'une cellule brûlée
                        break;
                }
            }
            System.out.println(); // Nouvelle ligne après chaque ligne de la


        }
    }
}
