
import java.util.ArrayList;

public class MakeOrderCommand implements Command {
    private Receiver receiver;
    private ArrayList<LunchSet> lunchSets;
    private ArrayList<Order> orders;

    public Receiver getReceiver() {
        return receiver;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<LunchSet> getLunchSets() {
        return lunchSets;
    }

    public void setLunchSets(ArrayList<LunchSet> lunchSets) {
        this.lunchSets = lunchSets;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public MakeOrderCommand() {
    }

    public void execute() {
        receiver.makeOrder(lunchSets, orders);
    }

    public MakeOrderCommand(Receiver receiver, ArrayList<LunchSet> lunchSets, ArrayList<Order> orders) {
        this.receiver = receiver;
        this.lunchSets = lunchSets;
        this.orders = orders;
    }
}
