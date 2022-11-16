package ch_1_3;

import ch_2_1.exer_19;

import java.util.Iterator;

public class exer_19_30<T> implements Iterable<T>
{
    private class Node
    {
        T item;
        Node next;
    }
    private Node current;
    private Node previous;
    private Node first;
    private int N = 0;
    public boolean is_empty(){ return N == 0; }
    public int size(){ return N; }
    public void add(T item)
    {
        if(is_empty())
        {
            current = new Node();
            current.item = item;
            first = current;
            N++;
        }
        // without this else if statement to include the inner code, the first two nodes will stores the same item.
        else if(!is_empty())
        {
            if(current != null)
            {
                previous = current;
            }
            current = new Node();
            current.item = item;
            previous.next = current;
            N++;
        }


    }

    public void remove()
    {
        if(!is_empty())
        {
            if(N == 1)
            {
                first = null;
                N--;

            }
            else
            {
                // T last = current.item;
                // previous.next = null;
                // current = previous;
                // N--;

                // The above code won't work because the list is not doubled linked, which means each code only have
                // the reference to the next code, they don't have access to the node before them.
                // the above code is trying to iterate the list backwards, expecting "previous" to store the reference
                // to the node before the current node, however, "current" can't not be updated to the previous node.
                // since each node itself don't have the reference to the node before it.
                // Here, "previous" only stores the node before the last node.
                // therefore, the first call of remove() does delete the very last node, but if keep calling remove()
                // nothing will deleted, that's because right now, during the second call of remove(),
                // both " current" and "previous" are the same node, "previous" is not updated to the node before it.

                // therefore, to make remove() works, we need to iterate the list forward and find the current last
                // node in the list and then remove it.

                //_________Second try

                // Node last = null;
                // for( Node i = first; i != null; i = i.next )
                // {
                    // last = i;
                // }

                // current = last;
                // current.next = null;
                // N--;

                // the above code doesn't work is b/c even though we iterate the list forward and track
                // the reference the current last node, "last" is always the same.
                // In the 1st call of remove(), "last" is "e", "current" is "e". The second and the following call of
                // remove() produces the same result.

                //________ third try

                Node previous = first;
                for ( int i = 0; i < N -2; i++)
                {
                    previous = previous.next;  // when for loop stops, previous is one node before the last node
                }

                previous.next = null; // the current last node
                current = previous; // update "current" so if add() is being called,
                                    // the correct reference stored in "current" will be used
                N--;

            }

        }

    }

    public void print()
    {
        for ( Node i = first; i != null; i = i.next)
        {
            System.out.print( i.item + " ");
        }
        System.out.println();
    }

    public void delete(int k) // k is 1 if I want to delete the first node.
    {
        if(k == 1)
        {
            first = first.next;
            N--;
        }
        else if ( k == N)
        {
            remove();
        }

        else
        {
            Node previous = first;
            for( int i = 0; i < k - 2;i++)
            {
                previous = previous.next;  // When for loop stops, previous is one node before the kth node
            }

            Node before = previous;
            Node after = previous.next.next;
            before.next = after;
            previous = null;
            N--;

        }

    }

    public boolean find( exer_19_30<T> list, String key)
    {
        Node first = list.first;
        for ( Node i = first; i != null; i = i.next)
        {
            if(i.item.equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public void remove_key_nodes( exer_19_30<T> list, String key)
    {
        Node previous = list.first; // track the previous node of the current node
        for ( Node current = list.first; current != null; current = current.next)
        {
            if( current == list.first && current.item.equals(key)) // if the first node matches key
            {
                current = current.next; // when current is being updated, list.first remains unchanged
                N--;
                list.first = current; // update list.first to the next node
            }

            if ( current.next != null && current.item.equals(key)) // if not the last node and matches key
            {
                previous.next = current.next;
                current = current.next;
                N--;
            }
            if (current.next == null && current.item.equals(key)) // if current is the last node
            {
                previous.next = null;
                N--;
                break;
            }
            previous = current;

        }


    }

    public int max(Node first)
    {
        if(is_empty())
        {
            return 0;
        }
        int max = (Integer)first.item;
        if ( first.next != null)
        {
            if (max < (Integer)first.next.item)
            {
                max = (Integer)first.next.item;
                first = first.next;
                return Math.max(max(first), max);
            }
            else // if max > first.next.item
            {
                first = first.next;
                return Math.max(max(first), max);
            }


        }
        return max;

    }

    private Node reverse(Node node) // exercise 30
    {
        Node First = node;
        Node reverse = null;
        while (First != null )
        {
            Node second = First.next;
            First.next = reverse;
            reverse = First;
            First = second;
        }

        return reverse;


    }

    public void test()  // exercise 30
    {
        first = reverse(first);
        print();


    }

    public Iterator<T> iterator() { return new iterate(); }

    private class iterate implements Iterator<T>
    {
        // no need to specify the generic type <T> because the inner class's type is the same as the outer class by default.
        Node current = exer_19_30.this.current;
        public boolean hasNext() { return current != null; }

        public T next()
        {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args)
    {
        var list = new exer_19_30<String>();
        list.add("h");
        list.add("o");
        list.add("u");
        list.add("s");
        list.add("e");

        // test the add()
        System.out.println("Original list: ");

        list.print();

        // test the remove() that is suppose to remove the last node in the list
        list.remove();
        list.remove();
        list.print();

        // test add() and remove() in intermixed sequence
        list.add("r");
        list.remove();
        list.add("r");
        list.add("s");
        list.print();

        //test delete()
        var list2 = new exer_19_30<String>();
        list2.add("g");
        list2.add("r");
        list2.add("e");
        list2.add("a");
        list2.add("t");
        list2.delete(3);
        list2.print();

        // test find()
        var list3 = new exer_19_30<String>();
        list3.add("b");
        list3.add("l");
        list3.add("u");
        list3.add("e");
        if(list3.find(list3, "u"))
        {
            System.out.println("Correct!");
        }

        // test remove_key_nodes()
        var list4 = new exer_19_30<String>();
        list4.add("b");
        list4.add("o");
        list4.add("s");
        list4.add("s");
        list4.remove_key_nodes(list4, "s");
        list4.print();

        var list5 = new exer_19_30<String>();
        list5.add("a");
        list5.add("r");
        list5.add("e");
        list5.add("a");
        list5.remove_key_nodes(list5, "a");
        list5.print();

        // test max() recursive
        var list6 = new exer_19_30<Integer>();
        list6.add(3);
        list6.add(1);
        list6.add(2);
        System.out.println(list6.max(list6.first));

        // test reverse() exercise 30
        var list7 = new exer_19_30<Integer>();
        list7.add(10);
        list7.add(11);
        list7.add(12);
        list7.test();






    }

}
