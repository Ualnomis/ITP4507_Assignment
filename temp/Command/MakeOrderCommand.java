package Command;

import java.util.ArrayList;

import Menu.Menu;
import Order.Order;


public class MakeOrderCommand implements Command {
    private Receiver receiver;
    private ArrayList<Menu> menus;
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

    public ArrayList<Menu> getLunchSets() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public MakeOrderCommand() {
    }

    public void execute() {
        receiver.makeOrder(menus, orders);
    }

    public MakeOrderCommand(Receiver receiver, ArrayList<Menu> menus, ArrayList<Order> orders) {
        this.receiver = receiver;
        this.menus = menus;
        this.orders = orders;
    }
}

