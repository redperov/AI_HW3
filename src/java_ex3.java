import jdk.nashorn.internal.runtime.ListAdapter;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Danny on 22/01/2018.
 */
public class java_ex3 {

    public static void main(String args[]) {

        //Input file path.
        final String inputFilePath = "input.txt";

        //Output file path.
        final String outputFilePath = "output.txt";

        //Read the data from the input a searchable object.
        Searchable searchable = readInput(inputFilePath);

        //Get the winning player in the game.
        ArrayList<Integer> solution = ClusteringAlgorithm.execute(searchable);

        //Write the solution to the output file.
        writeOutput(outputFilePath, solution);
    }


    public static Searchable readInput(String filePath) {

        Searchable searchable = null;
        ArrayList<Point> points = new ArrayList<>();

        //Read data from input file.
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String[] rawPoints;
            String         rowRead;
            String algorithmType;
            Point newPoint;
            int neededClusters;
            int x;
            int y;

            //Read algorithm type.
            algorithmType = bufferedReader.readLine();

            //Read number of needed clusters.
            neededClusters = Integer.parseInt(rowRead = bufferedReader.readLine());

            //Read points into a list.
           while((rowRead = bufferedReader.readLine()) != null){

               rawPoints = rowRead.split(",");
               x = Integer.parseInt(rawPoints[0]);
               y = Integer.parseInt(rawPoints[1]);

               newPoint = new Point(x, y);
               points.add(newPoint);
           }

            bufferedReader.close();

           searchable = new Searchable(algorithmType, neededClusters, points);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: file reading error.");
            e.printStackTrace();
        }

        return searchable;
    }

    /**
     * Writes the solution to the output file.
     *
     * @param filePath output file path
     * @param solution solution
     */
    public static void writeOutput(String filePath, ArrayList<Integer> solution) {

        //Write solution to output file.
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath), "utf-8"))) {

            //Write all the values to the file.
            for (int i = 0; i < solution.size(); i++) {

                writer.write( Integer.toString(solution.get(i)));

                if(i != solution.size() - 1){

                    //writer.write(System.getProperty( "line.separator" ));
                    writer.newLine();
                }
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error: writing to file error.");
            e.printStackTrace();
        }
    }
}

