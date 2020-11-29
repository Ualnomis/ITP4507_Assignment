package Command;

public class CancelOrderCommand implements Command {
    private Receiver receiver;

    public void execute() {
        receiver.cancelOrders();
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public CancelOrderCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
