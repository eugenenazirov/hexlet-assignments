package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area + balconyArea;
    }

    public double getBalconyArea() {
        return balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    public int compareTo(Home other) {
        return Double.compare((area + balconyArea), other.getArea());
    }

    @Override
    public String toString() {
        return "Квартира " +
                "площадью " + (area + balconyArea) +
                " метров на " + floor +
                " этаже";
    }
}
// END
