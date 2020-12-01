package Command;

import java.util.ArrayList;

import Menu.Menu;
import Order.Order;


public class MakeOrderCommand implements Command {
    private Receiver receiver; // receiver

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    // no args constructor
    public MakeOrderCommand() {
    }

    public void execute() {
        receiver.makeOrder(); // call receiver makeOrder() method to make order
    }

    public MakeOrderCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
