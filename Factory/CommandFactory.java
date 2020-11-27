package Factory;

import java.util.ArrayList;

import Command.*;
import Menu.Menu;
import Order.Order;

public abstract class CommandFactory {
    private Receiver receiver;

    public abstract Command createCommand();

    public Receiver getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public CommandFactory(Receiver receiver) {
        this.receiver = receiver;
    }

    public CommandFactory() {
    }

}
