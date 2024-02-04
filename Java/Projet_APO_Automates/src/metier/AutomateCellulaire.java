package metier;

/**
 * Classe abstraite représentant la structure de base d'un automate cellulaire.
 * <p>
 * Un automate cellulaire est un modèle mathématique pour un système où des cellules
 * dans un espace discret changent d'état en fonction de règles fixées. Cette classe
 * fournit le cadre de base pour gérer la longueur de l'automate et définit des méthodes
 * abstraites pour le calcul des générations suivantes et l'affichage de l'état actuel.
 * </p>
 */
public abstract class AutomateCellulaire {

    /**
     * La longueur de l'automate, représentant le nombre de cellules dans l'automate.
     */
    protected int length;

    /**
     * Constructeur pour initialiser un automate cellulaire avec une longueur spécifique.
     * @param length La longueur de l'automate cellulaire.
     */
    public AutomateCellulaire( int length) {

        this.length = length;
    }

    // Getters et setters


    /**
     * Obtient la longueur actuelle de l'automate cellulaire.
     * @return La longueur de l'automate.
     */
    public int getLength() {
        return length;
    }

    /**
     * Définit la longueur de l'automate cellulaire.
     * @param length La nouvelle longueur de l'automate.
     */
    public void setLength(int length) {
        this.length = length;
    }

    // Méthode abstraite pour calculer la prochaine génération
    /**
     * Méthode abstraite pour calculer la prochaine génération de l'automate cellulaire.
     * <p>
     * Les classes dérivées doivent implémenter cette méthode pour définir la logique
     * spécifique de mise à jour des cellules en fonction de leur état actuel et des
     * règles de l'automate.
     * </p>
     */
    public abstract void CalculProchain();

    /**
     * Méthode abstraite pour afficher l'état actuel de l'automate cellulaire.
     * <p>
     * Les classes dérivées doivent implémenter cette méthode pour fournir une représentation
     * de l'état actuel de l'automate, typiquement sous forme de chaîne de caractères.
     * </p>
     * @return Une chaîne de caractères représentant l'état actuel de l'automate.
     */
    public abstract String afficherEtat();
}

