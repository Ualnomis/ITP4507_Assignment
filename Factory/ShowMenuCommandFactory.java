package Factory;

import Command.*;

public class ShowMenuCommandFactory extends CommandFactory {
    public ShowMenuCommandFactory() {}
    public ShowMenuCommandFactory(Receiver receiver) {
        super.setReceiver(receiver);
    }
    public Command createCommand() {
        return new ShowMenuCommand(super.getReceiver(), super.getMenus());
    }

}
