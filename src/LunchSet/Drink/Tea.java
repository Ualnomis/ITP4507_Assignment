package LunchSet.Drink;

public class Tea extends Drink {
    public Tea(boolean isHot) {
        super(isHot);
    }

    public String toString() {
        return super.isHotOrCold() + " Tea";
    }
}
