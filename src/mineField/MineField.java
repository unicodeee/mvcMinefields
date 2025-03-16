package mineField;

import mvc.Model;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MineField extends Model {

    private final int gridViewSize = 20;  // grid to be displayed is 20 x 20
    private final int percentMined = 5;


    private final int mineAmount = gridViewSize * gridViewSize * percentMined / 100;
    private Set<Point> mines = new HashSet<>(mineAmount);


    private boolean showMineCount = true; // DEBUG: flip to true to debug
    private final boolean showMineSolution = true;


    private final Color color = Color.GRAY;
    private final Color mineColor = Color.RED;


    public boolean showSolution() {
        return showMineCount;
    }


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

    public MineField() {
        super();
        seedMines();
    }

    public boolean isAMine(Point point) {
        return mines.contains(point);
    }

    public int getNumNeighboringMines(Point current) {
        int count = 0;
        Point tempt;

        tempt = new Point(current);
        tempt.x -= 1;
        if (isAMine(tempt)) {
            count++;
        }

        tempt = new Point(current);
        tempt.x += 1;
        if (isAMine(tempt)) {
            count++;
        }

        tempt = new Point(current);
        tempt.y -= 1;
        if (isAMine(tempt)) {
            count++;
        }

        tempt = new Point(current);
        tempt.y += 1;
        if (isAMine(tempt)) {
            count++;
        }

        tempt = new Point(current);
        tempt.x -= 1;
        tempt.y -= 1;
        if (isAMine(tempt)) {
            count++;
        }

        tempt = new Point(current);
        tempt.x += 1;
        tempt.y += 1;
        if (isAMine(tempt)) {
            count++;
        }

        tempt = new Point(current);
        tempt.x += 1;
        tempt.y -= 1;
        if (isAMine(tempt)) {
            count++;
        }

        tempt = new Point(current);
        tempt.x -= 1;
        tempt.y += 1;
        if (isAMine(tempt)) {
            count++;
        }

        return count;
    }

    public Point seedMine() {
        Random random = new Random();
        int row = random.nextInt(gridViewSize);
        int col = random.nextInt(gridViewSize);
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

    public boolean showMineSolution() {
        return showMineSolution;
    }
}
