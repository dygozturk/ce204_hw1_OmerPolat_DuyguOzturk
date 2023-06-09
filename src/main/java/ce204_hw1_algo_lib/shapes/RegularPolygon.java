package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.SimplePolygon;

/**
 * RegularPolygon class
 * @author Duygu
 * @see SimplePolygon
 */
public class RegularPolygon extends SimplePolygon {


    protected int numPoints;

    protected double radius;

    
    public RegularPolygon() {
        this(0, 1);
    }

    /**
     * @param numPoints
     * @param radius
     */
    public RegularPolygon(int numPoints, double radius) {
        super();
        this.numPoints = numPoints;
        this.radius = radius;
    }


    /**
     * @brief to set the number of points of the polygon
     * @param numPoints
     */
    public void changeNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    /**
     * @brief multiplies the radius of the polygon by the given scale
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        radius *= scale;
    }

    /**
     * @brief Calculates the area of a regular polygon using the formula
     */
    @Override
    public double getArea() {
        double sideLength = getSideLength();
        return numPoints * sideLength * sideLength * Math.pow(Math.tan(Math.PI / numPoints), -1) / 4;
    }

    /**
     * @ brief To set the perimeter of a regular polygon, the number of sides and the length of the sides are multiplied.
     */
    @Override
    public double getPerimeterLength() {
        return numPoints * getSideLength();
    }

    /**
     * @brief Calculates the length of a side of a regular polygon using the formula
     * @return the length of a side of the polygon
     */
    public double getSideLength() {
        return 2 * radius * Math.sin(Math.PI / numPoints);
    }

    /**
     * @brief The method used to find the vertices of a polygon.
     * @return an array of points that are the vertices of the polygon
     */
    public Point[] getVertices() {
        Point[] vertices = new Point[numPoints];
        Point center = getCenter();
        
        for (int i = 0; i < numPoints; i++) {
            vertices[i] = new Point(center.getX() + radius * Math.cos(2 * Math.PI * i / numPoints + orientation),
                    center.getY() + radius * Math.sin(2 * Math.PI * i / numPoints + orientation));
        }
        return vertices;
    }
}
