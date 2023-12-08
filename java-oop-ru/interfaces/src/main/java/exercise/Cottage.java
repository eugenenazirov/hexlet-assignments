package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return area;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public int compareTo(Home other) {
        return Double.compare(getArea(), other.getArea());
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж "
                + "площадью " + area
                + " метров";
    }
}
// END
