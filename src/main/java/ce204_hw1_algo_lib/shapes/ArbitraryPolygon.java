package ce204_hw1_algo_lib.shapes;

import java.util.ArrayList;
import java.util.List;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.Polygon;


/**
 * A polygon with arbitrary number of vertices.
 * @author Duygu
 * @see Polygon
 *
 */
public class ArbitraryPolygon extends Polygon {


    protected List<Point> vertices;

    public ArbitraryPolygon() {
        this.vertices = new ArrayList();
    }

    public ArbitraryPolygon(List<Point> vertices) {
        this.vertices = vertices;
    }


    public void addPoint(Point point) {
        vertices.add(point);
    }


    public void addPoint(double x, double y) {
        vertices.add(new Point(x, y));
    }


    public void rotate(double degree) {
        for (Point point : vertices) {
            point.rotate(degree, getCenter());
        }
    }

    /**
     * *********************
     * @brief This method changes the scale of a polygon by multiplying the distance between its 
     * vertices and its center point by a specified scale factor. It updates the coordinates of each vertex of the 
     * polygon using the formula new coordinate = old coordinate + (old coordinate - center coordinate) * scale. 
     * The method uses the getCenter() method to get the center point of the polygon and updates the coordinates of each vertex 
     * by accessing them through the vertices instance variable of the polygon object.
     */
    @Override
    public void changeScale(double scale) {
        Point center = getCenter();
        for (Point point : vertices) {
            point.setX(point.getX() + (point.getX() - center.getX()) * scale);
            point.setY(point.getY() + (point.getY() - center.getY()) * scale);
        }
    }

    /**
     * *************************
     * @brief This code calculates the area of a polygon represented by a list of vertices using the Shoelace formula.
     *  It iterates over each pair of adjacent vertices, multiplies the x-coordinate of the first point with the 
     *  y-coordinate of the second point and subtracts the y-coordinate of the first point multiplied by the 
     *  x-coordinate of the second point. The final area is then divided by 2 and returned as the absolute value.
     */
    @Override
    public double getArea() {
        int n = vertices.size();
        double area = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            Point p1 = vertices.get(i);
            Point p2 = vertices.get(j);
            area += p1.getX() * p2.getY();
            area -= p1.getY() * p2.getX();
        }
        area /= 2;
        return Math.abs(area);
    }

    /**
     * @brief This code calculates the perimeter length of a polygon represented by a list of vertices. 
     * It iterates over each pair of adjacent vertices, calculates the Euclidean distance between them using the 
     * Pythagorean theorem and adds it to the total perimeter. The final perimeter length is then returned.
     * @return The perimeter length of the polygon.
     */
    @Override
    public double getPerimeterLength() {
        int n = vertices.size();
        double perimeter = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            Point p1 = vertices.get(i);
            Point p2 = vertices.get(j);
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            perimeter += Math.sqrt(dx * dx + dy * dy);
        }
        return perimeter;
    }
}