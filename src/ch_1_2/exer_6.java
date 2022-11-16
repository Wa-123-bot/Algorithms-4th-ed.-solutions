package ch_1_2;

public class exer_6
{
    public static void main(String[] args)
    {
        // example: love velo
        String s = args[0];
        String t = args[1];

        if (s.length() != t.length() )
        {
            System.out.println("The given two strings are NOT circular shifts of one another");
            System.exit(0); // terminate JVM when if condition is satisfied.
        }

        int length = s.length();
        String first_letter = s.substring(0,1); // get the first letter in 1st string
        int first_letter_index = t.indexOf(first_letter, 0); // get the index of first_letter in 2nd string

        // concatenate the 2nd string backwards
        String backward = t.substring(first_letter_index, length) + t.substring(0, first_letter_index);
        System.out.println("backward-string t: " + backward);

        if (backward.compareTo(s) == 0)
        {
            System.out.println("The two given strings are circular shifts of one another.");
        }

        else
        {
            System.out.println("The two given strings are NOT circular shifts of one another.");
        }


    }
}
