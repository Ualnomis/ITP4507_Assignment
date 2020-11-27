package Command;

import java.util.ArrayList;

import Menu.Menu;

public class ShowMenuCommand implements Command {
    private Receiver receiver;

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ShowMenuCommand() {
    }

    public ShowMenuCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.showMenu();
    }

}
