package mineField;

import mvc.AppFactory;
import mvc.AppPanel;

public class MineFieldPanel extends AppPanel {

    public MineFieldPanel(AppFactory factory) {
        super(factory);
    }


    public static void main(String[] args) {
        MineFieldFactory factory = new MineFieldFactory();
        MineFieldPanel panel = new MineFieldPanel(factory);
        panel.display();
    }
}
