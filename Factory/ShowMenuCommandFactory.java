package Factory;

import Command.Command;
import Command.ShowMenuCommand;

public class ShowMenuCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new ShowMenuCommand(super.getReceiver(), super.getLunchSets());
    } 
}
