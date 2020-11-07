public class WesternStyleLunchSet extends LunchSet {
    public String toString() {
        return "Western Style Business Set Lunch\n"
            + "main dish: " + super.getMainDish() + "\n"
            + "with rice/spaghetti/French fries\n"
            + "price: " + super.getPrice() + "\n"
            + "available count: " + super.getAvailableCount();
    } 
}
