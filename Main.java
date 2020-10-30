import java.util.*;

import Factory.*;
import LunchSet.ChineseStyleLunchSet;
import LunchSet.LunchSet;
import LunchSet.WesternStyleLunchSet;
import Order.Order;
import Command.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        String input = "";
        Command command;
        LunchSetFactory lunchSetFactory;
        CommandFactory factory = null;
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        ArrayList<LunchSet> lunchSets = new ArrayList<LunchSet>();
        ArrayList<Order> orders = new ArrayList<Order>();

        lunchSetFactory = new ChineseStyleLunchSetFactory();
        lunchSets.add(lunchSetFactory.createLunchSet());
        lunchSetFactory = new WesternStyleLunchSetFactory();
        lunchSets.add(lunchSetFactory.createLunchSet());

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
            } else if ("p".equals(input)) {
                factory = new MakeOrderCommandFactory();
            } else if ("c".equals(input)) {
                factory = new CompleteOrdersCommandFactory();
            } else if ("l".equals(input)) {
                factory = new ListOutstandingOrdersCommandFactory();
            } else if ("n".equals(input)) {

            } else if ("d".equals(input)) {

            } else if ("q".equals(input)) {

            } else {
                System.out.println("Invalid Option!");
                factory = null;
            }

            if (factory != null) {
                factory.setReceiver(receiver);
                factory.setLunchSets(lunchSets);
                factory.setOrders(orders);
                command = factory.createCommand(); // create edit menu command
                invoker.setCommand(command); // set the target command to control
                invoker.invoke(); // execute the command
                factory = null;
            }
        }
    }
}