import java.util.*;

import Command.*;
import Factory.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner
        String input = ""; // user input
        Command command; // store different command
        CommandFactory factory = null; // store different command factory
        Invoker invoker = new Invoker(); // invoker
        Receiver receiver = new Receiver(sc); // receiver

        // while not done
        for (;;) {
            // ask user input
            System.out.println("Please enter command: [e | s | p | c | l | n | d | q]");
            System.out.println("e = Edit menu, s = Show menu, p = Place order, c = Cancel order,");
            System.out.println("l = List orders, d = order is Done, q = Quit");

            // get user input
            if (sc.hasNextLine()) {
                input = sc.nextLine();
            } else {
                return;
            }

            // check what function user input
            if ("q".equals(input)) { // input q and exit the system
                System.exit(0); // exit the system
            } else if ("e".equals(input)) { // input e to edit menu
                factory = new EditMenuCommandFactory(receiver); // create edit menu command factory
            } else if ("s".equals(input)) { // input s to show menu
                factory = new ShowMenuCommandFactory(receiver); // create edit menu command factory
            } else if ("p".equals(input)) { // input p to place order
                factory = new MakeOrderCommandFactory(receiver); // create place order command factory
            } else if ("c".equals(input)) { // input c to cancel order
                factory = new CancelOrderCommandFactory(receiver); // create cancel order command factory
            } else if ("l".equals(input)) { // input l to list outstanding orders
                factory = new ListOutstandingOrdersCommandFactory(receiver); // create list outstanding orders command
                                                                             // factory
            } else if ("n".equals(input)) {
            } else if ("d".equals(input)) { // input d to finish the order
                factory = new CompleteOrderCommandFactory(receiver); // create complete order command factory
            } else { // if input error
                System.out.println();
                System.out.println("Invalid Option!");
                System.out.println();
                factory = null;
            }

            if (factory != null) {
                command = factory.createCommand(); // create edit menu command
                invoker.setCommand(command); // set the target command to control
                invoker.invoke(); // execute the command
                factory = null; // set factory to null
            }
        }
    }
}
