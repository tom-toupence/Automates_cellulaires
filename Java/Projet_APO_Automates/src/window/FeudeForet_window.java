package window;

import window.WindowMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FeudeForet_window implements ActionListener{
    WindowMain mainFrame;

    public FeudeForet_window(WindowMain mainFrame){
        this.mainFrame=mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.dispose();
        JFrame frame = new JFrame("Feu de Forêt");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
