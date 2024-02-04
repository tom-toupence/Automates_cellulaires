package util;

import metier.FeuDeForet;
import window.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant l'interface {@link ActionListener} pour gérer les actions liées à l'affichage des résultats d'une simulation de feu de forêt.
 * <p>
 * Cette classe est prévue pour être attachée à un composant graphique (tel qu'un bouton) dans une interface utilisateur,
 * permettant d'afficher une nouvelle fenêtre avec les résultats de la simulation du feu de forêt une fois que l'utilisateur déclenche l'action.
 * </p>
 */
public class FeuDeForetResult implements ActionListener {

    /**
     * La fenêtre d'informations sur le feu de forêt à partir de laquelle l'action est initiée.
     */
    private WindowFeuDeForetInfo window;

    /**
     * La fenêtre principale de l'application.
     */
    private WindowMain window0;

    /**
     * Le modèle de feu de forêt dont les résultats doivent être affichés.
     */
    private FeuDeForet modele;

    /**
     * Constructeur pour initialiser l'écouteur avec les fenêtres concernées et le modèle de feu de forêt.
     *
     * @param window La fenêtre d'informations sur le feu de forêt.
     * @param window0 La fenêtre principale de l'application.
     * @param modele Le modèle de feu de forêt concerné par cette action.
     */
    public FeuDeForetResult(WindowFeuDeForetInfo window, WindowMain window0, FeuDeForet modele) {
        this.window = window;
        this.window0 = window0;
        this.modele = modele;
    }

    /**
     * Gère les actions réalisées par l'utilisateur, typiquement pour afficher les résultats du feu de forêt.
     * <p>
     * Lorsque l'action est déclenchée, cette méthode crée une nouvelle fenêtre {@link WindowFeuDeForet} pour
     * montrer les résultats de la simulation du feu de forêt, cache la fenêtre d'information actuelle, et rend
     * la nouvelle fenêtre de résultats visible à l'utilisateur.
     * </p>
     *
     * @param e L'événement d'action qui a déclenché l'appel de cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        WindowFeuDeForet w = new WindowFeuDeForet(modele, window, window0);
        window.setVisible(false);
        w.setVisible(true);
    }
}
