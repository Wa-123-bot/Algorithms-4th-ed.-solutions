package ch_1_2;

public class exer_8
{
    public static void main(String[] args)
    {
        int[] a = {1,2,3};
        int[] t = a;
        t[0] = 10;
        System.out.println(a[0]);
        System.out.println(t[0]);
    }
}
