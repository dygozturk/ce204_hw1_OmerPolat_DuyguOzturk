package ce204_hw1_algo_lib.shapes.abstracts;

/**
 * Abstract class for Elliptical shapes
 * @author Omer
 */
public abstract class EllipticalShape extends Shape2D {

    /**
     * @brief Semi-major axis of the shapes
     */
    protected double semiMajorAxis;


    /**
     * @brief Constructor method
     */
    public EllipticalShape() {
        super();
        semiMajorAxis = 1;
    }


}
