package Command;

public class EditMenuCommand implements Command {
    private Receiver receiver;

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public EditMenuCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.editMenu();
    }

}
