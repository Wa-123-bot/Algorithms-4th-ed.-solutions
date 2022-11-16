package ch_1_3;

public class exer_1
{
    public static void main(String[] args) // test if isFull() works right.
    {
        FixedCapacityStack<String> full;
        FixedCapacityStack<Integer> not_full;

        full = new FixedCapacityStack<String>(2);
        full.push("Hello");
        full.push("World");
        if (full.isFull()) { System.out.println("Correct."); }
        else {  System.out.println("Incorrect. The string is supposed to be detected as fulled"); }

        not_full = new FixedCapacityStack<Integer>(2);
        not_full.push(32);
        if (!not_full.isFull()) { System.out.println("Correct."); }
        else { System.out.println("Incorrect. It is supposed to be detected as not fulled"); }


    }
}

class FixedCapacityStack<Item>
{
    private Item[] a;
    private int N;

    @SuppressWarnings("unchecked") // Ignore the Object casting warning
    public FixedCapacityStack(int size)
    { a = (Item[]) new Object[size]; }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    public void push( Item item) { a[N++] = item; }

    public Item pop() { return a[--N]; }

    public boolean isFull() { return N == a.length; } // when the size of stack equals the size of the array
}
