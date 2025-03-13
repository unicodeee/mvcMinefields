package mineField;

import mvc.View;

import java.awt.*;

public class MineFieldView extends View {

    private final int eachCellSize = 10;

    public MineFieldView(MineField mineField) {
        super(mineField);
    }

    public void drawCellAtCordinates(Graphics gc, Point point, Color color){
        MineField mineField = (MineField) model;
        gc.setColor(color);
        MineCell cell = new MineCell(mineField, point.x * eachCellSize, point.y * eachCellSize, eachCellSize);
        cell.draw((Graphics2D) gc);
    }

    public void drawMineBoard(Graphics gc, Color color){
        MineField mineField = (MineField) model;
        int boardSize = mineField.getGridViewSize() + 1;

        for (int i = 1; i < boardSize; i++) {
            for (int j = 1; j < boardSize; j++) {
                drawCellAtCordinates(gc, new Point(i, j), color);
            }
        }
    }

    public void drawMines(Graphics gc, Color color){
        MineField mineField = (MineField) model;
        for (Point mineCordinates: mineField.getMines()) {
            drawCellAtCordinates(gc, mineCordinates, color);
        }
    }

    public void paintComponent(Graphics gc) { // TO DO
        super.paintComponent(gc);
        MineField mineField = (MineField) model;

        Color cellBaseColor = mineField.getColor();
        Color mineColor = mineField.getMineColor();
        drawMineBoard(gc, cellBaseColor);


        // TO DO: condition here to handle display bomb
        if (mineField.didStepOnMine()) {
            drawMines(gc, mineColor);
        }

//        drawCellAtCordinates(gc, new Point(20, 20), Color.GREEN); // DEBUG: use this to debug mine cell

    }
}
