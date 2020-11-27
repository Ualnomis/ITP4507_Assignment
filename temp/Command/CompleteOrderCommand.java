package Command;

import java.util.ArrayList;

import Order.Order;

public class CompleteOrderCommand implements Command {
    private Receiver receiver;

    public void execute() {
        receiver.completeOrders();
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public CompleteOrderCommand() {
    }
}
