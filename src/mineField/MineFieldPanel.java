package mineField;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class MineFieldPanel extends AppPanel {

    private JButton northwest;
    private JButton north;
    private JButton northeast;
    private JButton west;
    private JButton east;
    private JButton southwest;
    private JButton south;
    private JButton southeast;
    public MineFieldPanel(AppFactory factory) {
        super(factory);
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 40));
        northwest = new JButton("NW");
        north = new JButton("N");
        northeast = new JButton("NE");
        west = new JButton("W");
        east = new JButton("E");
        southwest = new JButton("SW");
        south = new JButton("S");
        southeast = new JButton("SE");
        northwest.addActionListener(this);
        north.addActionListener(this);
        northeast.addActionListener(this);
        west.addActionListener(this);
        east.addActionListener(this);
        southwest.addActionListener(this);
        south.addActionListener(this);
        southeast.addActionListener(this);
        buttonPanel.add(northwest);
        buttonPanel.add(north);
        buttonPanel.add(northeast);
        buttonPanel.add(west);
        buttonPanel.add(east);
        buttonPanel.add(southwest);
        buttonPanel.add(south);
        buttonPanel.add(southeast);
        controlPanel.add(buttonPanel);
    }

    public static void main(String[] args) {
        MineFieldFactory factory = new MineFieldFactory();
        MineFieldPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
