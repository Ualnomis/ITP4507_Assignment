public abstract class LunchSet {
    private String mainDish;
    private double price;
    private int availableCount;

    public String getMainDish() {
        return mainDish;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }
}
