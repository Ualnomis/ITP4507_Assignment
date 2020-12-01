package Command;

import java.util.ArrayList;

import Menu.Menu;

public class ShowMenuCommand implements Command {
    private Receiver receiver; // reciever

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    // no args constructor
    public ShowMenuCommand() {
    }

    public ShowMenuCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.showMenu(); // call receiver showMenu() method to show menu
    }

}
