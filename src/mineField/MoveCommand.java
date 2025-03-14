package mineField;

import mvc.Command;
import mvc.Model;

public class MoveCommand extends Command {
    Heading heading;
    public MoveCommand(Model model, Heading heading) {
        super(model);
        this.heading = heading;
    }

    public void execute() {
        MineField minefield = (MineField)model;
        minefield.move(heading);
    }

    public enum Heading {
        NORTH, NORTHWEST, NORTHEAST, WEST, EAST, SOUTH, SOUTHWEST, SOUTHEAST
    }
}
