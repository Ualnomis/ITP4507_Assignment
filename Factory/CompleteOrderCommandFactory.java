package Factory;

import Command.*;

public class CompleteOrderCommandFactory extends CommandFactory {

    public CompleteOrderCommandFactory() {}
    public CompleteOrderCommandFactory(Receiver receiver) {
        super.setReceiver(receiver);
    }

    public Command createCommand() {
        return new CompleteOrderCommand(super.getReceiver());
    }
}
