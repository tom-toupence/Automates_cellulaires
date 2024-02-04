package metier;

/**
 * Classe représentant un automate cellulaire unidimensionnel.
 * <p>
 * Cette classe étend {@link AutomateCellulaire} pour implémenter un automate cellulaire
 * spécifique dans un espace unidimensionnel. Elle est caractérisée par une règle de
 * transition spécifique qui détermine l'évolution des cellules à chaque itération.
 * </p>
 */
public class AutomateCellulaire1D extends AutomateCellulaire {
    /**
     * Numéro de la règle de transition des cellules de l'automate.
     */
    protected int rule;

    /**
     * Constructeur pour initialiser un automate cellulaire unidimensionnel avec une règle spécifique et une longueur.
     *
     * @param rule Numéro de la règle de transition à appliquer aux cellules.
     * @param length Longueur de l'automate, c'est-à-dire le nombre de cellules.
     */
    public AutomateCellulaire1D(int rule, int length) {
        super(length);
        setRule(rule);
    }

    /**
     * Implémentation de la méthode abstraite pour afficher l'état actuel de l'automate.
     *
     * @return Une chaîne de caractères indiquant qu'aucun état n'est actuellement défini.
     */
    public String  afficherEtat(){
     return "no etat";
    }

    /**
     * Retourne le numéro de la règle appliquée à l'automate.
     *
     * @return Le numéro de la règle de transition des cellules.
     */
    public int getRule() {
        return rule;
    }

    /**
     * Définit le numéro de la règle de transition des cellules de l'automate.
     *
     * @param rule Le nouveau numéro de règle à appliquer.
     */
    public void setRule(int rule) {
        this.rule = rule;
    }

    /**
     * Implémentation de la méthode abstraite pour calculer la prochaine génération de l'automate.
     * <p>
     * Cette méthode devrait être implémentée pour mettre à jour l'état des cellules
     * en fonction de la règle de transition spécifiée par {@code rule}.
     * </p>
     */
    @Override
    public void CalculProchain() {
    }
}

