import java.util.ArrayList;

/**
 * The class represents a cluster object.
 * Contains the list of points which are held inside of it, and the its id.
 */
public class Cluster{

    private ArrayList<Point> points;
    private int clusterId;

    /**
     * Constructor.
     * @param point points
     * @param clusterId cluster id
     */
    public Cluster(Point point, int clusterId){

        this.points = new ArrayList<>();
        this.points.add(point);
        this.clusterId = clusterId;
    }

    /**
     * Points list getter
     * @return points list
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Cluster id getter.
     * @return cluster id
     */
    public int getClusterId() {
        return clusterId;
    }

    /**
     * Cluster id setter.
     * @param clusterId cluster id
     */
    public void setClusterId(int clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * Points list setter.
     * @param points points list
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}




