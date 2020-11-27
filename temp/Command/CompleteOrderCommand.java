package Command;

import java.util.ArrayList;

import Order.Order;

public class CompleteOrderCommand implements Command {
    private Receiver receiver;
    private ArrayList<Order> orders;

    public void execute() {
        receiver.completeOrders(orders);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public CompleteOrderCommand(Receiver receiver, ArrayList<Order> orders) {
        this.receiver = receiver;
        this.orders = orders;
    }

    public CompleteOrderCommand() {
    }
}
