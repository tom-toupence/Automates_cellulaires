import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Automate1D_results implements ActionListener{
    WindowAutomate1DInfo window;
    Automate1D modele;

    public Automate1D_results(WindowAutomate1DInfo window){
        this.window=window;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        WindowAutomate1D w = new WindowAutomate1D(modele, window);
        this.window.setVisible(false);
        w.setVisible(true);
    }
}
