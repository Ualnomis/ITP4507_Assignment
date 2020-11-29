package Memento;

import java.util.*;
import Order.Order;

public class OrdersOriginator {
    private ArrayList<Order> orders; // store all ordered order from staff

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = new ArrayList<Order>(orders);
    }

    public OrdersMemento saveToMemento() {
        return new OrdersMemento(orders);
    }

    public void restoreFromMemento(OrdersMemento m) {
        orders = m.getSavedOrders();
    }

    public static class OrdersMemento {
        private final ArrayList<Order> savedOrders;

        private OrdersMemento(ArrayList<Order> orders) {
            savedOrders = orders;
        }

        private ArrayList<Order> getSavedOrders() {
            return savedOrders;
        }
    }
}
