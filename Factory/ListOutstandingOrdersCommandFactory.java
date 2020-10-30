package Factory;

import Command.Command;
import Command.ListOutstandingOrdersCommand;

public class ListOutstandingOrdersCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new ListOutstandingOrdersCommand(super.getReceiver(), super.getOrders());
    } 
}
