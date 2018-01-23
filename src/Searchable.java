import java.util.ArrayList;

/**
 * Created by Danny on 22/01/2018.
 */
public class Searchable {

    private ArrayList<Point> points;
    private DistanceFunction distanceFunction;
    private int neededClusters;

    public Searchable(String algorithmType, int neededClusters,ArrayList<Point> points){

        this.neededClusters = neededClusters;
        this.points = points;

        if(algorithmType.equals("single link")){
            distanceFunction = new SingleLink();
        }
        else if(algorithmType.equals("average link")){
            distanceFunction = new AverageLink();
        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public DistanceFunction getDistanceFunction() {
        return distanceFunction;
    }

    public int getNeededClusters() {
        return neededClusters;
    }
}
