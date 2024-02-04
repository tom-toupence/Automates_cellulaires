package util;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorAutomate2D extends JPanel {

    private int cellSize;
    private int gridSizeX;
    private int gridSizeY;
    private Color[][] gridColors;

    public ColorAutomate2D() {
        super();
        cellSize = 10;
        gridSizeX = 10;
        gridSizeY = 10;
        gridColors = new Color[gridSizeY][gridSizeX];
        initializeGridColors();
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public void setGridSize(int width, int height) {
        gridSizeX = width;
        gridSizeY = height;
        gridColors = new Color[gridSizeY][gridSizeX];
        initializeGridColors();
    }

    public void setGridColors(Color[][] colors) {
        if (colors.length == gridSizeY && colors[0].length == gridSizeX) {
            gridColors = colors;
        }
    }

    public void addGeneration(int[][] gridValues) {
        if (gridValues.length == gridSizeY && gridValues[0].length == gridSizeX) {
            for (int i = 0; i < gridSizeY; i++) {
                for (int j = 0; j < gridSizeX; j++) {
                    gridColors[i][j] = getColorForValue(gridValues[i][j]);
                }
            }
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < gridSizeY; i++) {
            for (int j = 0; j < gridSizeX; j++) {
                g.setColor(gridColors[i][j]);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    private void initializeGridColors() {
        for (int i = 0; i < gridSizeY; i++) {
            for (int j = 0; j < gridSizeX; j++) {
                gridColors[i][j] = Color.WHITE; // Initialize with white color
            }
        }
    }

    public Color getColorForValue(int value) {
        switch (value){
            case 0:
                return Color.GRAY;

            case 1:
                return Color.GREEN;

            case 2:
                return Color.RED;
            case 3:
                return Color.BLACK;
            default:
                return Color.GRAY;
        }
    }

}
