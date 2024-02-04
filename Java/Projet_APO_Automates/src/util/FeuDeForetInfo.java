package util;

import window.WindowAutomate1DInfo;
import window.WindowFeuDeForetInfo;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeuDeForetInfo implements ActionListener {
    WindowMain window;
    metier.FeuDeForet modele;

    public FeuDeForetInfo(WindowMain window, metier.FeuDeForet modele){
        this.window=window;
        this.modele=modele;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowFeuDeForetInfo w = new WindowFeuDeForetInfo(window, modele);
        window.setVisible(false);
        w.setVisible(true);

    }
}
