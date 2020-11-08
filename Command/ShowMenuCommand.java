package Command;

import java.util.ArrayList;

import Menu.Menu;

public class ShowMenuCommand implements Command {
    private Receiver receiver;
    private ArrayList<Menu> menus;

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ShowMenuCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.showMenu(menus);
    }

    public ShowMenuCommand(Receiver receiver, ArrayList<Menu> menus) {
        this.receiver = receiver;
        this.menus = menus;
    }
}
