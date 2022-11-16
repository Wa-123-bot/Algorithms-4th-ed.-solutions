package ch_1_3;

// exercise 14
public class ResizingArrayQueueOfStrings
{
    private int N = 0;
    private int first = 0; // keep track of the first value in the queue
    private int last = 0;
    private String[] queue;
    public ResizingArrayQueueOfStrings( int size)
    {
        queue = new String[size];
    }

    private void resize( int new_size)
    {
        String[] temp = new String[new_size];
        for ( int i = first; i < N; i++)
        {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    public void enqueue( String item)
    {
        if ( N == queue.length) { resize( N * 2); }
        queue[last++] = item;
        N++;
    }

    public String dequeue()
    {
        if (N == 0) { throw new RuntimeException("Queue underflow"); }
        if ( N > 0 && N ==  queue.length/4 ) { resize ( N / 2); }
        String item = queue[first];
        queue[first] = null; // avoid loitering
        first++;
        N--;
        return item;
    }

    public boolean is_empty() { return N == 0; }
    public int size() { return N; }

    public static void main(String[] args){
        var queue = new ResizingArrayQueueOfStrings(2);
        queue.enqueue("H");
        queue.enqueue("e");
        queue.enqueue("l");
        queue.enqueue("l");
        queue.enqueue("o");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());

    }




}





