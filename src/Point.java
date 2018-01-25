/**
 * The class represents a point object.
 * Consists of x and y coordinates.
 */
public class Point {

    private double x;
    private double y;
    private static int idCounter = 0;
    private int id = 0;

    /**
     * Constructor.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(double x, double y){

        idCounter++;
        this.id = idCounter;
        this.x = x;
        this.y = y;
    }

    /**
     * X coordinate getter
     * @return coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Y coordinate getter.
     * @return coordinate
     */
    public double getY() {
        return y;
    }

    @Override
    /**
     * Checks if two points are equal.
     */
    public boolean equals(Object obj) {

        Point otherPoint = (Point) obj;

        return (this.getX() == otherPoint.getX()) && (this.getY() == otherPoint.getY());
    }
}
