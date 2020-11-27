package Factory;

import java.util.ArrayList;
import Command.*;
import Menu.Menu;
import Order.Order;

public class ListOutstandingOrdersCommandFactory extends CommandFactory {
    public ListOutstandingOrdersCommandFactory() {}
    public ListOutstandingOrdersCommandFactory(Receiver receiver) {
        super.setReceiver(receiver);
    }
    public Command createCommand() {
        return new ListOutstandingOrdersCommand(super.getReceiver());
    }
}
