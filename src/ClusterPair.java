/**
 * Created by Danny on 23/01/2018.
 */
public class ClusterPair {

    private Cluster first;
    private Cluster second;
    private double distance;

    public ClusterPair() {

        this.first = null;
        this.second = null;
        this.distance = Double.MAX_VALUE;
    }

    public Cluster getFirst() {
        return first;
    }

    public Cluster getSecond() {
        return second;
    }

    public double getDistance() {
        return distance;
    }

    public void setPair(Cluster first, Cluster second){

        if(first.getClusterId() < second.getClusterId()){

            this.first = first;
            this.second = second;
        }
        else{

            this.first = second;
            this.second = first;
        }
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
