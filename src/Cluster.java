import java.util.ArrayList;

/**
 * Created by Danny on 23/01/2018.
 */
public class Cluster{

    private ArrayList<Point> points;
    private int clusterId;

    public Cluster(Point point, int clusterId){

        this.points = new ArrayList<>();
        this.points.add(point);
        this.clusterId = clusterId;
    }

    public void addPoint(Point point){

        this.points.add(point);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public int getClusterId() {
        return clusterId;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}




