package Factory;

import Command.*;

public class CancelOrderCommandFactory extends CommandFactory {
    public CancelOrderCommandFactory() {
    }

    public CancelOrderCommandFactory(Receiver receiver) {
        super.setReceiver(receiver); // set receiver for command use
    }

    public Command createCommand() {
        return new CancelOrderCommand(super.getReceiver()); // create cancel order command with reciever
    }
}
