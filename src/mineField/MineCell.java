package mineField;

import java.awt.*;

public class MineCell {

    private MineField mineField;
    private int height, xc, yc;


    public MineCell(MineField mineField, int xc, int yc, int height) {
        this.mineField = mineField;
        this.height = height;
        this.xc = xc;
        this.yc = yc;
    }


    public int getHeight() {
        return height;
    }

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }

    public void draw(Graphics2D gc) {
        gc.fillRect(xc, yc, height, height);
        gc.setColor(Color.BLACK);
        gc.drawRect(xc, yc, height, height);
    }


}
