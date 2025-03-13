package mineField;

import mvc.Model;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MineField extends Model {

    private final int gridViewSize = 3;  // grid to be displayed is 20 x 20
    private final int actualGrid = gridViewSize + 1; // design choice to handle check mines
    private final int percentMined = 50;
    private final int mineAmount = gridViewSize * gridViewSize * percentMined / 100;
    private Set<Point> mines = new HashSet<>(mineAmount );
    private final boolean steppedOnMine = true;


    private final Color color = Color.GRAY;
    private final Color mineColor = Color.RED;


    public Color getColor() {
        return color;
    }

    public Color getMineColor() {
        return mineColor;
    }

    public int getGridViewSize() {
        return gridViewSize;
    }

    public Set<Point> getMines() {
        return mines;
    }

    public  MineField() {
        super();
        seedMines();
    }

    public Point seedMine() {
        Random random = new Random();
        int row = random.nextInt(gridViewSize ) + 1;
        int col = random.nextInt(gridViewSize ) + 1;
        Point p = new Point(row, col);


        while (mines.contains(p)) { // handle overlapped coordinates
            p.x += 1;
            if (p.x > gridViewSize) {
                p.x = p.x % gridViewSize;
                p.y += 1;
                if (p.y > gridViewSize) {
                    p.y = p.y % gridViewSize;
                }
            }
        }
        return p;
    }

    public void seedMines() {
        mines.clear();
        for (int i = 0; i < mineAmount; i++) {
            mines.add(seedMine());
        }
    }

    public boolean didStepOnMine() {
        return steppedOnMine;
    }
}
