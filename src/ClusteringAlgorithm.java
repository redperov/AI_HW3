import java.util.ArrayList;

/**
 * The class contains the logic of the clustering algorithm.
 * Contains static methods which are used throughout the algorithm.
 */
public class ClusteringAlgorithm {

    /**
     * Private constructor.
     */
    private ClusteringAlgorithm() {

    }

    /**
     * Performs the requested clustering algorithm.
     * @param searchable Searchable object
     * @return list of representing to what cluster each point belongs
     */
    public static ArrayList<Integer> execute(Searchable searchable) {

        int                neededClusters   = searchable.getNeededClusters();
        ArrayList<Cluster> clusters         = new ArrayList<>(neededClusters);
        ArrayList<Point>   points           = searchable.getPoints();
        ArrayList<Integer> result;
        DistanceFunction   distanceFunction = searchable.getDistanceFunction();
        int                counter          = 0;

        //Create a cluster for each point.
        for (Point point : points) {

            counter++;
            Cluster newCluster = new Cluster(point, counter);
            clusters.add(newCluster);

        }

        //Union clusters until the requested amount of clusters.
        while (counter > neededClusters) {

            ClusterPair minimumPair = minimumDistance(clusters, distanceFunction);

            removeUnnecessaryCluster(minimumPair.getSecond().getClusterId(), clusters);

            combineClusters(minimumPair, clusters);

            reorderIds(clusters);

            counter--;
        }

        //Transform the clusters into a list of ids.
        result = clustersToInts(clusters, points);

        return result;

    }

    /**
     * Find the two clusters with the shortest distance according to the stated distance function.
     * @param clusters clusters list
     * @param distanceFunction distance function.
     * @return cluster pair
     */
    private static ClusterPair minimumDistance(ArrayList<Cluster> clusters, DistanceFunction distanceFunction) {

        ClusterPair clusterPair = new ClusterPair();
        double      currentValue;

        //Calculate the distances between all the clusters.
        for (int i = 0; i < clusters.size(); i++) {

            Cluster first = clusters.get(i);

            for (int j = i + 1; j < clusters.size(); j++) {

                Cluster second = clusters.get(j);

                //Calculate the distance according to the distance function.
                currentValue = distanceFunction.calculateDistance(first, second);

                //Check if current value is smaller than the previous value.
                if (currentValue < clusterPair.getDistance()) {

                    clusterPair.setDistance(currentValue);
                    clusterPair.setPair(first, second);
                }
            }
        }

        return clusterPair;
    }

    /**
     * Removes unnecessary clusters from the list.
     * @param clusterToRemoveId cluster id to remove
     * @param clusters clusters list
     */
    private static void removeUnnecessaryCluster(int clusterToRemoveId, ArrayList<Cluster> clusters) {

        for (int i = 0; i < clusters.size(); i++) {

            if (clusters.get(i).getClusterId() == clusterToRemoveId) {

                clusters.remove(i);
                break;
            }
        }
    }

    /**
     * Combine two clusters into one.
     * @param pair clusters pair
     * @param clusters clusters list
     */
    private static void combineClusters(ClusterPair pair, ArrayList<Cluster> clusters) {

        int              id         = pair.getFirst().getClusterId();
        ArrayList<Point> firstList  = pair.getFirst().getPoints();
        ArrayList<Point> secondList = pair.getSecond().getPoints();

        //Combine the two lists together.
        firstList.addAll(secondList);

        for (Cluster cluster : clusters) {

            if (cluster.getClusterId() == id) {

                cluster.setPoints(firstList);
            }
        }
    }

    /**
     * Transforms a clusters list into a list of their ids.
     * @param clusters clusters list
     * @param points points list
     * @return ids list
     */
    private static ArrayList<Integer> clustersToInts(ArrayList<Cluster> clusters, ArrayList<Point> points) {

        ArrayList<Integer> result = new ArrayList<>(points.size());
        int                clusterId;

        for (Point point : points) {

            clusterId = pointToClusterId(point, clusters);

            result.add((clusterId));
        }

        return result;
    }

    /**
     * Finds the cluster to which the given point belongs.
     * @param point point
     * @param clusters clusters list
     * @return cluster id
     */
    private static int pointToClusterId(Point point, ArrayList<Cluster> clusters) {

        ArrayList<Point> points;

        for (Cluster cluster : clusters) {

            points = cluster.getPoints();

            for (Point pointToCompare : points) {

                if (point.equals(pointToCompare)) {

                    return cluster.getClusterId();
                }
            }
        }

        return -1;
    }

    private static void reorderIds(ArrayList<Cluster> clusters){

        for(int i = 0; i < clusters.size(); i++){

            clusters.get(i).setClusterId(i + 1);
        }
    }
}
