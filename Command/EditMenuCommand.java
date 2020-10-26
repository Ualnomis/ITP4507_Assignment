package Command;

import java.util.*;
public class EditMenuCommand implements Command {
    private Receiver receiver;
    public EditMenuCommand() {

    }
    public EditMenuCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.editMenu();
    }
}
