import java.util.ArrayList;

/**
 * The class implements the DistanceFunction interface.
 * Calculates the distance between two clusters according to the Average Link method.
 */
public class AverageLink implements DistanceFunction {

    @Override
    public double calculateDistance(Cluster cluster1, Cluster cluster2) {

        ArrayList<Point> points1     = cluster1.getPoints();
        ArrayList<Point> points2     = cluster2.getPoints();
        Point point1;
        Point point2;
        double           sumDistance = 0;
        double           averageDistance;
        double           currentDistance;
        //int              counter     = 0;

        //Go over all the points and calculate the average distance between them.
        for (int i = 0; i < points1.size(); i++) {

            point1 = points1.get(i);

            for (int j = 0 ; j < points2.size(); j++) {

                point2 = points2.get(j);

                //Calculate distance between two points.
                currentDistance = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2)
                        + Math.pow((point2.getY() - point1.getY()), 2));

                sumDistance += currentDistance;
                //counter++;
            }
        }

        //Calculate the average.
        averageDistance = sumDistance / (points1.size() + points2.size());

        return averageDistance;
    }
}
