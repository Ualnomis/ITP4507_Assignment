package Factory;

import Command.*;

public class MakeOrderCommandFactory extends CommandFactory {
    public MakeOrderCommandFactory() {}
    public MakeOrderCommandFactory(Receiver receiver) {
        super.setReceiver(receiver);
    }
    public Command createCommand() {
        return new MakeOrderCommand(super.getReceiver());
    }
}


