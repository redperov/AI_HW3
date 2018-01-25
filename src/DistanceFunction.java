/**
 * Interface for the distance function used in the clustering algorithm.
 * The main usage is to calculate the distance between two clusters.
 */
public interface DistanceFunction {

    /**
     * Calculates the distance between two clusters.
     * @param cluster1 first cluster
     * @param cluster2 second cluster
     * @return distance between clusters
     */
    double calculateDistance(Cluster cluster1, Cluster cluster2);
}
