package Factory;

import java.util.ArrayList;

import Command.*;
import LunchSet.LunchSet;

public abstract class CommandFactory {
    private Receiver receiver = new Receiver();
    private ArrayList<LunchSet> lunchSets;

    public abstract Command createCommand();

    public ArrayList<LunchSet> getLunchSets() {
        return lunchSets;
    }

    public void setLunchSets(ArrayList<LunchSet> lunchSets) {
        this.lunchSets = lunchSets;
    }

    public Receiver getReceiver() {
        return this.receiver;
    }
}
