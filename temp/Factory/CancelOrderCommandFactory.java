package Factory;

import Command.*;

public class CancelOrderCommandFactory extends CommandFactory {
    public CancelOrderCommandFactory() {
    }

    public CancelOrderCommandFactory(Receiver receiver) {
        super.setReceiver(receiver);
    }

    public Command createCommand() {
        return new CancelOrderCommand(super.getReceiver());
    }
}
