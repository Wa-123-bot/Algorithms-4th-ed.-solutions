package ch_2_1;

import edu.princeton.cs.algs4.*;

@SuppressWarnings("unckecked") // get rid of the uncheck warning for raw use of Comparable
public class exer_25
{
    public static void main(String[] ars)
    {
        SortComapre test = new SortComapre();
        test.compare();



    }
    // default insertion sort
    private static void sort( Comparable[] a)
    {
        int N = a.length;
        for ( int i = 1; i < N; i++)
        {
            for ( int j = i; j > 0 && less(a[j], a[j-1]); j--)
            {
                exch(a, j, j-1);
            }
        }
    }

    private static void without_exch( Comparable[] a)
    {
        int N = a.length;
        for ( int i = 1; i < N; i++)
        {
            Comparable current = a[i]; // storing the current measuring element in a variable
            int j;
            // this for loop keep comparing the measuring entry with the ones before it, if the entry is larger than "current"
            for (j = i; j > 0 && less(current, a[j-1]); j--)
            {
                a[j] = a[j - 1]; // copy the larger entry to the right one position
            }
            a[j] = current; // j is decreased by 1 after exit the for loop ( because of j--)

        }
    }

    private static boolean less(Comparable x, Comparable y)
    {
        return x.compareTo(y) < 0;
    }

    private static void exch( Comparable[] a, int x, int y)
    {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static class SortComapre
    {
        public static double time(String alg, Comparable[] a)
        {
            Stopwatch timer = new Stopwatch();
            if ( alg.equals("default")) sort(a);
            if ( alg.equals("advanced")) without_exch(a);

            return timer.elapsedTime();
        }
        // sort T random arrays of length N
        public static double time_random_input( String alg, int N, int T)
        {
            double total = 0.0;
            Comparable[] a = new Comparable[N];
            for ( int times = 0; times < T; times++)
            {
                // perform one experiment ( randomly generate and sort an array)
                for ( int i = 0; i < N; i++)
                {
                    a[i] = StdRandom.uniformInt(0, 500);
                }
                total += time(alg, a);
            }
            return total;
        }

        public static void compare()
        {
            int length = 1000;
            double default_time = time_random_input( "default", length, 100);
            double advanced_time = time_random_input( "advanced", length, 100);
            System.out.printf("For %d random integer arrays: ", length);
            System.out.println();
            System.out.printf("The default sort takes %f seconds", default_time);
            System.out.println();
            System.out.printf("The insertion sort without exchanges takes %f seconds", advanced_time);
            System.out.println();
            if (default_time < advanced_time)
            {
                System.out.printf("Default insertion sort takes %f seconds," +
                        " which is %f faster than the version without exch()", default_time, advanced_time/default_time);
            }
            else if (default_time > advanced_time)
            {
                System.out.printf("Advanced insertion sort takes %f seconds," +
                        " which is %f faster than the version that comes with exch()", advanced_time, default_time/advanced_time);
                System.out.println();
            }
            else
            {
                System.out.printf("The running time for both sorts with %d random integer arrays are relatively the same.", length);
                System.out.println();

            }

        }

    }

}
