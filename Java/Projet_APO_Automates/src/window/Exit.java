package window;

import window.WindowAutomate1D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Exit implements ActionListener {

    WindowAutomate1D w;

    public Exit(WindowAutomate1D w) {
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
