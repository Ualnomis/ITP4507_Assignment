package Command;

import java.util.ArrayList;

import Menu.Menu;

public class EditMenuCommand implements Command {
    private Receiver receiver;
    private ArrayList<Menu> menus;

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public EditMenuCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.editMenu(menus);
    }

    public EditMenuCommand(Receiver receiver, ArrayList<Menu> menus) {
        this.receiver = receiver;
        this.menus = menus;
    }
}
