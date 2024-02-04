package metier;

/**
 * Classe représentant une cellule dans un automate cellulaire.
 * <p>
 * Cette classe encapsule l'état d'une cellule, qui peut être représenté par un entier.
 * Les cellules sont les composants de base des automates cellulaires, et leur état peut
 * varier en fonction des règles définies dans l'automate.
 * </p>
 */
public class Cellule {
    /**
     * Valeur représentant l'état de la cellule.
     */
    private int value;

    /**
     * Construit une cellule avec un état initial.
     * @param value L'état initial de la cellule, représenté par un entier.
     */
    public Cellule(int value) {
        this.value = value;
    }

    /**
     * Retourne l'état actuel de la cellule.
     * @return L'état de la cellule, représenté par un entier.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Définit l'état de la cellule.
     * @param value Le nouvel état de la cellule, représenté par un entier.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
