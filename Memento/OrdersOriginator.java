package Memento;

import java.util.*;
import Order.Order;

public class OrdersOriginator {
    private ArrayList<Order> orders;

    public OrdersOriginator() {
        orders = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public OrdersMemento saveToMemento(ArrayList<Order> orders) {
        return new OrdersMemento(orders);
    }

    public void restoreFromMemento(OrdersMemento m) {
        orders = m.getSavedOrders();
    }

    // memento is opaque to other class
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