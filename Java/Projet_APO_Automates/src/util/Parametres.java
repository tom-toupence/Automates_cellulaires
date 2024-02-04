package util;

import metier.Automate1D;
import window.WindowAutomate1D;
import window.WindowAutomate1DInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant l'interface {@link ActionListener} pour gérer le changement de fenêtres entre les paramètres et la visualisation d'un Automate1D.
 * <p>
 * Cette classe est destinée à être utilisée avec des composants d'interface utilisateur (tels que des boutons) pour permettre aux utilisateurs de naviguer
 * entre la fenêtre affichant les paramètres de l'automate et la fenêtre affichant la visualisation de l'automate.
 * </p>
 */
public class Parametres implements ActionListener {

    /**
     * Modèle d'automate 1D associé à cette action.
     */
    private Automate1D modele;

    /**
     * Fenêtre d'informations et de paramétrage de l'automate 1D.
     */
    private WindowAutomate1DInfo w1;

    /**
     * Fenêtre de visualisation de l'automate 1D.
     */
    private WindowAutomate1D w2;

    /**
     * Constructeur pour initialiser l'action avec le modèle d'automate et les fenêtres concernées.
     *
     * @param modele Le modèle d'automate 1D concerné.
     * @param w1 La fenêtre d'informations et de paramétrage de l'automate.
     * @param w2 La fenêtre de visualisation de l'automate.
     */
    public Parametres(Automate1D modele, WindowAutomate1DInfo w1, WindowAutomate1D w2) {
        this.modele = modele;
        this.w1 = w1;
        this.w2 = w2;
    }

    /**
     * Méthode appelée lorsque l'action de changement de fenêtre est déclenchée.
     * <p>
     * Cette méthode rend invisible la fenêtre de visualisation et rend visible la fenêtre de paramétrage,
     * permettant ainsi à l'utilisateur de modifier les paramètres de l'automate avant de relancer la simulation.
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
