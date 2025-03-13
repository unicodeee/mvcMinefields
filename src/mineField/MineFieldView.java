package mineField;

import mvc.View;

import java.awt.*;

public class MineFieldView extends View {


    private int eachCellSize = 10;

    public MineFieldView(MineField mineField) {
        super(mineField);
    }

//    public drawCellAtCordinates(Point point){
//        MineCell cell = new MineCell(mineField, tempt + i* eachCellSize, j * eachCellSize, eachCellSize);
//        cell.draw((Graphics2D) gc);
//    }

    public void paintComponent(Graphics gc) { // TO DO
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        MineField mineField = (MineField) model;


        int boardSize = mineField.getGridViewSize() + 1;

        for (int i = 1; i < boardSize; i++) {
            for (int j = 1; j < boardSize; j++) {
                MineCell cell = new MineCell(mineField, i* eachCellSize, j * eachCellSize, eachCellSize);
                cell.draw((Graphics2D) gc);
            }
        }

        if (mineField.steppedOnMine()) {

        }

        // TO DO: condition here to handle display bomb

        gc.setColor(oldColor);
    }
}
