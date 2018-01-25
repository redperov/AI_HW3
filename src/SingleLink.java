import java.util.ArrayList;

/**
 * Created by Danny on 23/01/2018.
 */
public class SingleLink implements DistanceFunction {

    @Override
    public double calculateDistance(Cluster cluster1, Cluster cluster2) {

        ArrayList<Point> points1 = cluster1.getPoints();
        ArrayList<Point> points2 = cluster2.getPoints();
        Point point1;
        Point point2;
        double shortestDistance = Double.MAX_VALUE;
        double currentDistance;

        for (int i = 0; i < points1.size(); i++) {

            point1 = points1.get(i);

            for (int j = 0 ; j < points2.size(); j++) {

                point2 = points2.get(j);

                //Calculate distance between two points.
                currentDistance = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2)
                        + Math.pow((point2.getY() - point1.getY()), 2));

                shortestDistance = Math.min(shortestDistance, currentDistance);

            }
        }

        return shortestDistance;
    }
}
