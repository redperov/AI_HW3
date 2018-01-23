import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Danny on 22/01/2018.
 */
public class ClusteringAlgorithm {

    /**
     * Private constructor.
     */
    private ClusteringAlgorithm() {

    }

    public static ArrayList<Integer> execute(Searchable searchable) {

        int                neededClusters   = searchable.getNeededClusters();
        ArrayList<Cluster> clusters         = new ArrayList<>(neededClusters);
        ArrayList<Point>   points           = searchable.getPoints();
        ArrayList<Integer> result;
        DistanceFunction   distanceFunction = searchable.getDistanceFunction();
        int                counter          = 1;

        for (Point point : points) {

            Cluster newCluster = new Cluster(point, counter);
            clusters.add(newCluster);
            counter++;
        }

        while (counter - 1 > neededClusters) {

            ClusterPair minimumPair = minimumDistance(clusters, distanceFunction);

            removeUnnecessaryCluster(minimumPair.getSecond().getClusterId(), clusters);

            combineClusters(minimumPair, clusters);

            counter--;
        }

        result = clustersToInts(clusters, points);

        return result;

    }

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

    private static void removeUnnecessaryCluster(int clusterToRemoveId, ArrayList<Cluster> clusters) {

        for (int i = 0; i < clusters.size(); i++) {

            if (clusters.get(i).getClusterId() == clusterToRemoveId) {

                clusters.remove(i);
                break;
            }
        }
    }

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

    private static ArrayList<Integer> clustersToInts(ArrayList<Cluster> clusters, ArrayList<Point> points) {

        ArrayList<Integer> result = new ArrayList<>(points.size());
        int                clusterId;

        for (Point point : points) {

            clusterId = pointToClusterId(point, clusters);

            result.add((clusterId));
        }

        return result;
    }

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
}
