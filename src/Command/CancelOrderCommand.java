package Command;

public class CancelOrderCommand implements Command {
    private Receiver receiver; // receiver to execute command

    public void execute() {
        receiver.cancelOrder(); // call receiver cancelOrder() method to cancel order
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
