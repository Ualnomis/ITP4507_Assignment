package Command;

import java.util.ArrayList;

import Order.Order;

public class CompleteOrderCommand implements Command {
    private Receiver receiver; // receiver

    public void execute() {
        receiver.completeOrder(); // call receiver completeOrder() method to complete order
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public CompleteOrderCommand() {
    }
    public CompleteOrderCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
