package ch_1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class exer_4
{
    public static void main(String[] args)
    {
        Scanner object = new Scanner(System.in);

        String textStreamInput = object.nextLine();
        StdOut.println("The text stream is " + exer_4.isBalanced(textStreamInput));

    }

    private static boolean isBalanced(String input)
    {
        char[] parentheses = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : parentheses)
        {
            if (parenthesis == '(' || parenthesis == '[' || parenthesis == '{')
            {
                stack.push(parenthesis);
            }

            else
            {
                if (stack.isEmpty())
                {
                    return false;
                }

                char firstItem = stack.pop();

                if (parenthesis == ')' && firstItem != '(' || parenthesis == ']' && firstItem != '[' || parenthesis == '}' && firstItem != '{')
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}

