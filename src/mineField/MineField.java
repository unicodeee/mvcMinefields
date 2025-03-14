package mineField;

import mvc.Model;
import mvc.Utilities;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static mineField.MoveCommand.Heading.NORTH;

public class MineField extends Model {

    private final int gridViewSize = 20;  // grid to be displayed is 20 x 20
    private final int percentMined = 5;


    private boolean done = false;

    private MineCell currentPosition = new MineCell(this,new Point(1,1), cellSize);
    private Point newPosition = new Point(currentPosition.getXc(), currentPosition.getYc());

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

    public void move(MoveCommand.Heading heading) {
        if (done) {
            Utilities.inform("Cannot move, game is finished.");
        }
        switch (heading) {
            case NORTH: newPosition.y -= 1; break;
            case NORTHWEST:
                newPosition.y -= 1;
                newPosition.x -= 1;
                break;
            case NORTHEAST:
                newPosition.y -= 1;
                newPosition.x += 1;
                break;
            case WEST: newPosition.x -= 1; break;
            case EAST: newPosition.x += 1; break;
            case SOUTHWEST:
                newPosition.y += 1;
                newPosition.x -= 1;
                break;
            case SOUTH: newPosition.y += 1; break;
            case SOUTHEAST:
                newPosition.y += 1;
                newPosition.x += 1;
                break;
        }
        currentPosition = new MineCell(this, newPosition, cellSize);
        if (newPosition.x > gridViewSize || newPosition.y > gridViewSize) {Utilities.error(new Exception("Out of bounds"));}
        if (isAMine(newPosition)) {Utilities.error(new Exception("Stepped on a mine, you lost!")); done = true;}
        else if (currentPosition.isDestinationCell(newPosition)){Utilities.error(new Exception("Destination reached, you won!")); done = true;}
        changed();
    }
}
