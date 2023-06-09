package ce204_hw1_algo_lib.shapes.abstracts;

/**
 * Abstract class for SimplePolygon shapes
 * @author Duygu
 */
public abstract class SimplePolygon extends Polygon {

    /**
     * @brief Orientation of the shape
     */
    protected double orientation;

    /**
     * @brief Constructor method
     */
    public SimplePolygon() {
        super();
        orientation = 0;
    }

    /**
     * @brief This code defines a method to rotate an object by a given angle in degrees
     * @param degree
     * @return
     */
    @Override
    public void rotate(double degree) {
        this.orientation += degree;
    }

    /**
     * @brief This code defines a method that returns the current orientation of an object
     * @return orientation
     */
    public double getOrientation() {
        return orientation;
    }
}
