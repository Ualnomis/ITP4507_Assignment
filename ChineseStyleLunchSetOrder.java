public class ChineseStyleLunchSetOrder extends Order {
    private String teaType;

    public String getType() {
        return "C";
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public ChineseStyleLunchSetOrder(int staffNum, int officeLocation, LunchSet lunchSet, boolean orderCompleted,
            String teaType) {
        super(staffNum, officeLocation, lunchSet, orderCompleted);
        this.teaType = teaType;
    }

    public ChineseStyleLunchSetOrder(String teaType) {
        this.teaType = teaType;
    }

    public ChineseStyleLunchSetOrder() {
    }

    public String toString() {
        return this.getType() + ": " + super.getStaffNum() + ", " + super.getOfficeLocation() + ", "
                + super.getLunchSet().getMainDish() + ", Chinese Soup, " + this.getTeaType();
    }
}
