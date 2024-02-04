package util;

import metier.Automate1D;
import window.WindowAutomate1DInfo;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe d'écoute pour gérer les actions liées à l'information sur un Automate1D.
 * <p>
 * Cette classe implémente {@link ActionListener} pour réagir aux événements, typiquement
 * des actions de l'utilisateur, pour afficher des informations détaillées sur un {@link Automate1D}.
 * </p>
 */
public class Automate1D_info implements ActionListener {
    /**
     * La fenêtre principale à partir de laquelle l'action est déclenchée.
     */
    private WindowMain window;

    /**
     * Le modèle d'automate 1D dont les informations doivent être affichées.
     */
    private Automate1D modele;

    /**
     * Constructeur pour initialiser l'écouteur avec la fenêtre principale et le modèle d'automate.
     *
     * @param window La fenêtre principale de l'application.
     * @param modele Le modèle d'automate 1D associé à cet écouteur.
     */
    public Automate1D_info(WindowMain window, Automate1D modele) {
        this.window = window;
        this.modele = modele;
    }

    /**
     * Réagit à un événement d'action, généralement déclenché par l'utilisateur.
     * <p>
     * Lorsqu'une action est détectée, cette méthode crée et affiche une nouvelle fenêtre
     * {@link WindowAutomate1DInfo} pour montrer les détails de l'automate 1D, et cache la fenêtre principale.
     * </p>
     *
     * @param e L'événement d'action qui a déclenché l'appel de cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        WindowAutomate1DInfo w = new WindowAutomate1DInfo(window, modele);
        window.setVisible(false);
        w.setVisible(true);
    }
}
