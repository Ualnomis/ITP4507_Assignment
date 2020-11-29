package Command;

import java.util.ArrayList;

import Order.Order;

public class ListOutstandingOrdersCommand implements Command {
    private Receiver receiver;

    public void execute() {
        receiver.listOutstandingOrders();
    }


    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ListOutstandingOrdersCommand() {
    }

    public ListOutstandingOrdersCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
