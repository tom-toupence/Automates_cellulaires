package util;

import window.WindowAutomate1DInfo;
import window.WindowFeuDeForetInfo;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant l'interface {@link ActionListener} pour gérer les actions liées à l'affichage d'informations sur un simulateur de feu de forêt.
 * <p>
 * Cette classe est conçue pour être attachée à un composant graphique (tel qu'un bouton) dans l'interface utilisateur,
 * permettant ainsi d'afficher une nouvelle fenêtre avec des informations détaillées sur une instance spécifique de simulation de feu de forêt.
 * </p>
 */
public class FeuDeForetInfo implements ActionListener {
    /**
     * Référence à la fenêtre principale de l'application, à partir de laquelle l'action est initiée.
     */
    private WindowMain window;

    /**
     * Modèle de simulation de feu de forêt pour lequel les informations doivent être affichées.
     */
    private metier.FeuDeForet modele;

    /**
     * Constructeur pour initialiser l'écouteur avec la fenêtre principale et le modèle de simulation de feu de forêt.
     *
     * @param window La fenêtre principale de l'application.
     * @param modele Le modèle de simulation de feu de forêt concerné par cette action.
     */
    public FeuDeForetInfo(WindowMain window, metier.FeuDeForet modele) {
        this.window = window;
        this.modele = modele;
    }

    /**
     * Réagit à un événement d'action, généralement déclenché par l'utilisateur.
     * <p>
     * Lorsqu'une action est détectée, cette méthode crée et affiche une nouvelle fenêtre {@link WindowFeuDeForetInfo}
     * pour montrer les détails de la simulation de feu de forêt, rendant la fenêtre principale invisible pour se concentrer sur les informations détaillées.
     * </p>
     *
     * @param e L'événement d'action qui a déclenché l'appel de cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        WindowFeuDeForetInfo w = new WindowFeuDeForetInfo(window, modele);
        window.setVisible(false);
        w.setVisible(true);
    }
}
