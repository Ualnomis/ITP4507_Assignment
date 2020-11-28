package Order;

import LunchSet.LunchSet;

public class Order {
    private LunchSet lunchSet; // which lunchset ordered
    private int staffNum; // staff who order the lunchset
    private int officeNum; // the location office number of the staff
    private boolean isOrderCompleted; // store order complete status

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

    public String toString() {
        return lunchSet.getLunchSetType() + ": " + staffNum + ", " + officeNum + ", " + lunchSet;
    }

    public Order(LunchSet lunchSet, int staffNum, int officeNum) {
        this.lunchSet = lunchSet;
        this.staffNum = staffNum;
        this.officeNum = officeNum;
    }
}
