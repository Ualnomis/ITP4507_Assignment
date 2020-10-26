import java.util.*;

import Factory.*;
import Command.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        boolean done = false;
        String input = "";
        Command command;
        CommandFactory factory;
        Invoker invoker = new Invoker();

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
                command = factory.createCommand(); // create edit menu command
                invoker.setCommand(command);
                invoker.invoke();
            }
        }
    }
}