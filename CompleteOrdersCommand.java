
import java.util.ArrayList;

public class CompleteOrdersCommand implements Command {
    private Receiver receiver;
    private ArrayList<Order> orders;

    public void execute() {
        receiver.listCompleteOrders(orders);
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

    public CompleteOrdersCommand(Receiver receiver, ArrayList<Order> orders) {
        this.receiver = receiver;
        this.orders = orders;
    }

    public CompleteOrdersCommand() {
    }
}