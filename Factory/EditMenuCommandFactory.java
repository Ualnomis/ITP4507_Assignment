package Factory;

import Command.*;

public class EditMenuCommandFactory extends CommandFactory {
    public EditMenuCommandFactory() {}
    public EditMenuCommandFactory(Receiver receiver) {
        super.setReceiver(receiver);
    }
    public Command createCommand() {
        return new EditMenuCommand(super.getReceiver());
    }

}
