package util;

import metier.FeuDeForet;
import window.WindowFeuDeForet;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant l'interface {@link ActionListener} pour gérer le retour au menu principal depuis la visualisation d'une simulation de feu de forêt.
 * <p>
 * Cette classe permet de naviguer de la fenêtre de visualisation d'une simulation de feu de forêt vers le menu principal de l'application.
 * Elle facilite l'accès aux différents contrôles ou simulations disponibles depuis l'interface principale, améliorant ainsi l'expérience utilisateur.
 * </p>
 */
public class RetournerMenuFeuDeForet implements ActionListener {

    /**
     * Le modèle de simulation de feu de forêt associé à cette action.
     */
    private FeuDeForet modele;

    /**
     * La fenêtre principale de l'application.
     */
    private WindowMain w1;

    /**
     * La fenêtre de visualisation de la simulation de feu de forêt.
     */
    private WindowFeuDeForet w2;

    /**
     * Constructeur pour initialiser l'action avec le modèle de simulation de feu de forêt, la fenêtre principale, et la fenêtre de visualisation.
     *
     * @param modele Le modèle de simulation de feu de forêt concerné.
     * @param w1 La fenêtre principale de l'application.
     * @param w2 La fenêtre de visualisation de la simulation de feu de forêt.
     */
    public RetournerMenuFeuDeForet(FeuDeForet modele, WindowMain w1, WindowFeuDeForet w2) {
        this.modele = modele;
        this.w1 = w1;
        this.w2 = w2;
    }

    /**
     * Méthode appelée lorsque l'action de retour au menu est déclenchée.
     * <p>
     * Cette méthode rend invisible la fenêtre de visualisation de la simulation et rend visible la fenêtre principale,
     * permettant à l'utilisateur de naviguer vers d'autres parties de l'application ou d'initier de nouvelles simulations.
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
