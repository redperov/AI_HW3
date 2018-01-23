/**
 * Created by Danny on 22/01/2018.
 */
public class Point {

    private int x;
    private int y;
    private Cluster owningCluster;
    private static int idCounter = 0;
    private int id = 0;

    public Point(int x, int y){

        idCounter++;
        this.id = idCounter;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
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
