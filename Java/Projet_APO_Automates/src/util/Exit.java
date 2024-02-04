package util;

import window.WindowAutomate1D;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Exit implements ActionListener {

    private JFrame w;

    public Exit(JFrame w) {
        this.w=w;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Commande basique permettant de fermer la fenêtre
        w.setDefaultCloseOperation(w.EXIT_ON_CLOSE);
        System.exit(0); //Important sinon elle reste en fond
        w.dispose();
    }

}
