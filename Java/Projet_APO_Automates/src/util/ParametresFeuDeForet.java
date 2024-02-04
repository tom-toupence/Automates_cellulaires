package util;

import metier.FeuDeForet;
import window.WindowFeuDeForet;
import window.WindowFeuDeForetInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant l'interface {@link ActionListener} pour gérer le changement de fenêtres entre les paramètres et la visualisation d'une simulation de feu de forêt.
 * <p>
 * Cette classe facilite la navigation entre la fenêtre affichant les paramètres de la simulation de feu de forêt et la fenêtre affichant la visualisation de cette simulation.
 * Elle est prévue pour être attachée à un composant d'interface utilisateur (tel qu'un bouton) permettant à l'utilisateur de retourner à la fenêtre de paramètres pour effectuer des ajustements.
 * </p>
 */
public class ParametresFeuDeForet implements ActionListener {

    /**
     * Modèle de simulation de feu de forêt associé à cette action.
     */
    private FeuDeForet modele;

    /**
     * Fenêtre d'informations et de paramétrage de la simulation de feu de forêt.
     */
    private WindowFeuDeForetInfo w1;

    /**
     * Fenêtre de visualisation de la simulation de feu de forêt.
     */
    private WindowFeuDeForet w2;

    /**
     * Constructeur pour initialiser l'action avec le modèle de simulation et les fenêtres concernées.
     *
     * @param modele Le modèle de simulation de feu de forêt.
     * @param w1 La fenêtre d'informations et de paramétrage de la simulation.
     * @param w2 La fenêtre de visualisation de la simulation.
     */
    public ParametresFeuDeForet(FeuDeForet modele, WindowFeuDeForetInfo w1, WindowFeuDeForet w2) {
        this.modele = modele;
        this.w1 = w1;
        this.w2 = w2;
    }

    /**
     * Méthode appelée lorsque l'action de changement de fenêtre est déclenchée.
     * <p>
     * Cette méthode rend invisible la fenêtre de visualisation et rend visible la fenêtre de paramétrage,
     * permettant ainsi à l'utilisateur de modifier les paramètres de la simulation de feu de forêt avant de relancer la visualisation.
     * </p>
     *
     * @param e L'événement d'action qui a déclenché l'appel de cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        w2.setVisible(false);
        w1.setVisible(true);
    }
}
