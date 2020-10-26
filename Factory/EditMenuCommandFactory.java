package Factory;
import Command.*;

public class EditMenuCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new EditMenuCommand(receiver);
    }
}
