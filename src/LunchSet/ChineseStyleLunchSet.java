package LunchSet;

import LunchSet.Side.*;

// chinese style lunch set
public class ChineseStyleLunchSet extends LunchSet {
    public String toString() {
        // return lunch set maindish name, soup and drink
        return super.getMainDish().getName() + ", " + super.getSoup() + ", " + super.getDrink();
    }

    // type of the lunch set
    public String getLunchSetType() {
        return "C";
    }
}
