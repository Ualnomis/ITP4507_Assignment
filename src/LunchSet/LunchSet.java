package LunchSet;

import LunchSet.Drink.*;
import LunchSet.Soup.*;

public abstract class LunchSet {
    private MainDish mainDish; // lunch set main dish
    private Drink drink; // lunch set drink
    private Soup soup; // lunch set soup

    public abstract String toString();

    public Soup getSoup() {
        return soup;
    }

    public void setSoup(Soup soup) {
        this.soup = soup;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public MainDish getMainDish() {
        return mainDish;
    }

    public void setMainDish(MainDish mainDish) {
        this.mainDish = mainDish;
    }

    public abstract String getLunchSetType();
}
