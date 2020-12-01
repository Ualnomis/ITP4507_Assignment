package LunchSet;

import LunchSet.Side.*;

public class WesternStyleLunchSet extends LunchSet {
    private Side side; // side of the western style lunch set

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public String toString() {
        // return lunch set maindish name, soup and drink
        return super.getMainDish().getName() + ", " + side + ", " + super.getSoup() + ", " + super.getDrink();
    }

    public String getLunchSetType() {
        return "W";
    }
}
