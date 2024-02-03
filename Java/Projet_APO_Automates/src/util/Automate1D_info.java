package util;

import metier.Automate1D;
import window.WindowAutomate1DInfo;
import window.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import metier.Automate1D;
public class Automate1D_info implements ActionListener{
    WindowMain window;
    metier.Automate1D modele;

    public Automate1D_info(WindowMain window, metier.Automate1D modele){
        this.window=window;
        this.modele=modele;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowAutomate1DInfo w = new WindowAutomate1DInfo(window, modele);
        window.setVisible(false);
        w.setVisible(true);

    }
}
