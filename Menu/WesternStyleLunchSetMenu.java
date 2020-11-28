package Menu;

public class WesternStyleLunchSetMenu extends Menu {

    public WesternStyleLunchSetMenu() {}


    public WesternStyleLunchSetMenu(String mainDishName, double price, int availableCount) {
        super(mainDishName, price, availableCount);
    }
    public Menu clone() {
        return new WesternStyleLunchSetMenu(super.getMainDish().getName(), super.getPrice(), super.getAvailableCount());
    }
    public String toString() {
        return "Western Style Business Set Lunch\n" + "main dish: " + super.getMainDish().getName() + "\n"
                + "with rice/spaghetti/French fries\n" + "price: " + super.getPrice() + "\n" + "available count: "
                + super.getAvailableCount();
    }
}
