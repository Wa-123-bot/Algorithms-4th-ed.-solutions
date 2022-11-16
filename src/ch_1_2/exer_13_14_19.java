package ch_1_2;

import edu.princeton.cs.algs4.Date;
public class exer_13_14_19
{
    public static void main(String[] args)
    {
        var transaction_1 = new Transaction("Turing 5/22/1939 1034.32"); // 2nd constructor
        var transaction_2 = new Transaction("Anny    4/30/2012    302.43"); // 2nd constructor

        var date = new Date(7, 23, 2021);

        var transaction_3 = new Transaction("Tina", date, 2000.25); // 1st constructor

        // toStirng() test
        System.out.println(transaction_1); // automatically invoke the toString() in ch_1_2.Transaction

        // who() when() amount() test
        System.out.println(transaction_1.who() + transaction_1.when() + transaction_1.amount());
        System.out.println(transaction_2.who() + transaction_2.when() + transaction_2.amount());
        System.out.println(transaction_3.who() + transaction_3.when() + transaction_3.amount());

        // equals() test
        if(!transaction_1.equals(transaction_2)){ System.out.println("Not equal."); }

        if(transaction_1.equals(transaction_1)) { System.out.println("They are equal."); }

        var transaction_4 = new Transaction("Turing 5/22/1939 1034.32");
        if(transaction_1.equals(transaction_4)) { System.out.println("They are equal."); }

        // compareTo() test
        if(transaction_1.compareTo(transaction_4) == 0) { System.out.println("They have the same amount"); }

        if(transaction_1.compareTo(transaction_2) > 0) { System.out.println("Turing have greater amount that Anny"); }

        if(transaction_1.compareTo(transaction_3) < 0) { System.out.println("Turing have less amount that Tina"); }

        //hashCode()
        System.out.println( "The hash code of transaction 1:" + transaction_1.hashCode());
        System.out.println( "The hash code of transaction 2:" + transaction_2.hashCode());
        System.out.println( "The hash code of transaction 3:" + transaction_3.hashCode());
        System.out.println( "The hash code of transaction 4:" + transaction_4.hashCode());

    }
}

class Transaction implements Comparable<Transaction>
{
    private final String who;
    private final Date when; // the date class provided by algs4, not the date class in java standard library
    private final double amount;

    public Transaction (String who, Date when, double amount)
    {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    // exercise 19:parsing
    public Transaction(String s)
    {
        // splits the string into fragments when a sequence of one or more whitespace characters are detected
        String[] space_splits = s.split("\\s+");
        this.who = space_splits[0];
        this.when = new Date(space_splits[1]);
        this.amount = Double.parseDouble(space_splits[2]);

    }

    public String who(){ return who; }
    public Date when() { return when; }
    public double amount(){ return amount; }
    public String toString(){ return "Customer: " + who + "   Date: " + when + "   Amount: $ " + amount; }

    public boolean equals( Object that)
    {
        if (that == null) { return false; }
        if (that.getClass() != this.getClass()) { return false; }
        if (that == this) { return true; } // if that and this have the same value (reference)
        Transaction other = (Transaction) that;
        // return true if the three expression are true
        // keep in mind that non_primitive types uses equals() to make comparison with other variable of the same type
        return (this.who.equals(other.who)) && (this.when.equals(other.when)) && (this.amount == other.amount);
    }

    // compare the amounts of two objects
    public int compareTo(Transaction that)
    {
        return Double.compare(this.amount, that.amount);
    }

    // standard hashCode() implementation
    // if two or more objects are queal according to the equals method, their hashes should be equal too
    public int hashCode()
    {
        int hash = 1;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + when.hashCode();
        hash = 31 * hash + ((Double) amount).hashCode(); // Double object have its own hashCOde()
        return hash;
    }
}
