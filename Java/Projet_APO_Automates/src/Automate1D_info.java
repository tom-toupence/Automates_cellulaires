import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Automate1D_info implements ActionListener{
    WindowMain window;
    Automate1D modele;

    public Automate1D_info(WindowMain window, Automate1D modele){
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
