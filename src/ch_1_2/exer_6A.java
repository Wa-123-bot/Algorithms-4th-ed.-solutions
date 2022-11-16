package ch_1_2;

public class exer_6A {
    public static void main(String[] args) {
        // example: love velo
        String s = args[0];
        String t = args[1];

        if (is_circular_shift(s, t))
        {
            System.out.println("The two given strings are circular shifts of one another.");
        }

        else {
            System.out.println("The two given strings are NOT circular shifts of one another.");
        }


    }

    private static boolean is_circular_shift(String s, String t)
    {
        return s.length() == t.length() && (s+s).contains(t);
    }
}
