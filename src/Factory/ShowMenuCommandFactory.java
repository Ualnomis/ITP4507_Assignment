package Factory;

import Command.*;

public class ShowMenuCommandFactory extends CommandFactory {
    public ShowMenuCommandFactory() {}
    public ShowMenuCommandFactory(Receiver receiver) {
        super.setReceiver(receiver); // get receiver for create command object
    }
    public Command createCommand() {
        return new ShowMenuCommand(super.getReceiver()); // create show menu command and pass receiver to it
    }

}
