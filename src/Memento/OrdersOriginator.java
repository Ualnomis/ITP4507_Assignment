package Memento;

import java.util.*;
import Order.Order;

public class OrdersOriginator {
    private ArrayList<Order> orders; // store all ordered order from staff

    // get Orders
    public ArrayList<Order> getOrders() {
        return orders;
    }

    // set Orders
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    // save orders to memento
    public OrdersMemento saveToMemento() {
        return new OrdersMemento(orders);
    }

    // restore orders from memento
    public void restoreFromMemento(OrdersMemento m) {
        orders = m.getSavedOrders();
    }

    public static class OrdersMemento {
        private final ArrayList<Order> savedOrders; // store all orders record

        private OrdersMemento(ArrayList<Order> orders) {
            savedOrders = new ArrayList<Order>(orders); // copy orders and store to savedOrders
        }

        // get savedOrders
        private ArrayList<Order> getSavedOrders() {
            return savedOrders;
        }
    }
}
