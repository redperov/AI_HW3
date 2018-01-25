import java.util.ArrayList;

/**
 * The class represents a searchable object.
 * Consist of the necessary data to run the clustering algorithm.
 */
public class Searchable {

    private ArrayList<Point> points;
    private DistanceFunction distanceFunction;
    private int neededClusters;

    /**
     * Constructor.
     * @param algorithmType algorithm type
     * @param neededClusters number of needed clusters
     * @param points points list
     */
    public Searchable(String algorithmType, int neededClusters,ArrayList<Point> points){

        this.neededClusters = neededClusters;
        this.points = points;

        //Set the requested distance method.
        if(algorithmType.equals("single link")){
            distanceFunction = new SingleLink();
        }
        else if(algorithmType.equals("average link")){
            distanceFunction = new AverageLink();
        }
    }

    /**
     * Points list getter
     * @return points list
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Distance function getter.
     * @return
     */
    public DistanceFunction getDistanceFunction() {
        return distanceFunction;
    }

    /**
     * Number of needed clusters getter.
     * @return number of needed clusters
     */
    public int getNeededClusters() {
        return neededClusters;
    }
}
