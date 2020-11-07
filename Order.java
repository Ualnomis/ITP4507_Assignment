public abstract class Order {
    private int staffNum;
    private int officeLocation;
    private LunchSet lunchSet;
    private boolean orderCompleted;

    public boolean isOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    public abstract String getType();

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

    public Order(int staffNum, int officeLocation, LunchSet lunchSet, boolean orderCompleted) {
        this.staffNum = staffNum;
        this.officeLocation = officeLocation;
        this.lunchSet = lunchSet;
        this.orderCompleted = orderCompleted;
    }

    public Order() {
    }

    public abstract String toString();
}
