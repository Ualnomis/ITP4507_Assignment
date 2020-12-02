package LunchSet.Drink;

public class OolongTea extends Drink {
    public OolongTea(boolean isHot) {
        super(isHot);
    }
    public String toString() {
        return super.isHotOrCold() + " Tea";
    }
}
