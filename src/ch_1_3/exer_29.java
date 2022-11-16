package ch_1_3;

import java.util.Iterator;

public class exer_29<T> implements Iterable<T>
{
    private class Node
    {
        T item;
        Node next;
    }

    private int N = 0;
    private Node last;

    public boolean is_empty(){ return N == 0; }
    public int size(){ return N; }
    public void enqueue(T item)
    {
        if(N == 0)
        {
            last = new Node();
            last.item = item;
            last.next = last;
            N++;
        }
        else
        {
            Node node = new Node();
            node.item = item;
            node.next = last.next; // According to line 24, last.next is last, which is the first node in the list
            last.next = node; //update last.next to the next node in the list
            last = node;

            N++;

        }
    }

    public T dequeue()
    {
        T item = last.next.item;
        last.next = last.next.next;
        N--;
        if (is_empty()) { last = null; } // if the circular linked list is empty
        return item;
    }


    public void loop(int times)
    {
        if (N > 0 )
        {
            Node current = last.next;
            for ( int i = 0; i < times; i++)
            {
                System.out.print( current.item + " ");
                current = current.next;
            }
            System.out.println();
        }
        else
        {
            System.out.println("Empty list");
        }



    }

    public Iterator<T> iterator(){ return new list_iterator(); }

    public class list_iterator implements Iterator<T>
    {
        Node current = last;
        public T next() { T item = current.item; current = current.next; return item; }
        public boolean hasNext() { return current != null; }
    }

    public static void main(String[] args)
    {
        var list = new exer_29<String>();

        list.enqueue("H");
        list.enqueue("e");
        list.dequeue();
        list.enqueue("y");


        list.loop(5);




    }

}
