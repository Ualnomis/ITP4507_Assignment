package Command;

import java.util.ArrayList;

import LunchSet.LunchSet;

public class ShowMenuCommand implements Command {
    private Receiver receiver;
    private ArrayList<LunchSet> lunchSets;

    public ShowMenuCommand() {

    }

    public ShowMenuCommand(Receiver receiver, ArrayList<LunchSet> lunchSets) {
        this.receiver = receiver;
        this.lunchSets = lunchSets;
    }

    public void execute() {
        receiver.showMenu(lunchSets);
    }
}
