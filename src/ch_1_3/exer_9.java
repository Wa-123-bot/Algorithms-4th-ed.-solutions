package ch_1_3;

import edu.princeton.cs.algs4.Stack;

public class exer_9
{
    public static void main(String[] args)
    {
        String string = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String[] input = string.split(" ");
        System.out.println(completed_expression(input));

    }

    private static String completed_expression(String[] input)
    {
        var numbers = new Stack<String>();
        var operators = new Stack<String>();

        for (String s : input)
        {
            if ( s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            {
                operators.push(s);
            }
            else if (s.equals(")"))
            {
                String second = numbers.pop();
                String first = numbers.pop();
                String operator = operators.pop();
                String expression = "(" + first + operator + second + ")"; // the expression is a number
                numbers.push(expression);

            }
            else
            {
                numbers.push(s);
            }
        }
        return numbers.pop();
    }

}
