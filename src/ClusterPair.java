/**
 * The class represents a cluster pair.
 * Consists of two clusters and the distance value between them.
 */
public class ClusterPair {

    private Cluster first;
    private Cluster second;
    private double distance;

    /**
     * Constructor.
     */
    public ClusterPair() {

        this.first = null;
        this.second = null;
        this.distance = Double.MAX_VALUE;
    }

    /**
     * First cluster getter.
     * @return cluster
     */
    public Cluster getFirst() {
        return first;
    }

    /**
     * Second cluster getter.
     * @return cluster
     */
    public Cluster getSecond() {
        return second;
    }

    /**
     * Distance getter.
     * @return distance between the two cluster
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Pair setter.
     * @param first first cluster
     * @param second second cluster
     */
    public void setPair(Cluster first, Cluster second){

        if(first.getClusterId() <= second.getClusterId()){

            this.first = first;
            this.second = second;
        }
        else{

            this.first = second;
            this.second = first;
        }
    }

    /**
     * Distance setter.
     * @param distance distance between the two clusters
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
