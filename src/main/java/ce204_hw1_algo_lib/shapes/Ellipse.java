package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.EllipticalShape;

/**
 * @brief Ellipse class
 * @author Omer
 * @see EllipticalShape
 */
public class Ellipse extends EllipticalShape {


    protected double semiMinorAxis;

    protected double orientation;
 
    public Ellipse() {
        super();
        semiMinorAxis = 1;
        orientation = 0;
    }


    /**
     * @brief rotate the shape around the center
     */
    @Override
    public void rotate(double degree) {
        orientation += degree;
    }

    /**
     * *******************
     * @brief This method changes the scale of an ellipse by multiplying both 
     * its semi-major and semi-minor axis lengths by a specified scale factor. 
     * It updates the values of the semiMajorAxis and semiMinorAxis instance variables of the ellipse object.
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        semiMajorAxis *= scale;
        semiMinorAxis *= scale;
    }

    /**
     * **********************
     * @brief This method calculates the area of an ellipse using the formula pi * semi-major 
     * axis length * semi-major axis length and returns the result as a double value.
     * @return area
     */
    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    /**
     * ********************************
     * @brief This method calculates the perimeter length of an ellipse using its 
     * semi-major and semi-minor axis lengths.
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * Math.PI * Math.sqrt((semiMajorAxis * semiMajorAxis + semiMinorAxis * semiMinorAxis) / 2);
    }

    /**
     * ***************************
     * @brief This method calculates and returns a bounding rectangle for an ellipse with non-zero orientation
     *  by computing its top, bottom, left, and right heights and widths based on the ellipse's 
     *  semi-major and semi-minor axis lengths and orientation. It creates a new Rectangle object, 
     *  sets its center, width, and height properties based on the computed values, and then returns the newly created rectangle.
     * @return bounding rectangle
     */
    @Override
    public Rectangle getBoundingRect() {
        double topHeight = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.cos(Math.toRadians(orientation)), 2));
        double bottomHeight = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.cos(Math.toRadians(orientation + 90)), 2));
        double leftWidth = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.sin(Math.toRadians(orientation)), 2));
        double rightWidth = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.sin(Math.toRadians(orientation + 90)), 2));

        double width = leftWidth + rightWidth;
        double height = topHeight + bottomHeight;

        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(width);
        boundingRect.setHeight(height);
        return boundingRect;
    }


    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }


    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }


    /**
     * ********************************
     * @brief This method calculates and returns the first focus point of an ellipse using its semi-major 
     * and semi-minor axis lengths and orientation. It computes the distance between the center and
     *  the focus point using the formula sqrt(semi-major axis length squared - semi-minor axis length 
     *  squared) and then calculates the coordinates of the focus point based on the center point and the orientation angle.
     * The method returns the first focus point as a new Point object.
     * @return first focus
     */
    public Point getFocus1() {
        double c = Math.sqrt(semiMajorAxis * semiMajorAxis - semiMinorAxis * semiMinorAxis);
        double x = center.getX() + c * Math.cos(Math.toRadians(orientation));
        double y = center.getY() + c * Math.sin(Math.toRadians(orientation));
        return new Point(x, y);
    }

    /**
     * ****************************
     * @brief This method calculates and returns the second focus point of an ellipse using its semi-major and semi-minor axis lengths
     *  and orientation. It computes the distance between the center and the focus point using the formula 
     *  sqrt(semi-major axis length squared - semi-minor axis length squared) and then calculates the coordinates of the
     *   focus point based on the center point and the orientation angle.
     *  The method returns the second focus point as a new Point object.
     * @return second focus
     */
    public Point getFocus2() {
        double c = Math.sqrt(semiMajorAxis * semiMajorAxis - semiMinorAxis * semiMinorAxis);
        double x = center.getX() - c * Math.cos(Math.toRadians(orientation));
        double y = center.getY() - c * Math.sin(Math.toRadians(orientation));
        return new Point(x, y);
    }


    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }


    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }


    public double getOrientation() {
        return orientation;
    }

    
    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }
}
