package util;

import metier.Automate1D;
import window.WindowAutomate1D;
import window.WindowAutomate1DInfo;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe d'écoute dédiée à la gestion des résultats d'un Automate1D.
 * <p>
 * Implémente {@link ActionListener} pour réagir aux événements d'action, en particulier pour gérer l'affichage
 * des résultats de simulation d'un Automate1D. Cette classe est responsable de la transition entre la fenêtre
 * d'informations de l'automate et la fenêtre affichant les résultats de la simulation.
 * </p>
 */
public class Automate1D_results implements ActionListener {
    /**
     * Fenêtre d'informations de l'automate 1D où l'action est initiée.
     */
    private WindowAutomate1DInfo window;

    /**
     * Fenêtre principale de l'application.
     */
    private WindowMain window0;

    /**
     * Modèle d'automate 1D pour lequel les résultats doivent être affichés.
     */
    private Automate1D modele;

    /**
     * Constructeur pour initialiser l'écouteur avec les fenêtres concernées et le modèle d'automate.
     *
     * @param window Fenêtre d'informations de l'automate 1D.
     * @param window0 Fenêtre principale de l'application.
     * @param modele Modèle d'automate 1D associé à cet écouteur.
     */
    public Automate1D_results(WindowAutomate1DInfo window, WindowMain window0, Automate1D modele) {
        this.window = window;
        this.window0 = window0;
        this.modele = modele;
    }

    /**
     * Gère les actions réalisées par l'utilisateur, typiquement pour afficher les résultats de l'automate 1D.
     * <p>
     * Lorsque l'action est déclenchée, cette méthode crée une nouvelle fenêtre {@link WindowAutomate1D} pour
     * montrer les résultats de la simulation de l'automate 1D, cache la fenêtre d'information actuelle, et rend
     * la nouvelle fenêtre de résultats visible à l'utilisateur.
     * </p>
     *
     * @param e L'événement d'action qui a déclenché l'appel de cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        WindowAutomate1D w = new WindowAutomate1D(modele, window, window0);
        window.setVisible(false);
        w.setVisible(true);
    }
}
