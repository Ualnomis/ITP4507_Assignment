package Command;

import java.util.*;

import Factory.*;
import LunchSet.*;
import LunchSet.Drink.*;
import LunchSet.Side.*;
import LunchSet.Soup.*;
import Memento.*;
import Menu.*;
import Order.*;

public class Receiver {
    private OrdersOriginator o = new OrdersOriginator();
    private ArrayList<OrdersOriginator.OrdersMemento> ordersMementos = new ArrayList<OrdersOriginator.OrdersMemento>();
    private Scanner sc;
    private ArrayList<Menu> menus;
    private MenuFactory menuFactory;
    private Menu chineseMenu;
    private Menu westernMenu;

    public Receiver() {
    }

    public Receiver(Scanner sc) {
        this.sc = sc;
        menus = new ArrayList<Menu>();
        menuFactory = new ChineseStyleLunchSetMenuFactory();
        chineseMenu = menuFactory.createMenu();
        menus.add(chineseMenu);
        menuFactory = new WesternStyleLunchSetMenuFactory();
        westernMenu = menuFactory.createMenu();
        menus.add(westernMenu);

        o.setOrders(new ArrayList<Order>());
        ordersMementos.add(o.saveToMemento());
    }

    public void editMenu() {
        try {
            Menu menu = null;
            System.out.println();
            System.out.println("Edit Menu:");
            System.out.print("Chinese or Western (c | w):");
            String input = sc.nextLine();
            if ("c".equals(input)) {
                menu = menus.get(0);
            } else if ("w".equals(input)) {
                menu = menus.get(1);
            } else {
                sc.nextLine();
                System.out.println("Invalid Option!");
                System.out.println();
                return;
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
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Invalid Option!");
            System.out.println();
            return;
        }
    }

    public void showMenu() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println();
            System.out.println(menus.get(i));
            System.out.println();
        }
    }

    public void makeOrder() {
        Order order;
        Menu menu;
        LunchSetFactory lunchSetFactory;
        LunchSet lunchSet;
        int staffNum;
        int officeLocation;
        try {
            System.out.println();
            System.out.println("Place Order");
            System.out.print("Chinese or Western (c | w):");
            String input = sc.nextLine();
            String teaType = "";
            String side = "";
            if ("c".equals(input)) {
                menu = chineseMenu;
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
                } else {
                    System.out.println("Sold Out!");
                    System.out.println();
                    return;
                }
            } else if ("w".equals(input)) {
                menu = westernMenu;
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
                } else {
                    System.out.println("Sold Out!");
                    System.out.println();
                    return;
                }
            } else {
                System.out.println("Invalid Option!");
                System.out.println();
                return;
            }
            System.out.print("Staff Number:");
            staffNum = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < o.getOrders().size(); i++) {
                if (o.getOrders().get(i).getStaffNum() == staffNum) {
                    System.out.println("Staff is ordered!!!");
                    System.out.println();
                    return;
                }
            }
            System.out.print("Office Location:");
            officeLocation = sc.nextInt();
            sc.nextLine();
            order = new Order(lunchSet, staffNum, officeLocation, menu);
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Invalid Option!");
            System.out.println();
            return;
        }
        menu.setAvailableCount(menu.getAvailableCount() - 1);
        ArrayList<Order> orders = new ArrayList<Order>(o.getOrders());
        orders.add(order);
        System.out.println("Order Placed");
        o.setOrders(orders);
        ordersMementos.add(o.saveToMemento());
        System.out.println();

    }

    public void listOutstandingOrders() {
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
        System.out.println();
        o.setOrders(o.getOrders());
        ordersMementos.add(o.saveToMemento());

    }

    public void cancelOrders() {
        o.restoreFromMemento(ordersMementos.get(ordersMementos.size() - 1));
        ArrayList<Order> canceledOrders = new ArrayList<Order>(o.getOrders());

        try {
            System.out.print("Input the number: ");
            int staffNum = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < canceledOrders.size(); i++) {
                if (staffNum == canceledOrders.get(i).getStaffNum()) {
                    System.out.println(canceledOrders.get(i));
                    canceledOrders.get(i).cancel();
                    canceledOrders.remove(i);
                    o.setOrders(canceledOrders);
                    ordersMementos.add(o.saveToMemento());
                    System.out.println("Order Cancelled");
                    System.out.println();
                    return;
                }
            }
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Invalid Option!");
            System.out.println();
            return;
        }
        System.out.println("Staff Number Not Found");
        System.out.println();
    }
}
