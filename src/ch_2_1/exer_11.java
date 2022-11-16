package ch_2_1;

public class exer_11
{
    public static void main(String[] args)
    {
        int[] a = { 7, 7, 6, 16, 16, 14, 19, 3, 4, 9, 10, 13, 8, 2, 17 };
        int N = a.length;
        int h = 1;
        int num = 0; // count the number of gap
        while (h < N / 3) h = 3 * h + 1; // find the maximum gap (h) for the array
        int max = h;
        h = max;
        while (h > 0)
        {
            h = h/3;
            num++;
        }

        int[] increment_subsequence = new int[num];
        int Num = num-1;
        h = max;
        while (num > 0)
        {
            increment_subsequence[num-1] = h;
            h = h/3;
            num--;
        }

        while (Num > -1) // loop every h value in increment_subsequence
        {

            // h-sort the array
            for ( int i = increment_subsequence[Num]; i < N; i++) // loop through the last item of each individual subsequence
            {
                // insert a[i] (the last item of current subsequence) to its proper position in its subsequence
                for ( int current = i; current >= increment_subsequence[Num] && less(a[current], a[current-increment_subsequence[Num]]); current = current - increment_subsequence[Num])
                    exchange(a, current, current-increment_subsequence[Num]); // current - h is the index for the previous entry in the subsequence
            }
            Num--;
        }
        for ( int x : a){ System.out.print(x + " ");}
        System.out.println();

    }

    private static boolean less( int item, int previous)
    {
        return item < previous;
    }

    private static void exchange( int[] a, int index, int previous )
    {
        int temp = a[index];
        a[index] = a[previous];
        a[previous] = temp;
    }

}
