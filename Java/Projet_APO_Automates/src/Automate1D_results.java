import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

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
