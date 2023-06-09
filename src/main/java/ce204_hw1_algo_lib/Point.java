package ce204_hw1_algo_lib;


/**
 * Point class
 * @author Omer
 */
public class Point {


    private double x;
    private double y;


    public Point() {
        x = 0;
        y = 0;
    }


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }


    public void rotate(double degree, Point center) {
        double x = this.x - center.x;
        double y = this.y - center.y;

        double rad = Math.toRadians(degree);
        this.x = x * Math.cos(rad) - y * Math.sin(rad) + center.x;
        this.y = x * Math.sin(rad) + y * Math.cos(rad) + center.y;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}


