package mineField;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class MineFieldPanel extends AppPanel {


    private JButton nwButton;
    private JButton nButton;
    private JButton neButton;
    private JButton wButton;
    private JButton eButton;
    private JButton swButton;
    private JButton sButton;
    private JButton seButton;

    public MineFieldPanel(AppFactory factory) {
        super(factory);

        nwButton = new JButton("NW");
        nButton = new JButton("N");
        neButton = new JButton("NE");
        wButton = new JButton("W");
        eButton = new JButton("E");
        swButton = new JButton("SW");
        sButton = new JButton("S");
        seButton = new JButton("SE");

        nwButton.addActionListener(this);
        nButton.addActionListener(this);
        neButton.addActionListener(this);
        wButton.addActionListener(this);
        eButton.addActionListener(this);
        swButton.addActionListener(this);
        sButton.addActionListener(this);
        seButton.addActionListener(this);

        // Add buttons (optionally add action listeners)
        controlPanel.add(nwButton);
        controlPanel.add(nButton);
        controlPanel.add(neButton);
        controlPanel.add(wButton);
        controlPanel.add(eButton);
        controlPanel.add(swButton);
        controlPanel.add(sButton);
        controlPanel.add(seButton);

        // Set layout for the control panel
        controlPanel.setLayout(new GridLayout(4, 2));

    }

    public static void main(String[] args) {
        MineFieldFactory factory = new MineFieldFactory();
        MineFieldPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
