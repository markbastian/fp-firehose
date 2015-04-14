package cars;

public class Car {
    private String make = null;
    private int year = 0;
    private String color = null;
    private double topSpeed = 0.0;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return getColor() + " " + getYear() + " " + getMake() + " with top speed of " + getTopSpeed() + " mph";
    }
}
