package ch_1_2;

public class exer_7
{
    public static void main(String[] args)
    {
        String s = "teso";
        String answer = mystery(s);
        System.out.println(answer);
    }

    static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
}
