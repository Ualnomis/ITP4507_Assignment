package Factory;

import Command.Command;
import Command.CompleteOrderCommand;

public class CompleteOrderCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new CompleteOrderCommand(super.getReceiver(), super.getOrders());
    }
}