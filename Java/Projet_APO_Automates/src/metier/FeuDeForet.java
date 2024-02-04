package metier;

import java.util.Random;

public class FeuDeForet extends AutomateCellulaire2D {
    private static final int VIDE = 0;
    private static final int FORET = 1;
    private static final int FEU = 2;
    private static final int BRULE = 3;

    private double probaIgnition; // Probabilité d'ignition d'une cellule forêt due aux voisins en feu
    private double ventDirection; // Direction du vent en degrés (0-360)
    private double ventForce; // Force du vent
    private int initialFeux; // Nombre initial de cellules en feu
    private double densiteForet; // Densité de la forêt

    public FeuDeForet(int length, int height, double densiteForet, double probaIgnition, double ventDirection, double ventForce, int initialFeux) {
        super(length, height);
        this.probaIgnition = probaIgnition;
        this.ventDirection = ventDirection;
        this.ventForce = ventForce;
        this.initialFeux = initialFeux;
        this.densiteForet = densiteForet;
        initialiserForet(densiteForet, initialFeux);
    }

    public FeuDeForet() {
        super(0, 0);
    }

    private void initialiserForet(double densiteForet, int initialFeux) {
        Random rand = new Random();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                setState(i, j, rand.nextDouble() < densiteForet ? FORET : VIDE);
            }
        }
        // Placement initial des feux
        for (int i = 0; i < initialFeux; i++) {
            int x, y;
            do {
                x = rand.nextInt(getHeight());
                y = rand.nextInt(getLength());
            } while (getState(x, y) != FORET);
            setState(x, y, FEU);
        }
    }

    @Override
    public void CalculProchain() {
        int[][] nouvelEtat = new int[getHeight()][getLength()];
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                int etat = getState(i, j);
                if (etat == FORET) {
                    double probaFeu = 0;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            if (di == 0 && dj == 0) continue;
                            int nx = i + di;
                            int ny = j + dj;
                            if (nx >= 0 && nx < getHeight() && ny >= 0 && ny < getLength() && getState(nx, ny) == FEU) {
                                double impactDuVent = calculerImpactDuVent(di, dj);
                                probaFeu += probaIgnition + impactDuVent;
                            }
                        }
                    }
                    nouvelEtat[i][j] = Math.random() < probaFeu ? FEU : FORET;
                } else if (etat == FEU) {
                    nouvelEtat[i][j] = BRULE;
                } else {
                    nouvelEtat[i][j] = etat; // VIDE ou BRULE reste inchangé
                }
            }
        }
        setGrid(nouvelEtat);
    }

    private double calculerImpactDuVent(int deltaX, int deltaY) {
        double rad = Math.toRadians(ventDirection);
        double ventX = Math.cos(rad);
        double ventY = Math.sin(rad);
        double scalaire = ventX * deltaX + ventY * deltaY;
        double impact = scalaire * ventForce;
        return Math.max(0, impact);
    }

    private int compterVoisinsEnFeu(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nx = x + i;
                int ny = y + j;
                if (nx >= 0 && nx < getHeight() && ny >= 0 && ny < getLength() && getState(nx, ny) == FEU) {
                    count++;
                }
            }
        }
        return count;
    }



    public double getProbaIgnition() {
        return probaIgnition;
    }

    public void setProbaIgnition(double probaIgnition) {
        this.probaIgnition = probaIgnition;
    }

    public double getVentDirection() {
        return ventDirection;
    }

    public void setVentDirection(double ventDirection) {
        this.ventDirection = ventDirection;
    }

    public double getVentForce() {
        return ventForce;
    }

    public void setVentForce(double ventForce) {
        this.ventForce = ventForce;
    }

    public int getInitialFeux() {
        return initialFeux;
    }

    public void setInitialFeux(int initialFeux) {
        this.initialFeux = initialFeux;
    }

    public double getDensiteForet() {
        return densiteForet;
    }

    public void setDensiteForet(double densiteForet) {
        this.densiteForet = densiteForet;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void afficherForet() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                switch (getState(i, j)) {
                    case VIDE:
                        System.out.print(" . ");
                        break;
                    case FORET:
                        System.out.print(" F ");
                        break;
                    case FEU:
                        System.out.print(" * ");
                        break;
                    case BRULE:
                        System.out.print(" x ");
                        break;
                }
            }
            System.out.println();
        }
    }
}
