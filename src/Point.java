/**
 * Created by Danny on 22/01/2018.
 */
public class Point {

    private double x;
    private double y;
    private Cluster owningCluster;
    private static int idCounter = 0;
    private int id = 0;

    public Point(double x, double y){

        idCounter++;
        this.id = idCounter;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setOwningCluster(Cluster owningCluster) {
        this.owningCluster = owningCluster;
    }

    @Override
    public boolean equals(Object obj) {

        Point otherPoint = (Point) obj;

        return (this.getX() == otherPoint.getX()) && (this.getY() == otherPoint.getY());
    }
}
