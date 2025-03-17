package mineField;

import mvc.View;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MineFieldView extends View {

    private int cellSize;

    public MineFieldView(MineField mineField) {
        super(mineField);
        adjustCellSize();

        // Add a listener to handle component resizing
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Adjust cellSize when the panel is resized
                adjustCellSize();
                repaint(); // Trigger a repaint to redraw the grid based on new size
            }
        });
    }

    private void adjustCellSize() {
        MineField mineField = (MineField) model;
        int width = getWidth();
        int height = getHeight();

        // Dynamically calculate the new cell size based on the panel size
        int gridSize = mineField.getGridViewSize();
        this.cellSize = Math.min(width / gridSize, height / gridSize);
    }

    public void drawCellAtCoordinates(Graphics gc, Point point, Color color) {
        MineField mineField = (MineField) model;
        gc.setColor(color);
        MineCell cell = new MineCell(mineField, point, cellSize);
        cell.draw((Graphics2D) gc);
    }

    public void drawMineBoard(Graphics gc, Color color) {
        MineField mineField = (MineField) model;
        int boardSize = mineField.getGridViewSize();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                drawCellAtCoordinates(gc, new Point(i, j), color);
            }
        }
    }

    public void drawMines(Graphics gc, Color color) {
        MineField mineField = (MineField) model;
        for (Point mineCoordinates : mineField.getMines()) {
            drawCellAtCoordinates(gc, mineCoordinates, color);
        }
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        MineField mineField = (MineField) model;

        Color cellBaseColor = mineField.getColor();
        Color mineColor = mineField.getMineColor();
        drawMineBoard(gc, cellBaseColor);

        if (mineField.showMineSolution()) {
            drawMines(gc, mineColor);
        }
//        drawCellAtCoordinates(gc, new Point(0, 0), Color.GREEN); // DEBUG: use this to debug mine cell
//        drawCellAtCoordinates(gc, new Point(19, 19), Color.GREEN); // DEBUG: use this to debug mine cell

    }
}
