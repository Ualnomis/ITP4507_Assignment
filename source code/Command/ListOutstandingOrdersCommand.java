package Command;

import java.util.ArrayList;

import Order.Order;

public class ListOutstandingOrdersCommand implements Command {
    private Receiver receiver; // receiver


    public void execute() {
        receiver.listOutstandingOrders(); // call receiver to execute listOutstandingOrders() method
    }


    public Receiver getReceiver() {
        return receiver;
    }

    // set receiver
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    // no args constructor
    public ListOutstandingOrdersCommand() {
    }

    public ListOutstandingOrdersCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
