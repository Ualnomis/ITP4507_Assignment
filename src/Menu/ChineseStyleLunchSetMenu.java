package Menu;

// chinese style lunch set menu
public class ChineseStyleLunchSetMenu extends Menu {

    // no args constructor
    public ChineseStyleLunchSetMenu() {}

    // constructor
    public ChineseStyleLunchSetMenu(String mainDishName, double price, int availableCount) {
        super(mainDishName, price, availableCount);
    }

    //
    public String toString() {
            return "Chinese Style Business Set Lunch\n"
                + "main dish: " + super.getMainDish().getName() + "\n"
            + "with rice, Chinese soup, Chinese tea\n"
            + "price: " + super.getPrice() + "\n"
            + "available count: " + super.getAvailableCount();
    }
}
