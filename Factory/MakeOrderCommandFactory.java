package Factory;

import Command.Command;
import Command.MakeOrderCommand;

public class MakeOrderCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new MakeOrderCommand(super.getReceiver(), super.getMenus(), super.getOrders());
    }
}


