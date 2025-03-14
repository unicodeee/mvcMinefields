package mineField;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class MineFieldFactory implements AppFactory {

    @Override
    public String getTitle() {
        return "Mine Field";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Northwest", "North", "Northeast", "West", "East", "Southwest", "South", "Southeast"};
    }

    @Override
    public String getHelp() {
        return
                "Northwest: Move northwest\n" +
                        "North: Move north\n" +
                        "Northeast: Move northeast\n" +
                        "West: Move west\n" +
                        "East: Move east\n" +
                        "Southwest: Move southwest\n" +
                        "South: Move south\n" +
                        "Southeast: Move southeast\n";
    }

    @Override
    public String about() {
        return "Mine Field Group 6: Isabelle Luu, Brendan Ly, Quoc Thang Nguyen";
    }

    @Override
    public Model makeModel() {
        return new MineField();
    }

    @Override
    public View makeView(Model m) {
        return new MineFieldView((MineField) m);
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "N") {
            return new MoveCommand(model, MoveCommand.Heading.NORTH);
        }
        else if (type == "NW") {
            return new MoveCommand(model, MoveCommand.Heading.NORTHWEST);
        }
        else if (type == "NE") {
            return new MoveCommand(model, MoveCommand.Heading.NORTHEAST);
        }
        else if (type == "W") {
            return new MoveCommand(model, MoveCommand.Heading.WEST);
        }
        else if (type == "E") {
            return new MoveCommand(model, MoveCommand.Heading.EAST);
        }
        else if (type == "SW") {
            return new MoveCommand(model, MoveCommand.Heading.SOUTHWEST);
        }
        else if (type == "S") {
            return new MoveCommand(model, MoveCommand.Heading.SOUTH);
        }
        else if (type == "SE") {
            return new MoveCommand(model, MoveCommand.Heading.SOUTHEAST);
        }
        return null;
    }
}
