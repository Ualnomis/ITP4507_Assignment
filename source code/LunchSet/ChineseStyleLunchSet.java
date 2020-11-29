package LunchSet;

import LunchSet.Side.*;

public class ChineseStyleLunchSet extends LunchSet {
    public String toString() {
        return super.getMainDish().getName() + ", " + super.getSoup() + ", " + super.getDrink();
    }

    // type of the lunch set
    public String getLunchSetType() {
        return "C";
    }
}
