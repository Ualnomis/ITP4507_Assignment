package Memento;

import java.util.ArrayList;

import Order.Order;

public class Caretaker {
    private OrdersOriginator originator;
    private ArrayList<OrdersOriginator.OrdersMemento> ordersMementos;

    public Caretaker(OrdersOriginator originator) {
        this.originator = originator;
        this.ordersMementos = new ArrayList<OrdersOriginator.OrdersMemento>();
    }

    public void setOrdersMementos(ArrayList<Order> orders) {
        this.ordersMementos.add(originator.saveToMemento(orders));
    }

    public ArrayList<OrdersOriginator.OrdersMemento> getOrdersMementos() {
        return this.ordersMementos;
    }
}
