package util;



import metier.Automate1D;
import metier.FeuDeForet;
import window.WindowAutomate1D;
import window.WindowAutomate1DInfo;
import window.WindowFeuDeForet;
import window.WindowFeuDeForetInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParametresFeuDeForet implements ActionListener {

    FeuDeForet modele;
    WindowFeuDeForetInfo w1;
    WindowFeuDeForet w2;

    public ParametresFeuDeForet(FeuDeForet modele, WindowFeuDeForetInfo w1, WindowFeuDeForet w2) {
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

