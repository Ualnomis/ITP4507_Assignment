package Menu;

public class WesternStyleLunchSetMenu extends Menu {
    public String toString() {
        return "Western Style Business Set Lunch\n" + "main dish: " + super.getMainDish().getName() + "\n"
                + "with rice/spaghetti/French fries\n" + "price: " + super.getPrice() + "\n" + "available count: "
                + super.getAvailableCount();
    }
}
