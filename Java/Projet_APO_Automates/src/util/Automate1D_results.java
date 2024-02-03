package util;

import metier.Automate1D;
import window.WindowAutomate1D;
import window.WindowAutomate1DInfo;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Automate1D_results implements ActionListener{
    WindowAutomate1DInfo window;
    WindowMain window0;
    Automate1D modele;

    public Automate1D_results(WindowAutomate1DInfo window, WindowMain window0, Automate1D modele){
        this.window=window;
        this.window0=window0;
        this.modele=modele;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        WindowAutomate1D w = new WindowAutomate1D(modele, window, window0);
        window.setVisible(false);
        w.setVisible(true);
    }
}
