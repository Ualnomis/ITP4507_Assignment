package Factory;

import java.util.ArrayList;

import Command.*;
import Menu.Menu;
import Order.Order;

// command factory
public abstract class CommandFactory {
    private Receiver receiver; // receiver for command use

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
