package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.SimplePolygon;

/**
 * Rectangle class
 * @author Duygu
 * @see SimplePolygon
 */
public class Rectangle extends SimplePolygon {

    protected double height;


    protected double width;

    
    public Rectangle() {
        super();
        width = 0;
        height = 0;
    }

    /**
     * @brief multiply by the given scale to change the scale of the shape
     */
    @Override
    public void changeScale(double scale) {
        width *= scale;
        height *= scale;
    }

    /**
     * @brief to set the height of the rectangle
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @brief to set the width of the rectangle
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @brief multiply the height and width to find the area of the rectangle
     * @return height
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * @brief To find the perimeter of the rectangle, add the height and width and then multiply by 2
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * (width + height);
    }

    /**
     * @brief This code calculates the vertices of a rectangle with a specified width, height, and orientation, 
     * and returns them as an array of Point objects. It first finds the center of the rectangle using the getCenter() 
     * method and then calculates the four vertices based on the center, width, height, and orientation.
     * The final vertices are then returned as an array. The commented code represents an alternative way of 
     * calculating the vertices based on the width and height, without taking the orientation into account.
     * @return vertices
     */
    public Point[] getVertices() {
        Point[] vertices = new Point[4];
        Point center = getCenter();
        /*
        vertices[0] = new Point(center.getX() - width / 2, center.getY() - height / 2);
        vertices[1] = new Point(center.getX() + width / 2, center.getY() - height / 2);
        vertices[2] = new Point(center.getX() + width / 2, center.getY() + height / 2);
        vertices[3] = new Point(center.getX() - width / 2, center.getY() + height / 2);
         */

        vertices[0] = new Point(center.getX() - width / 2 * Math.cos(orientation) - height / 2 * Math.sin(orientation),
                center.getY() - width / 2 * Math.sin(orientation) + height / 2 * Math.cos(orientation));
        vertices[1] = new Point(center.getX() + width / 2 * Math.cos(orientation) - height / 2 * Math.sin(orientation),
                center.getY() + width / 2 * Math.sin(orientation) + height / 2 * Math.cos(orientation));
        vertices[2] = new Point(center.getX() + width / 2 * Math.cos(orientation) + height / 2 * Math.sin(orientation),
                center.getY() + width / 2 * Math.sin(orientation) - height / 2 * Math.cos(orientation));
        vertices[3] = new Point(center.getX() - width / 2 * Math.cos(orientation) + height / 2 * Math.sin(orientation),
                center.getY() - width / 2 * Math.sin(orientation) - height / 2 * Math.cos(orientation));
        return vertices;
    }

    
    /**
     * get the bounding rectangle of the rectangle
     * Returns the smallest rectangle that contains the rectangle
     * While the rectangle is not rotated, the bounding rectangle is the rectangle itself
     * When the rectangle is rotated, the bounding rectangle is the smallest rectangle that contains the rectangle
     * @return bounding rectangle
     */
    public Rectangle getBoundingRect() {
        Point[] vertices = getVertices();
        double minX = vertices[0].getX();
        double maxX = vertices[0].getX();
        double minY = vertices[0].getY();
        double maxY = vertices[0].getY();
        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i].getX() < minX) {
                minX = vertices[i].getX();
            }
            if (vertices[i].getX() > maxX) {
                maxX = vertices[i].getX();
            }
            if (vertices[i].getY() < minY) {
                minY = vertices[i].getY();
            }
            if (vertices[i].getY() > maxY) {
                maxY = vertices[i].getY();
            }
        }
        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(maxX - minX);
        boundingRect.setHeight(maxY - minY);
        return boundingRect;
    }
    


    /**
     * @brief get the width of the rectangle
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @brief get the height of the rectangle
     * @return height
     */
    public double getHeight() {
        return height;
    }
}
