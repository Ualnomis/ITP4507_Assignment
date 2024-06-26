package LunchSet.Drink;

public abstract class Drink {
    private boolean isHot; // drink is how of not

    public Drink(boolean isHot) {
        this.isHot = isHot;
    }

    public String isHotOrCold() {
        return isHot ? "Hot" : "Iced";
    }

    public void setHot(boolean isHot) {
        this.isHot = isHot;
    }

    public abstract String toString();
}
