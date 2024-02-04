package util;

import metier.Automate1D;
import window.WindowAutomate1D;
import window.WindowAutomate1DInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Parametres implements ActionListener {

    Automate1D modele;
    WindowAutomate1DInfo w1;
    WindowAutomate1D w2;

    public Parametres(Automate1D modele, WindowAutomate1DInfo w1, WindowAutomate1D w2) {
        this.modele=modele;
        this.w1=w1;
        this.w2=w2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //On change juste de fenêtre avec un setVisible.
        w2.setVisible(false);
        w1.setVisible(true);


    }

}
