package mvc;

import stopLight.Stoplight;

import javax.swing.*;

public class View extends JPanel implements Subscriber {
    protected Model model;
    public View(Model model) {
        this.model = model;
    }

    public void setModel(Model model) {
    }

    @Override
    public void update() {

    }
}
