package Factory;

import java.util.ArrayList;

import Command.*;
import Menu.Menu;
import Order.Order;

public abstract class CommandFactory {
    private Receiver receiver;
    private ArrayList<Menu> menus;
    private ArrayList<Order> orders;

    public abstract Command createCommand();

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public Receiver getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public CommandFactory(Receiver receiver) {
        this.receiver = receiver;
    }

    public CommandFactory() {
    }

    public CommandFactory(Receiver receiver, ArrayList<Menu> menus, ArrayList<Order> orders) {
        this.receiver = receiver;
        this.menus = menus;
        this.orders = orders;
    }

}
