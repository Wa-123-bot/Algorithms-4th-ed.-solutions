package ch_1_3;
import java.util.NoSuchElementException;

public class exer_7
{
    public static void main(String[] args)
    {
        var stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek value: " + stack.peek());
        System.out.println("Pop item: " + stack.pop());
        System.out.println("Peek value: " + stack.peek());
    }

}

class Stack<Item> // based on linked- list structure
{
    private class Node
    {
        Item item;
        Node next;
    }

    private Node first;
    private int N; // number of items

    public boolean is_empty() { return first == null; }
    public int size() { return N; }

    // adding items to the beginning of the list. If you add items at the end of the list
    // then, you will lost reference to the previous nodes, since each node
    // only have reference to the next node.
    // therefore, you can't pop the item of the nodes, except for the last node
    public void push(Item item)
    {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        N++;

    }
    // remove node at the beginning of the list
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

     public Item peek()
     {
         if(is_empty()) { throw new NoSuchElementException("Stack underflow"); }
         return first.item;

     }



}
