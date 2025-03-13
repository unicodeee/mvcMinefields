package mineField;

import mvc.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MineField extends Model {

    private final int gridViewSize = 20;  // grid to be displayed is 20 x 20
    private final int actualGrid = gridViewSize + 1; // design choice to handle check mines
    private final int percentMined = 5;
    private final int mineAmount = gridViewSize ^ 2 * percentMined / 100;
    private List<Point> mines = new ArrayList<>(mineAmount );
    private final boolean steppedOnMine = true;


    private Color color = Color.GRAY;


    public Color getColor() {
        return color;
    }

    public int getGridViewSize() {
        return gridViewSize;
    }

    public  MineField() {
        super();
        seedMines();
    }

    public void seedMines() {
        mines.clear();
        for (int i = 0; i < mineAmount; i++) {
            Random random = new Random();
            int row = random.nextInt(gridViewSize + 1) + 1;
            int col = random.nextInt(gridViewSize + 1) + 1;
            mines.add(new Point(row, col));
        }
    }

    public boolean steppedOnMine() {
        return steppedOnMine;
    }
}
