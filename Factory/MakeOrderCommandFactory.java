package Factory;

import Command.*;

public class MakeOrderCommandFactory extends CommandFactory {
    public MakeOrderCommandFactory() {}
    public MakeOrderCommandFactory(Receiver receiver) {
        super.setReceiver(receiver); // receiver for create make order command
    }
    public Command createCommand() {
        return new MakeOrderCommand(super.getReceiver()); // create make order command and pass receiver to it
    }
}


