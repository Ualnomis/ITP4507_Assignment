package Menu;

public class ChineseStyleLunchSetMenu extends Menu {


    public ChineseStyleLunchSetMenu() {}

    public ChineseStyleLunchSetMenu(String mainDishName, double price, int availableCount) {
        super(mainDishName, price, availableCount);
    }

    public Menu clone() {
        return new ChineseStyleLunchSetMenu(super.getMainDish().getName(), super.getPrice(), super.getAvailableCount());
    }

    public String toString() {
            return "Chinese Style Business Set Lunch\n"
                + "main dish: " + super.getMainDish().getName() + "\n"
            + "with rice, Chinese soup, Chinese tea\n"
            + "price: " + super.getPrice() + "\n"
            + "available count: " + super.getAvailableCount();
    }
}
