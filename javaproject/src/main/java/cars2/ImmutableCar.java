package cars2;

public class ImmutableCar implements IColorData {
    private final String make;
    private final int year;
    private final String color;
    private final double topSpeed;

    public ImmutableCar(String make, int year, String color, double topSpeed) {
        this.make = make;
        this.year = year;
        this.color = color;
        this.topSpeed = topSpeed;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public ImmutableCar setMake(String newMake){
        return new ImmutableCar(newMake, getYear(), getColor(), getTopSpeed());
    }

    public ImmutableCar setYear(int newYear){
        return new ImmutableCar(getMake(), newYear, getColor(), getTopSpeed());
    }

    public ImmutableCar setColor(String newColor){
        return new ImmutableCar(getMake(), getYear(), newColor, getTopSpeed());
    }

    public ImmutableCar setTopSpeed(double newTopSpeed){
        return new ImmutableCar(getMake(), getYear(), getColor(), newTopSpeed);
    }
    
    @Override
    public String toString() {
        return getColor() + " " + getYear() + " " + getMake() + " with top speed of " + getTopSpeed() + " mph";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutableCar that = (ImmutableCar) o;

        if (Double.compare(that.topSpeed, topSpeed) != 0) return false;
        if (year != that.year) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (make != null ? !make.equals(that.make) : that.make != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = make != null ? make.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(topSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
