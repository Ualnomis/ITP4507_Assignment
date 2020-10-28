import java.util.*;

import Factory.*;
import LunchSet.ChineseStyleLunchSet;
import LunchSet.LunchSet;
import LunchSet.WesternStyleLunchSet;
import Command.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        String input = "";
        Command command;
        LunchSetFactory lunchSetFactory;
        CommandFactory factory;
        Invoker invoker = new Invoker();
        ArrayList<LunchSet> lunchSets = new ArrayList<LunchSet>();

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
                factory.setLunchSets(lunchSets);
                command = factory.createCommand(); // create edit menu command
                invoker.setCommand(command); // set the target command to control
                invoker.invoke(); // execute the command
            } else if ("s".equals(input)) { // input s to show menu
                factory = new ShowMenuCommandFactory(); // create edit menu command factory
                factory.setLunchSets(lunchSets);
                command = factory.createCommand(); // create edit menu command
                invoker.setCommand(command); // set the target command to control
                invoker.invoke(); // execute the command 
            } else if ("p".equals(input)) {

            } else if ("c".equals(input)) {

            } else if ("l".equals(input)) {

            } else if ("n".equals(input)) {

            } else if ("d".equals(input)) {

            } else if ("q".equals(input)) {

            } else {

            }

        }
    }
}