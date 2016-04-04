package testalg;

/**
 * Created by matt on 14.03.2016.
 */
public class Queue {
    private int maxSize;
    private long[] arr;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        arr = new long[s];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long item) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        arr[++rear] = item;
        nItems++;
    }

    public long remove()
    {
        long temp = arr[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront()
    {
        return  arr[front];
    }

    public boolean isEmpty()
    {
        return nItems == 0;
    }

    public boolean isFull()
    {
        return nItems == maxSize;
    }

    public int size()
    {
        return nItems;
    }
}