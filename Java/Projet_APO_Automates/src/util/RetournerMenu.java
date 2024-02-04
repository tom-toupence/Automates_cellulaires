package util;

import metier.Automate1D;
import window.WindowAutomate1D;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant l'interface {@link ActionListener} pour gérer le retour au menu principal depuis la visualisation d'un Automate1D.
 * <p>
 * Cette classe permet de naviguer de la fenêtre de visualisation d'un Automate1D vers le menu principal de l'application,
 * facilitant ainsi l'accès aux différents contrôles ou simulations disponibles depuis l'interface principale.
 * </p>
 */
public class RetournerMenu implements ActionListener {

    /**
     * Le modèle d'automate 1D associé à cette action.
     */
    private Automate1D modele;

    /**
     * La fenêtre principale de l'application.
     */
    private WindowMain w1;

    /**
     * La fenêtre de visualisation de l'automate 1D.
     */
    private WindowAutomate1D w2;

    /**
     * Constructeur pour initialiser l'action avec le modèle d'automate, la fenêtre principale, et la fenêtre de visualisation.
     *
     * @param modele Le modèle d'automate 1D concerné.
     * @param w1 La fenêtre principale de l'application.
     * @param w2 La fenêtre de visualisation de l'automate 1D.
     */
    public RetournerMenu(Automate1D modele, WindowMain w1, WindowAutomate1D w2) {
        this.modele = modele;
        this.w1 = w1;
        this.w2 = w2;
    }

    /**
     * Méthode appelée lorsque l'action de retour au menu est déclenchée.
     * <p>
     * Cette méthode rend invisible la fenêtre de visualisation de l'automate et rend visible la fenêtre principale,
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
