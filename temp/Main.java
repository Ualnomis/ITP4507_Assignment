import java.util.*;

import Command.*;
import Factory.*;
import Menu.*;
import Order.Order;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        String input = "";
        Command command;
        CommandFactory factory = null;
        MenuFactory menuFactory;
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver(sc);
        ArrayList<Menu> menus = new ArrayList<Menu>();
        ArrayList<Order> orders = new ArrayList<Order>();

        menuFactory = new ChineseStyleLunchSetMenuFactory();
        menus.add(menuFactory.createMenu());
        menuFactory = new WesternStyleLunchSetMenuFactory();
        menus.add(menuFactory.createMenu());

        while (!done) {
            // ask user input
            System.out.println("Please enter command: [e | s | p | c | l | n | d | q]");
            System.out.println("e = Edit menu, s = Show menu, p = Place order, c = Cancel order,");
            System.out.println("l = List orders, d = order is Done, q = Quit");

            // get user input
            input = sc.nextLine();

            // input q and exit the system
            if ("q".equals(input)) {
                done = true;
                System.exit(0);
            } else if ("e".equals(input)) { // input e to edit menu
                factory = new EditMenuCommandFactory(); // create edit menu command factory
            } else if ("s".equals(input)) { // input s to show menu
                factory = new ShowMenuCommandFactory(); // create edit menu command factory
            } else if ("p".equals(input)) { // input p to place order
                factory = new MakeOrderCommandFactory(); // create place order command factory
            } else if ("c".equals(input)) { // input c to cancel order
                factory = new CancelOrderCommandFactory(); // create cancel order command factory
            } else if ("l".equals(input)) { // input l to list outstanding orders
                factory = new ListOutstandingOrdersCommandFactory(); // create list outstanding orders command factory
            } else if ("n".equals(input)) {

            } else if ("d".equals(input)) { // input d to finish the order
                factory = new CompleteOrderCommandFactory(); // create complete order command factory
            } else { // if input error
                System.out.println("Invalid Option!");
                factory = null;
            }

            if (factory != null) {
                factory.setReceiver(receiver);
                factory.setOrders(orders);
                factory.setMenus(menus);
                command = factory.createCommand(); // create edit menu command
                invoker.setCommand(command); // set the target command to control
                invoker.invoke(); // execute the command
                factory = null;
            }
        }
    }
}
