package Order;

import LunchSet.*;
import Menu.*;

public class Order {
    private LunchSet lunchSet; // which lunchset ordered
    private int staffNum; // staff who order the lunchset
    private int officeNum; // the location office number of the staff
    private boolean isOrderCompleted; // store order complete status
    private Menu menu;

    public LunchSet getLunchSet() {
        return lunchSet;
    }

    public boolean isOrderCompleted() {
        return isOrderCompleted;
    }

    public void setOrderCompleted(boolean isOrderCompleted) {
        this.isOrderCompleted = isOrderCompleted;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }

    public int getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }

    public void setLunchSet(LunchSet lunchSet) {
        this.lunchSet = lunchSet;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String toString() {
        return lunchSet.getLunchSetType() + ": " + staffNum + ", " + officeNum + ", " + lunchSet;
    }

    public Order(LunchSet lunchSet, int staffNum, int officeNum) {
        this.lunchSet = lunchSet;
        this.staffNum = staffNum;
        this.officeNum = officeNum;
    }

    public Order(LunchSet lunchSet, int staffNum, int officeNum, Menu menu) {
        this.lunchSet = lunchSet;
        this.staffNum = staffNum;
        this.officeNum = officeNum;
        this.menu = menu;
    }

    public void cancel() {
        this.menu.setAvailableCount(this.menu.getAvailableCount() + 1);
    }
}
