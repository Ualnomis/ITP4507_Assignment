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
    private OrdersOriginator o = new OrdersOriginator(); // orders originator to store arraylist orders
    private ArrayList<OrdersOriginator.OrdersMemento> ordersMementos = new ArrayList<OrdersOriginator.OrdersMemento>(); // arraylist to store a list of orders memento
    private Scanner sc; // scanner
    private ArrayList<Menu> menus; // a list of different menus
    private MenuFactory menuFactory; // menu factory to create menu object
    private Menu chineseMenu; // store chinese menu object
    private Menu westernMenu; // store western menu object

    // no args constructor
    public Receiver() {
    }

    public Receiver(Scanner sc) {
        this.sc = sc;
        // create a menu arraylist
        menus = new ArrayList<Menu>();
        // create chinese style lunch set menu factory
        menuFactory = new ChineseStyleLunchSetMenuFactory();
        // use menu factory to create chinese style lunch set menu
        chineseMenu = menuFactory.createMenu();
        // add chinese menu to arraylist
        menus.add(chineseMenu);

        // use menu factory to create western style lunch set menu
        menuFactory = new WesternStyleLunchSetMenuFactory();
        // create western style lunch set menu
        westernMenu = menuFactory.createMenu();
        //
        menus.add(westernMenu);

        // create arraylist orders and set orders to OrdersOriginator
        o.setOrders(new ArrayList<Order>());
        // save orders to ordersMementos
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
                menu = chineseMenu; // get chinese menu
            } else if ("w".equals(input)) {
                menu = westernMenu; // get western menu
            } else {
                sc.nextLine();
                System.out.println("Invalid Option!");
                System.out.println();
                return;
            }
            // if menu is not null
            if (menu != null) {
                // get user input
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
        } catch (Exception e) { // catch exception, printout "Invalid Option!" and stop the method
            sc.nextLine();
            System.out.println("Invalid Option!");
            System.out.println();
            return;
        }
    }

    // show menu
    public void showMenu() {
        // loop through each menu in menus and output
        for (int i = 0; i < menus.size(); i++) {
            System.out.println();
            System.out.println(menus.get(i));
            System.out.println();
        }
    }

    // make order
    public void makeOrder() {
        Order order; // order from staff
        Menu menu; // menu
        LunchSetFactory lunchSetFactory; // lunch set factory to create different type of lunch set
        LunchSet lunchSet; // store lunch set object
        int staffNum; // staff number
        int officeLocation; // office location
        try {
            // get user input
            System.out.println();
            System.out.println("Place Order");
            System.out.print("Chinese or Western (c | w):");
            String input = sc.nextLine();
            String teaType = "";
            String side = "";
            // if is chinese menu
            if ("c".equals(input)) {
                menu = chineseMenu; // set menu to chinese menu
                lunchSetFactory = new ChineseStyleLunchSetFactory(); // create chinese style lunch set factory
                lunchSet = lunchSetFactory.createLunchSet(); // use factory to create chinese style lunch set
                lunchSet.setSoup(new ChineseSoup()); // create chinese soup
                lunchSet.setMainDish(menu.getMainDish()); // set main dish
                // check if have enough lunch set
                if (menu.getAvailableCount() > 0) {
                    System.out.print("Oolong Tea: hot or iced (h | i): ");
                    teaType = sc.nextLine();
                    if ("h".equals(teaType)) {
                        lunchSet.setDrink(new OolongTea(true)); // set hot Oolong tea
                    } else if ("i".equals(teaType)) {
                        lunchSet.setDrink(new OolongTea(false)); // set iced Olong tea
                    }
                } else { // if not enough lunch set
                    System.out.println("Sold Out!");
                    System.out.println();
                    return;
                }
            } else if ("w".equals(input)) { // if is western menu
                menu = westernMenu; // set menu to western menu
                lunchSetFactory = new WesternStyleLunchSetFactory(); // create western style lunch set factory
                lunchSet = lunchSetFactory.createLunchSet(); // use factory to create western style lunch set
                lunchSet.setSoup(new WesternSoup()); // create western soup
                lunchSet.setMainDish(menu.getMainDish()); // set main dish
                // check if have enough lunch set
                if (menu.getAvailableCount() > 0) {
                    System.out.print("side: rice, spaghetti, French fries (r | s | f): ");
                    side = sc.nextLine();
                    if ("r".equals(side)) {
                        ((WesternStyleLunchSet) lunchSet).setSide(new Rice()); // set lunch set side to rice
                    } else if ("s".equals(side)) {
                        ((WesternStyleLunchSet) lunchSet).setSide(new Spaghetti()); // set lunch set side to spaghetti
                    } else if ("f".equals(side)) {
                        ((WesternStyleLunchSet) lunchSet).setSide(new FrenchFries()); // set lunch set side to french fries
                    }

                    System.out.print("tea or coffee, hot or iced (ht| it | hc | ic): ");
                    teaType = sc.nextLine();
                    if ("ht".equals(teaType)) {
                        lunchSet.setDrink(new Tea(true)); // set lunch set drink to hot tea
                    } else if ("it".equals(teaType)) {
                        lunchSet.setDrink(new Tea(false)); // set lunch set drink to iced tea
                    } else if ("hc".equals(teaType)) {
                        lunchSet.setDrink(new Coffee(true)); // set lunch set drink to hot coffee
                    } else if ("ic".equals(teaType)) {
                        lunchSet.setDrink(new Coffee(false)); // set lunch set drink to iced coffee
                    }
                } else { // if not enough lunch set
                    System.out.println("Sold Out!");
                    System.out.println();
                    return;
                }
            } else { // if input invlid option
                System.out.println("Invalid Option!");
                System.out.println();
                return;
            }
            // get staff number
            System.out.print("Staff Number:");
            staffNum = sc.nextInt();
            sc.nextLine();
            // check is the staff is ordered or not
            for (int i = 0; i < o.getOrders().size(); i++) {
                if (o.getOrders().get(i).getStaffNum() == staffNum) {
                    System.out.println("Staff is ordered!!!");
                    System.out.println();
                    return;
                }
            }
            // get staff office location
            System.out.print("Office Location:");
            officeLocation = sc.nextInt();
            sc.nextLine();
            order = new Order(lunchSet, staffNum, officeLocation, menu);
        } catch (Exception e) { // catch exception, printout "Invalid Option!" and stop the method
            sc.nextLine();
            System.out.println("Invalid Option!");
            System.out.println();
            return;
        }
        // lunch set available count - 1
        menu.setAvailableCount(menu.getAvailableCount() - 1);

        // add order to orders
        ArrayList<Order> orders = new ArrayList<Order>(o.getOrders());
        orders.add(order);
        System.out.println("Order Placed");
        o.setOrders(orders);

        // save to memento
        ordersMementos.add(o.saveToMemento());
        System.out.println();

    }

    // list outstanding orders
    public void listOutstandingOrders() {
        System.out.println();
        System.out.println("Outstanding Orders");
        // loop through orders in ordersOriginator to get each outstanding order
        for (int i = 0; i < o.getOrders().size(); i++) {
            if (!(o.getOrders().get(i).isOrderCompleted())) {
                System.out.println(o.getOrders().get(i));
            }
        }
        System.out.println();
    }

    // complete fisrt order in the arraylist orders
    public void completeOrder() {
        System.out.println();
        System.out.println("Complete Orders");

        // check if have orders
        if (o.getOrders().size() > 0) {
            o.getOrders().get(0).setOrderCompleted(true);
            System.out.println(o.getOrders().remove(0));
            System.out.println("Order marked as done");
            o.setOrders(o.getOrders());
            ordersMementos.add(o.saveToMemento());
        } else {
            System.out.println("Not orders to complete");
        }
        System.out.println();
    }

    // cancel order
    public void cancelOrder() {
        // restore orders from memento
        o.restoreFromMemento(ordersMementos.get(ordersMementos.size() - 1));
        ArrayList<Order> canceledOrders = new ArrayList<Order>(o.getOrders());

        try {
            // get staff number
            System.out.print("Input the number: ");
            int staffNum = sc.nextInt();
            sc.nextLine();
            // loop through orders to cancel the staff order
            for (int i = 0; i < canceledOrders.size(); i++) {
                if (staffNum == canceledOrders.get(i).getStaffNum()) {
                    System.out.println(canceledOrders.get(i));
                    canceledOrders.get(i).cancel();
                    canceledOrders.remove(i);

                    // save the canceled orders arraylist to ordersMementos
                    o.setOrders(canceledOrders);
                    ordersMementos.add(o.saveToMemento());
                    System.out.println("Order Cancelled");
                    System.out.println();
                    return;
                }
            }
        } catch (Exception e) { // catch exception, output "Invalid Option!" and stop the method
            sc.nextLine();
            System.out.println("Invalid Option!");
            System.out.println();
            return;
        }

        // if staff nubmer not found in orders
        System.out.println("Staff Number Not Found");
        System.out.println();
    }
}
