package Factory;

import Command.*;

public class ShowMenuCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new ShowMenuCommand(super.getReceiver(), super.getMenus());
    }

}