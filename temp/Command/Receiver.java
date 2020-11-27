package Command;

import java.util.ArrayList;
import java.util.Scanner;

import Factory.*;
import LunchSet.*;
import LunchSet.Drink.*;
import LunchSet.Side.*;
import LunchSet.Soup.ChineseSoup;
import LunchSet.Soup.WesternSoup;
import Memento.OrdersOriginator;
import Menu.Menu;
import Order.Order;

public class Receiver {
    private OrdersOriginator o = new OrdersOriginator();
    private ArrayList<OrdersOriginator.OrdersMemento> ordersMementos = new ArrayList<OrdersOriginator.OrdersMemento>();
    private Scanner sc;
    private ArrayList<Menu> menus = new ArrayList<Menu>();
    private MenuFactory menuFactory;
    private Menu chineseMenu;
    private Menu westernMenu;

    public Receiver() {
    }

    public Receiver(Scanner sc) {
        this.sc = sc;
        menuFactory = new ChineseStyleLunchSetMenuFactory();
        chineseMenu = menuFactory.createMenu();
        menus.add(chineseMenu);
        menuFactory = new WesternStyleLunchSetMenuFactory();
        westernMenu = menuFactory.createMenu();
        menus.add(westernMenu);
    }

    public void editMenu( ArrayList<Menu> menuss) {
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

    public void showMenu( ArrayList<Menu> menuss) {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println();
            System.out.println(menus.get(i));
            System.out.println();
        }
    }

    public void makeOrder( ArrayList<Menu> menuss,  ArrayList<Order> orders) {
        System.out.println();
        System.out.println("Place Order");
        System.out.print("Chinese or Western (c | w):");
         String input = sc.nextLine();
        String teaType = "";
        String side = "";
        Order order;
        Menu menu;
        LunchSetFactory lunchSetFactory;
        LunchSet lunchSet;
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
        o.setOrders(orders);
        ordersMementos.add(o.saveToMemento());
        System.out.println();

    }

    public void listOutstandingOrders( ArrayList<Order> orders) {
        System.out.println();
        System.out.println("Outstanding Orders");
        for (int i = 0; i < o.getOrders().size(); i++) {
            if (!(o.getOrders().get(i).isOrderCompleted())) {
                System.out.println(o.getOrders().get(i));
            }
        }
        System.out.println();
    }

    public void completeOrders( ArrayList<Order> orders) {
        System.out.println();
        System.out.println("Complete Orders");
        if (orders.size() > 0) {
            orders.get(0).setOrderCompleted(true);
            System.out.println(orders.remove(0));
            System.out.println("Order marked as done");
        }
        o.setOrders(orders);
        ordersMementos.add(o.saveToMemento());

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
                System.out.println(canceledOrders.get(i));
                if (canceledOrders.get(i).getLunchSet() instanceof ChineseStyleLunchSet) {
                    chineseMenu.setAvailableCount(chineseMenu.getAvailableCount() + 1);
                } else if (canceledOrders.get(i).getLunchSet() instanceof WesternStyleLunchSet) {
                    westernMenu.setAvailableCount(westernMenu.getAvailableCount() + 1);
                }
                canceledOrders.remove(i);
                o.setOrders(canceledOrders);
                ordersMementos.add(o.saveToMemento());
                return;
            }
        }
        System.out.println("Staff Number Not Found");
    }
}
