package testalg;

/**
 * Created by matt on 14.03.2016.
 */
public class StackX {
    private char[] arr;
    private int length;
    private int top;
    private int maxSize;

    public StackX(int size)
    {
        arr = new char[size];
        length = 0;
        top = -1;
        maxSize = size;
    }

    public char getLast()
    {
        return top == -1 ? ' ' : arr[top];
    }

    public char pop()
    {
        if (!(top == -1)) {
            length--;
        }
        return top == -1 ? ' ' : arr[top--];
    }

    public void push(char item)
    {
        length++;
        arr[++top] = item;
    }

    public int getLength()
    {
        return length;
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == maxSize-1);
    }

    public void makeNSA()
    {
        if (length > 0){
            return;
        }
        for (int i = 0; i < maxSize; i++){
            arr[i] = (char) (Math.random() * 100);
            length++;
        }
    }

    public void makeSA()
    {
        if (length > 0){
            return;
        }
        for (int i = 0; i < maxSize; i++){
            arr[i] = (char)i;
            length++;
        }
    }
}
