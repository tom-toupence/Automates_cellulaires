package util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe implémentant l'interface {@link ActionListener} pour gérer l'action de fermeture d'une fenêtre.
 * <p>
 * Cette classe est conçue pour être associée à un composant graphique (comme un bouton) pour permettre
 * la fermeture sécurisée de l'application et de la fenêtre à laquelle elle est attachée.
 * </p>
 */
public class Exit implements ActionListener {

    /**
     * La fenêtre que cette action de fermeture concerne.
     */
    private JFrame w;

    /**
     * Constructeur pour créer une instance de l'action de fermeture.
     *
     * @param w La fenêtre ({@link JFrame}) qui sera fermée lors de l'action.
     */
    public Exit(JFrame w) {
        this.w = w;
    }

    /**
     * Méthode appelée lorsque l'action de fermeture est déclenchée.
     * <p>
     * Cette méthode définit l'opération de fermeture par défaut de la fenêtre sur {@link JFrame#EXIT_ON_CLOSE},
     * puis ferme l'application et libère les ressources de la fenêtre pour s'assurer qu'elle ne reste pas en mémoire.
     * </p>
     *
     * @param e L'événement d'action déclenchant la fermeture.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Définition du comportement de fermeture de la fenêtre.
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.exit(0); // Assure la terminaison complète de l'application.
        w.dispose(); // Libère les ressources de la fenêtre.
    }
}
