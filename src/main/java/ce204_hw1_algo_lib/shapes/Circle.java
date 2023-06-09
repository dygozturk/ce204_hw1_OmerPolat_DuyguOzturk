package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.shapes.abstracts.EllipticalShape;

/**
 * @brief Circle class
 * @author omer
 * @see EllipticalShape
 */
public class Circle extends EllipticalShape {

    public Circle() {
        super();
    }

    @Override
    public void rotate(double degree) {}

    
    @Override
    public void changeScale(double scale) {
        semiMajorAxis *= scale;
    }


    /**
     * **************
     *  @brief This method calculates the area of an ellipse using
     *  the formula pi * semi-major axis length * semi-major axis length and returns the result as a double value.
     * @return area
     */
    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMajorAxis;
    }

    /**
     * ****************
     * @brief This method calculates the perimeter length of an ellipse using
     *  the formula 2 * pi * semi-major axis length and returns the result as a double value.
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * Math.PI * semiMajorAxis;
    }

    /**
     * ************************
     * @brief This method calculates and returns a bounding rectangle 
     * for an ellipse based on its center point and semi-major axis length.
     * @return bounding rectangle
     */
    @Override
    public Rectangle getBoundingRect() {
        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(semiMajorAxis * 2);
        boundingRect.setHeight(semiMajorAxis * 2);
        return boundingRect;
    }
}
