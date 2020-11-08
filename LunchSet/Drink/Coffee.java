package LunchSet.Drink;
public class Coffee extends Drink {
    public Coffee(boolean isHot) {
        super(isHot);
    }

    public String toString() {
        return super.isHotOrCold() + " Coffee";
    }
}
