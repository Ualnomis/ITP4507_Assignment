package Menu;

public class WesternStyleLunchSetMenu extends Menu {

    // no args constructor
    public WesternStyleLunchSetMenu() {}

    // constructor
    public WesternStyleLunchSetMenu(String mainDishName, double price, int availableCount) {
        super(mainDishName, price, availableCount);
    }

    public String toString() {
        return "Western Style Business Set Lunch\n" + "main dish: " + super.getMainDish().getName() + "\n"
                + "with rice/spaghetti/French fries\n" + "price: " + super.getPrice() + "\n" + "available count: "
                + super.getAvailableCount();
    }
}
