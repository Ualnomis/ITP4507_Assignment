
import java.util.ArrayList;
public abstract class CommandFactory {
    private Receiver receiver;
    private ArrayList<LunchSet> lunchSets;
    private ArrayList<Order> orders;

    public abstract Command createCommand();

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

    public Receiver getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
