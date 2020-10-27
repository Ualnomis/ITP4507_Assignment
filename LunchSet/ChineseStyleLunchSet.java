package LunchSet;

public class ChineseStyleLunchSet extends LunchSet {
    public String toString() {
        return "Chinese Style Business Set Lunch\n"
            + "main dish: " + super.getMainDish() + "\n"
            + "with rice, Chinese soup, Chinese tea\n"
            + "price: " + super.getPrice() + "\n"
            + "available count: " + super.getAvailableCount();
    } 
}
