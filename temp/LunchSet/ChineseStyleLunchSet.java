package LunchSet;

import LunchSet.Side.*;

public class ChineseStyleLunchSet extends LunchSet {
    public String toString() {
        return super.getMainDish().getName() + ", " + super.getSoup() + ", " + super.getDrink();
    }

    public String getLunchSetType() {
        return "C";
    }
}
