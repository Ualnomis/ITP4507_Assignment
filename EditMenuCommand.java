
import java.util.*;


public class EditMenuCommand implements Command {
    private Receiver receiver;
    private ArrayList<LunchSet> lunchSets;

    public EditMenuCommand() {

    }

    public ArrayList<LunchSet> getLunchSets() {
        return lunchSets;
    }

    public void setLunchSets(ArrayList<LunchSet> lunchSets) {
        this.lunchSets = lunchSets;
    }

    public EditMenuCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.editMenu(lunchSets);
    }

    public EditMenuCommand(Receiver receiver, ArrayList<LunchSet> lunchSets) {
        this.receiver = receiver;
        this.lunchSets = lunchSets;
    }

}
