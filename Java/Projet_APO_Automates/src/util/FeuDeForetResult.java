package util;

import metier.Automate1D;
import metier.FeuDeForet;
import window.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeuDeForetResult implements ActionListener {

    WindowFeuDeForetInfo window;
    WindowMain window0;
    FeuDeForet modele;

    public FeuDeForetResult(WindowFeuDeForetInfo window, WindowMain window0, FeuDeForet modele){
        this.window=window;
        this.window0=window0;
        this.modele=modele;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        WindowFeuDeForet w = new WindowFeuDeForet(modele, window, window0);
        window.setVisible(false);
        w.setVisible(true);
    }

}
