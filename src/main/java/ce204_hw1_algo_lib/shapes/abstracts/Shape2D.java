package ce204_hw1_algo_lib.shapes.abstracts;

import ce204_hw1_algo_lib.Point;

/**
 * Abstract class for 2D shapes
 * @author Duygu
 */
public abstract class Shape2D {

    /**
     * @brief Center of the shape
     */
    protected Point center;

    public Shape2D() {
        center = new Point();
    }

    /**
     * @brief This method translates the geometric object by the given amounts in the x and y directions
     * @param dx
     * @param dy
     * @return
     */
    public void translate(double dx, double dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }

    /**
     * @brief This code returns the center Point of the shape.
     * @return center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @brief to set the center of the shape
     * @param center
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * @brief This code defines a method to rotate an object by a given angle in degrees
     * @param degree
     */
    public abstract void rotate(double degree);

    /**
     * @brief this code defines a method to scale the shape around the center
     * @param scale
     */
    public abstract void changeScale(double scale);

    /**
     * @brief generated method to get the area of the shape
     * @return area
     */
    public abstract double getArea();

    /**
     * @brief method to use to get the perimeter length of the shape
     * @return perimeter length
     */
    public abstract double getPerimeterLength();

    /**
     * @brief method to use to get the shape's bounding rectangle
     * @return bounding rectangle
     */
    public abstract Shape2D getBoundingRect();

}
