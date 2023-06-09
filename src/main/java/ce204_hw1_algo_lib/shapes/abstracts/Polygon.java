package ce204_hw1_algo_lib.shapes.abstracts;

import ce204_hw1_algo_lib.Point;

/**
 * Abstract class for Polygon shapes
 * @author Omer
 */
public abstract class Polygon extends Shape2D {


    public Polygon() {
        super();
    }

    /**
     * @brief method to use to get the shape's bounding rectangle
     * @return null bounding rectangle
     */
    public Shape2D getBoundingRect() {
        return null;
    }

    /**
     * @brief method to use to get the vertices of the shape
     * @return null vertices
     */
    public Point[] getVertices() {
        return null;
    }
}
