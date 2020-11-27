package Command;

import java.util.ArrayList;
import java.util.Scanner;

import Factory.ChineseStyleLunchSetFactory;
import Factory.LunchSetFactory;
import Factory.WesternStyleLunchSetFactory;
import LunchSet.ChineseStyleLunchSet;
import LunchSet.LunchSet;
import LunchSet.WesternStyleLunchSet;
import LunchSet.Drink.*;
import LunchSet.Side.*;
import LunchSet.Soup.ChineseSoup;
import LunchSet.Soup.WesternSoup;
import Memento.Caretaker;
import Memento.OrdersOriginator;
import Menu.Menu;
import Order.Order;

public class Receiver {
    private OrdersOriginator o = new OrdersOriginator();
    private ArrayList<OrdersOriginator.OrdersMemento> ordersMementos = new ArrayList<OrdersOriginator.OrderMemento>();
    Scanner sc = new Scanner(System.in);

    public void editMenu(ArrayList<Menu> menus) {
        Menu menu = null;
        System.out.println();
        System.out.println("Edit Menu:");
        System.out.print("Chinese or Western (c | w):");
        String input = sc.nextLine();
        if ("c".equals(input)) {
            menu = menus.get(0);
        } else if ("w".equals(input)) {
            menu = menus.get(1);
        }
        if (menu != null) {
            System.out.print("Enter main dish: ");
            String mainDish = sc.nextLine();
            menu.setMainDish(mainDish);
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            menu.setPrice(price);
            System.out.print("Enter available count:");
            int availableCount = sc.nextInt();
            sc.nextLine();
            menu.setAvailableCount(availableCount);
            System.out.println("Menu Updated");
            System.out.println();
        }
    }

    public void showMenu(ArrayList<Menu> menus) {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println();
            System.out.println(menus.get(0));
            System.out.println();
            System.out.println(menus.get(1));
            System.out.println();
        }
    }

    public void makeOrder(ArrayList<Menu> menus) {
        String teaType = "";
        String side = "";
        Order order;
        Menu menu;
        LunchSetFactory lunchSetFactory;
        LunchSet lunchSet;
        ArrayList<Order> orders = new ArrayList<Order>(o.getOrders());
        System.out.println();
        System.out.println("Place Order");
        System.out.print("Chinese or Western (c | w):");
        String input = sc.nextLine();
        if ("c".equals(input)) {
            menu = menus.get(0);
            lunchSetFactory = new ChineseStyleLunchSetFactory();
            lunchSet = lunchSetFactory.createLunchSet();
            lunchSet.setSoup(new ChineseSoup());
            lunchSet.setMainDish(menu.getMainDish());
            if (menu.getAvailableCount() > 0) {
                System.out.print("Oolong Tea: hot or iced (h | i): ");
                teaType = sc.nextLine();
                if ("h".equals(teaType)) {
                    lunchSet.setDrink(new OolongTea(true));
                } else if ("i".equals(teaType)) {
                    lunchSet.setDrink(new OolongTea(false));
                }
                System.out.print("Staff Number:");
                int staffNum = sc.nextInt();
                System.out.print("Office Location:");
                int officeLocation = sc.nextInt();
                sc.nextLine();
                order = new Order(lunchSet, staffNum, officeLocation);
            } else {
                System.out.println("Sold Out!");
                return;
            }
        } else if ("w".equals(input)) {
            menu = menus.get(1);
            lunchSetFactory = new WesternStyleLunchSetFactory();
            lunchSet = lunchSetFactory.createLunchSet();
            lunchSet.setSoup(new WesternSoup());
            lunchSet.setMainDish(menu.getMainDish());
            if (menu.getAvailableCount() > 0) {
                System.out.print("side: rice, spaghetti, French fries (r | s | f): ");
                side = sc.nextLine();
                if ("r".equals(side)) {
                    ((WesternStyleLunchSet) lunchSet).setSide(new Rice());
                } else if ("s".equals(side)) {
                    ((WesternStyleLunchSet) lunchSet).setSide(new Spaghetti());
                } else if ("f".equals(side)) {
                    ((WesternStyleLunchSet) lunchSet).setSide(new FrenchFries());
                }

                System.out.print("tea or coffee, hot or iced (ht| it | hc | ic): ");
                teaType = sc.nextLine();
                if ("ht".equals(teaType)) {
                    lunchSet.setDrink(new Tea(true));
                } else if ("it".equals(teaType)) {
                    lunchSet.setDrink(new Tea(false));
                } else if ("hc".equals(teaType)) {
                    lunchSet.setDrink(new Coffee(true));
                } else if ("ic".equals(teaType)) {
                    lunchSet.setDrink(new Coffee(false));
                }
                System.out.print("Staff Number:");
                int staffNum = sc.nextInt();
                System.out.print("Office Location:");
                int officeLocation = sc.nextInt();
                sc.nextLine();
                order = new Order(lunchSet, staffNum, officeLocation);
            } else {
                System.out.println("Sold Out!");
                return;
            }
        } else {
            System.out.println("Invalid Option!");
            return;
        }
        orders.add(order);
        menu.setAvailableCount(menu.getAvailableCount() - 1);
        System.out.println("Order Placed");
        // caretaker.setOrdersMementos(orders);
        o.saveToMemento(orders);
        System.out.println();
    }

    public void listOutstandingOrders(ArrayList<Order> orders) {
        System.out.println();
        System.out.println("Outstanding Orders");
        for (int i = 0; i < o.getOrders().size(); i++) {
            if (!(o.getOrders().get(i).isOrderCompleted())) {
                System.out.println(o.getOrders().get(i));
            }
        }
        System.out.println();
    }

    public void completeOrders() {
        System.out.println();
        System.out.println("Complete Orders");
        if (o.getOrders().size() > 0) {
            o.getOrders().get(0).setOrderCompleted(true);
            System.out.println(o.getOrders().remove(0));
            System.out.println("Order marked as done");
        }
        // ordersMementos.add(o.saveToMemento());
        caretaker.setOrdersMementos(orders);
    }

    public void cancelOrders() {
        boolean found = false;
        ArrayList<Order> canceledOrders = new ArrayList<Order>(o.getOrders());

        System.out.print("Input the number: ");
        int staffNum = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < canceledOrders.size(); i++) {
            if (staffNum == canceledOrders.get(i).getStaffNum()) {
                found = true;
                canceledOrders.remove(i);
                o.saveToMemento(canceledOrders);
                return;
            }
        }
        System.out.println("Staff Number Not Found");

            // // get the orders number until number is end with xxx target order number
            // for (int i = 0; i < ordersMementos.size(); i++) {
            //     o.restoreFromMemento(ordersMementos.get(i)); // most recent orders
            //     findOrders = o.getOrders(); // 123 234 [345] 456 567 --> 123 234 [345]
            //     for (int j = 0; j < findOrders.size(); j++) {
            //         // System.out.print(j + ": [" + findOrders.get(j).getStaffNum() + " ");
            //         if (findOrders.get(findOrders.size() - 1).getStaffNum() == staffNum) {
            //             // System.out.println("Found: " + staffNum);
            //             i = ordersMementos.size();
            //             break;
            //         }
            //     }
            // }

            // // for (int i = 0; i < findOrders.size(); i++) {
            // //     System.out.println("findOrders = " + findOrders.get(i));
            // // }

            // // get the number after the target number
            // boolean foundAfterTarget = false;
            // for (int i = 0; i < orders.size(); i++) {
            //     System.out.println("i = " + i);
            //     System.out.println("orders size = " + orders.size());
            //     System.out.println("staffNumber = " + orders.get(i).getStaffNum());
                
            //     if (orders.get(i).getStaffNum() == staffNum) {
            //         System.out.println("orders.get(i).getStaffNum() == staffNum");
            //         foundAfterTarget = true;
            //     } else if (foundAfterTarget) {
            //         System.out.println("found after target");
            //         findOrders.add(orders.get(i));
            //     }
            // }
            // o.setOrders(findOrders);
            // ordersMementos.add(o.saveToMemento());
    }
}
