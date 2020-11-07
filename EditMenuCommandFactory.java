public class EditMenuCommandFactory extends CommandFactory {
    public Command createCommand() {
        return new EditMenuCommand(super.getReceiver(), super.getLunchSets());
    }
}
