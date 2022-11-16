package ch_2_1;

import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class exer_19
{
    public static void main(String[] args)
    {
        // initial  permutation
        int[] array = new int[100];
        for ( int i = 1; i < 101; i++)
        {
            array[i-1] = i;
        }
        // find the worst case and the number of compares
        worst_input(array);
        test_reversed(); // compare counts for reversed array

    }

    private static void worst_input(int[] array)
    {
        int max_count = 0;
        int[] copy = new int[100];
        int[] worst_case = new int[100];
        for ( int i = 0; i < 10000; i++) // 10000 tests
        {
            int[] temp = generate(array);
            for (int j = 0; j < 100; j++){ copy[j] = temp[j];}
            Shell_sort operation = new Shell_sort();
            operation.shell_sort(temp);
            if (operation.compare() > max_count)
            {
                max_count = operation.compare();
                worst_case = copy;
            }
        }
        for ( int s : worst_case){ System.out.print(s + " ");}
        System.out.println();
        System.out.println(max_count);
        System.out.println();

    }
    private static int[] generate( int[] array)
    {
        StdRandom.shuffle(array);
        return array;
    }

    private static class Shell_sort // it's necessary to create a private class to hold the shell sort method
        // b/c the method must record the # of compares to sort the array, and this # count need to be returned
        // to the worst_input method. Therefore, having a class to encapsulate the two methods is very helpful
    {
        private int count = 0;
        private void shell_sort(int[] test)
        {
            int N = test.length;
            int h = 1;
            while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121...
            while ( h > 0)
            {
                for ( int i = h; i < N; i++) // starting from the largest h-value th element of the array
                {
                    // insert test[i] to its proper position among test[i-h], test[i-2*h]...
                    for ( int j = i; j >= h; j = j - h)
                    {
                        count++;
                        // if the ith element is less than i-h th element, swap the two, otherwise go check the next element
                        if (less( test[j], test[j-h])){ exchange( test, j, j-h); }
                        else{ break;}
                    }
                }
                // when reached the end of the array, update h value
                h = h/3;
            }
        }

        private int compare()
        {
            return count;
        }
    }
    public static void test_reversed()
    {
        int[] array2 = new int[100];
        for ( int i = 100; i > 0; i--)
        {
            array2[100-i] = i;
        }
        int[] copy = new int[100];
        for ( int i = 1; i < 101; i++ )
        {
            copy[i-1] = array2[i-1];
        }
        Shell_sort reversed = new Shell_sort();
        reversed.shell_sort(array2);
        for ( int s : copy){ System.out.print( s +" ");}
        System.out.println();
        System.out.println(reversed.compare());



    }

    private static boolean less( int current, int previous)
    {
        return current < previous;
    }

    private static void exchange(int[] array, int cur_index, int pre_index)
    {
        int temp = array[pre_index];
        array[pre_index] = array[cur_index];
        array[cur_index] = temp;
    }

}
