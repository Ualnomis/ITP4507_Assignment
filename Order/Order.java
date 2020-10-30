package Order;

import LunchSet.LunchSet;

public class Order {
    private int staffNum;
    private int officeLocation;
    private LunchSet lunchSet;
    private String type;
    private String side;
    private String teaType;
    private boolean orderCompleted;

    public String toString() {
        return this.type + ": " + this.staffNum + ", " + this.officeLocation + ", " + lunchSet.getMainDish() + ", "
                + this.side + ", Chinese Soup" + ", " + this.teaType;
    }

    public boolean isOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(int officeLocation) {
        this.officeLocation = officeLocation;
    }

    public LunchSet getLunchSet() {
        return lunchSet;
    }

    public void setLunchSet(LunchSet lunchSet) {
        this.lunchSet = lunchSet;
    }

    public int getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }

    public Order() {
    }

    public Order(int staffNum, int officeLocation, LunchSet lunchSet) {
        this.staffNum = staffNum;
        this.setOfficeLocation(officeLocation);
        this.lunchSet = lunchSet;
        this.orderCompleted = false;
    }

    public Order(int staffNum, int officeLocation, LunchSet lunchSet, String type) {
        this.staffNum = staffNum;
        this.officeLocation = officeLocation;
        this.lunchSet = lunchSet;
        this.type = type;
        this.orderCompleted = false;
    }

    public Order(int staffNum, int officeLocation, LunchSet lunchSet, String type, String side, String teaType) {
        this.staffNum = staffNum;
        this.officeLocation = officeLocation;
        this.lunchSet = lunchSet;
        this.type = type;
        this.side = side;
        this.teaType = teaType;
        this.orderCompleted = false;
    }

    public Order(int staffNum, int officeLocation, LunchSet lunchSet, String type, String teaType) {
        this.staffNum = staffNum;
        this.officeLocation = officeLocation;
        this.lunchSet = lunchSet;
        this.type = type;
        this.teaType = teaType;
        this.side = "";
        this.orderCompleted = false;
    }
}
