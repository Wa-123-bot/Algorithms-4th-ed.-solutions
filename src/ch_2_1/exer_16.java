package ch_2_1;

import java.util.Arrays;

public class exer_16
{
    public static void main(String[] args)
    {
        int[] a = { 7, 7, 6, 16, 16, 14, 19, 3, 4, 9, 10, 13, 8, 2, 17 };
        if (check(a)) System.out.println("Yes");
        System.out.println();
    }

    private static boolean check( int[] a)
    {
        int[] original = new int[a.length];
        int count = 0;
        for ( int x : a) original[count++] = x;
        Arrays.sort(a);
        int n = 0;
        while ( n < a.length)
        {
             for ( int i = 0; i < original.length; i++) // iterate every sorted element
             {
                 if( a[n] == original[i]) // if matched, remove the matched entry
                 {
                     int[] temp = new int[original.length-1];
                     for ( int c = 0, j = 0 ; c < original.length; c++)
                     {
                         if ( c == i)
                         {
                             continue;
                         }
                         temp[j++] = original[c];
                     }
                     original = temp;
                     for ( int x : original) System.out.print( x + " ");
                     System.out.println();
                     break;
                 }
             }
            n++;
        }
        return original.length == 0; // the size of original should be zero if the
                                     // sorted array is made of the same set of objects.
    }
}
