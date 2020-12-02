package Factory;

import Command.*;

public class CompleteOrderCommandFactory extends CommandFactory {

    public CompleteOrderCommandFactory() {}
    public CompleteOrderCommandFactory(Receiver receiver) {
        super.setReceiver(receiver); // receiver of command use
    }

    public Command createCommand() {
        return new CompleteOrderCommand(super.getReceiver()); // create complete order command with receiver
    }
}
