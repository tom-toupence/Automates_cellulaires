package metier;

import java.util.Random;

/**
 * Classe simulant un feu de forêt dans un automate cellulaire 2D.
 * <p>
 * Cette simulation utilise un automate cellulaire pour modéliser le comportement d'un feu se propageant dans une forêt.
 * Les cellules peuvent représenter un état vide, de forêt, de feu, ou brûlé, avec la propagation du feu influencée par
 * la densité de la forêt, la probabilité qu'une cellule de forêt s'enflamme, la direction et la force du vent, ainsi que
 * le nombre initial de feux.
 * </p>
 */
public class FeuDeForet extends AutomateCellulaire2D {
    /**
     * Représente une cellule vide.
     */
    private static final int VIDE = 0;
    /**
     * Représente une cellule contenant de la forêt.
     */
    private static final int FORET = 1;
    /**
     * Représente une cellule en feu.
     */
    private static final int FEU = 2;
    /**
     * Représente une cellule brûlée.
     */
    private static final int BRULE = 3;

    /**
     * Probabilité qu'une cellule de forêt s'enflamme.
     */
    private double probaFeu;
    /**
     * Direction du vent en degrés.
     */
    private double ventDirection;
    /**
     * Force du vent.
     */
    private double ventForce;
    /**
     * Nombre initial de cellules en feu.
     */
    private int initialFeux;
    /**
     * Densité de la forêt dans l'automate.
     */
    private double densiteForet;

    /**
     * Constructeur complet pour initialiser un simulateur de feu de forêt avec des paramètres spécifiques.
     *
     * @param length        Largeur de la grille de l'automate.
     * @param height        Hauteur de la grille de l'automate.
     * @param densiteForet  Densité de la forêt (probabilité qu'une cellule soit une forêt).
     * @param probaFeu      Probabilité qu'une cellule de forêt s'enflamme.
     * @param ventDirection Direction du vent en degrés.
     * @param ventForce     Force du vent.
     * @param initialFeux   Nombre initial de cellules en feu.
     */
    public FeuDeForet(int length, int height, double densiteForet, double probaFeu, double ventDirection, double ventForce, int initialFeux) {
        super(length, height);
        this.probaFeu = probaFeu;
        this.ventDirection = ventDirection;
        this.ventForce = ventForce;
        this.initialFeux = initialFeux;
        this.densiteForet = densiteForet;
        initialiserForet(densiteForet, initialFeux);
    }

    /**
     * Constructeur par défaut pour créer une instance sans configuration initiale.
     */
    public FeuDeForet() {
        super(0, 0);
    }

    /**
     * Initialise la grille de l'automate avec une densité de forêt et un nombre initial de feux spécifiés.
     *
     * @param densiteForet Densité de la forêt.
     * @param initialFeux  Nombre initial de cellules en feu.
     */
    public void initialiserForet(double densiteForet, int initialFeux) {
        Random rand = new Random();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                setState(i, j, rand.nextDouble() < densiteForet ? FORET : VIDE);
            }
        }
        for (int i = 0; i < initialFeux; i++) {
            int x, y;
            do {
                x = rand.nextInt(getHeight());
                y = rand.nextInt(getLength());
            } while (getState(x, y) != FORET);
            setState(x, y, FEU);
        }
    }

    /**
     * Calcule et met à jour l'état de chaque cellule pour la prochaine génération, selon la logique de propagation du feu.
     */
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
                                probaFeu += this.probaFeu + impactDuVent;
                            }
                        }
                    }
                    nouvelEtat[i][j] = Math.random() < probaFeu ? FEU : FORET;
                } else if (etat == FEU) {
                    nouvelEtat[i][j] = BRULE;
                } else {
                    nouvelEtat[i][j] = etat;
                }
            }
        }
        setGrid(nouvelEtat);
    }

    /**
     * Calcule l'impact du vent sur la propagation du feu en fonction de sa direction et de sa force.
     *
     * @param deltaX Déplacement sur l'axe X par rapport à la cellule courante.
     * @param deltaY Déplacement sur l'axe Y par rapport à la cellule courante.
     * @return L'impact du vent sur la probabilité d'enflammement de la cellule.
     */
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


    /**
     * Retourne la probabilité actuelle qu'une cellule de forêt s'enflamme.
     *
     * @return La probabilité d'enflammement d'une cellule de forêt.
     */
    public double getProbaFeu() {
        return probaFeu;
    }

    /**
     * Définit la probabilité qu'une cellule de forêt s'enflamme.
     *
     * @param probaFeu La nouvelle probabilité d'enflammement.
     */
    public void setProbaFeu(double probaFeu) {
        this.probaFeu = probaFeu;
    }

    /**
     * Retourne la direction actuelle du vent affectant la propagation du feu.
     *
     * @return La direction du vent en degrés.
     */
    public double getVentDirection() {
        return ventDirection;
    }

    /**
     * Définit la direction du vent influençant la propagation du feu.
     *
     * @param ventDirection La nouvelle direction du vent en degrés.
     */
    public void setVentDirection(double ventDirection) {
        this.ventDirection = ventDirection;
    }

    /**
     * Retourne la force actuelle du vent affectant la propagation du feu.
     *
     * @return La force du vent.
     */
    public double getVentForce() {
        return ventForce;
    }

    /**
     * Définit la force du vent influençant la propagation du feu.
     *
     * @param ventForce La nouvelle force du vent.
     */
    public void setVentForce(double ventForce) {
        this.ventForce = ventForce;
    }

    /**
     * Retourne le nombre initial de cellules en feu lors de l'initialisation de la simulation.
     *
     * @return Le nombre initial de cellules en feu.
     */
    public int getInitialFeux() {
        return initialFeux;
    }

    /**
     * Définit le nombre initial de cellules en feu pour démarrer la simulation.
     *
     * @param initialFeux Le nouveau nombre initial de cellules en feu.
     */
    public void setInitialFeux(int initialFeux) {
        this.initialFeux = initialFeux;
    }

    /**
     * Retourne la densité actuelle de la forêt dans la grille de l'automate.
     *
     * @return La densité de la forêt.
     */
    public double getDensiteForet() {
        return densiteForet;
    }

    /**
     * Définit la densité de la forêt dans la grille de l'automate.
     *
     * @param densiteForet La nouvelle densité de la forêt.
     */
    public void setDensiteForet(double densiteForet) {
        this.densiteForet = densiteForet;
    }

    /**
     * Retourne la grille actuelle représentant l'état de chaque cellule dans l'automate.
     *
     * @return La grille représentant l'état des cellules.
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Affiche l'état actuel de la forêt dans la console, en utilisant des symboles pour représenter
     * les différents états des cellules (vide, forêt, feu, brûlé).
     */
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

    /**
     * Calcule le pourcentage de forêt brûlée dans l'automate cellulaire.
     *
     * @return Le pourcentage de forêt brûlée arrondi au dixième près.
     */
    public double calculerPourcentageForetBrulee() {
        int totalCells = getHeight() * getLength();
        int foretBruleeCells = 0;

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (getState(i, j) == BRULE) {
                    foretBruleeCells++;
                }
            }
        }

        double pourcentageBrule = ((double) foretBruleeCells / totalCells) * 100;
        return Math.round(pourcentageBrule * 10.0) / 10.0; // Arrondi au dixième près.
    }
}
