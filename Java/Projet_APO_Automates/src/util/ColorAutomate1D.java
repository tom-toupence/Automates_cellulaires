package util;

import metier.Cellule;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ColorAutomate1D extends JPanel {
    private ArrayList<Cellule[]> generations = new ArrayList<>();
    private final int cellSize = 10;

    public void addGeneration(Cellule[] cellules) {
        generations.add(cellules);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int gen = 0; gen < generations.size(); gen++) {
            Cellule[] cellules = generations.get(gen);
            for (int i = 0; i < cellules.length; i++) {
                if (cellules[i].getValue() == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                int x = i * cellSize;
                int y = gen * cellSize;
                g.fillRect(x, y, cellSize, cellSize);
            }
        }
    }
}
