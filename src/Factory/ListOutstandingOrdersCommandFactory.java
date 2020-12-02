package Factory;

import Command.*;

public class ListOutstandingOrdersCommandFactory extends CommandFactory {
    public ListOutstandingOrdersCommandFactory() {}
    public ListOutstandingOrdersCommandFactory(Receiver receiver) {
        super.setReceiver(receiver); // receiver of command use
    }
    public Command createCommand() {
        return new ListOutstandingOrdersCommand(super.getReceiver()); // create list outstanding orders command with receiver
    }
}
