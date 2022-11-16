package ch_1_3;

import edu.princeton.cs.algs4.Stack;
public class exer_12
{
    // Stack client
    public static void main(String[] args)
    {
        var stack = new Stack<String>();
        stack.push("Hello");
        stack.push(", world!");

        var copied = new Stack<String>();
        copied = copy(stack);
        for ( String s: stack ) { System.out.print( s + " "); }
        System.out.println();
        for ( String s: copied ) { System.out.print(s + " "); }
        System.out.println();

    }

    private static Stack<String> copy( Stack<String> stack)
    {
        var temp = new Stack<String>();
        var copied = new Stack<String>();
        for ( String s : stack){ temp.push(s); } // copy stack values to temp
        for ( String s: temp) { copied.push(s); } // reverse the temp values to keep the original order
        return copied;

    }

}
