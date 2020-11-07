
import java.util.ArrayList;


public class ListOutstandingOrdersCommand implements Command {
    private Receiver receiver;
    private ArrayList<Order> orders;

    public void execute() {
        receiver.listOutstandingOrders(orders);
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

    public ListOutstandingOrdersCommand() {
    }

    public ListOutstandingOrdersCommand(Receiver receiver, ArrayList<Order> orders) {
        this.receiver = receiver;
        this.orders = orders;
    }
}
