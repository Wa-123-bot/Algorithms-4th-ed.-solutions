package ch_1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Vector;

public class exer_1
{
    public static void main(String[] args)
    {
        //get the number of points from command-line argument
        int N = Integer.parseInt(args[0]);

        //construct an array of N Point2D objects
        Point2D[] points = new Point2D[N];

        //set the size of the dots in the canvas
        StdDraw.setPenRadius(.01);


        //generate N random points and stored them in an array
        for ( int i = 0; i < N; i++)
        {
            // uniformDouble() returns a random real number uniformly in [0, 1)
            double x = StdRandom.uniformDouble();
            double y = StdRandom.uniformDouble();

            StdDraw.point(x, y);
            points[i] = new Point2D(x, y);

        }

        // a vector to store all the distances
        Vector<Double> distances = new Vector<>(2);

        // compare the all the distances between two points to find the shortest distance

        //initialize the variable for shortest distance to be the maximum value
        double low = 1;

        //declare a variable to store the current distance
        double current;

        //go through each pair of points to make comparison

        // i = index of point (A); j =  index of point (B)
        // (the distance will be calculated between point A and B)
        // since point A can not be the last point, thus, i must be less than N - 1
        for (int i = 0; i < N - 1; i++)
        {
            // the index of point B must at least be one unit after point A,
            // thus, initialize j to be i + 1
            // the maximum index of point B is N - 1, thus, j must be less than N
            for (int j = i + 1; j < N; j++)
            {
                // calculate the distance between point A and B
                current = points[i].distanceTo(points[j]);

                // store every distance to check whether the output is correct.
                distances.add(current);

                // keep track of the shortest distance
                if (current < low)
                {
                    low = current;
                }
            }

        }

        System.out.printf("The shortest distance: %.5f", low);
        System.out.println();
        System.out.println("Manually check all the distances");
        for ( double distance : distances) System.out.println(distance);

    }
}
