public class WesternStyleLunchSetOrder extends Order {
    private String side;
    private String teaType;

    public String getType() {
        return "W";
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

    public WesternStyleLunchSetOrder(int staffNum, int officeLocation, LunchSet lunchSet, boolean orderCompleted,
            String side, String teaType) {
        super(staffNum, officeLocation, lunchSet, orderCompleted);
        this.side = side;
        this.teaType = teaType;
    }

    public WesternStyleLunchSetOrder(String side, String teaType) {
        this.side = side;
        this.teaType = teaType;
    }

    public WesternStyleLunchSetOrder() {
    }

    public String toString() {
        return this.getType() + ": " + super.getStaffNum() + ", " + super.getOfficeLocation() + ", "
                + super.getLunchSet().getMainDish() + ", " + this.getSide() + ", Western Soup, " + this.getTeaType();
    }
}
