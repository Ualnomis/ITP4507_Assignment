package Menu;

import LunchSet.*;

// menu
public abstract class Menu {
    private MainDish mainDish; // main dish of the menu
    private double price; // price of the menu lunchset
    private int availableCount; // amount of the menu lunchset

    public MainDish getMainDish() {
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

    public void setMainDish(String name) {
        this.mainDish.setName(name);
    }

    public Menu() {
        this.mainDish = new MainDish();
    }

    public Menu(String mainDishName, double price, int availableCount) {
        this.mainDish = new MainDish();
        this.mainDish.setName(mainDishName);
        this.price = price;
        this.availableCount = availableCount;
    }

}
