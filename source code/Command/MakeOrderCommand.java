package Command;

import java.util.ArrayList;

import Menu.Menu;
import Order.Order;


public class MakeOrderCommand implements Command {
    private Receiver receiver;

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public MakeOrderCommand() {
    }

    public void execute() {
        receiver.makeOrder();
    }

    public MakeOrderCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
