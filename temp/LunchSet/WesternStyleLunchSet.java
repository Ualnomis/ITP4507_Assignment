package LunchSet;

import LunchSet.Side.*;

public class WesternStyleLunchSet extends LunchSet {
    private Side side;

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public String toString() {
        return super.getMainDish().getName() + ", " + side + ", " + super.getSoup() + ", " + super.getDrink();
    }

    public String getLunchSetType() {
        return "W";
    }
}
