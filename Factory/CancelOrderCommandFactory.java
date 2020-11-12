package Factory;

import Command.CancelOrderCommand;
import Command.Command;

public class CancelOrderCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new CancelOrderCommand(super.getReceiver());
    }
}
