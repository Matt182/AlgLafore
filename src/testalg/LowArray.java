package testalg;

public class LowArray {
	private long[] a;
	private int length;
	private int size;
	
	public LowArray(int size)
	{
		a = new long[size];
		length = 0;
		this.size = size;
	}
	
	public void makeNSA()
	{
		if (length > 0){
			return;
		}
		for (int i = 0; i < size; i++){
			a[i] = (long) (Math.random() * 100);
			length++;
		}
	}
	
	public void makeSA()
	{
		if (length > 0){
			return;
		}
		for (int i = 0; i < size; i++){
			a[i] = i;
			length++;
		}
	}
	
	public void insert(long value)
	{
		a[length] = value;
		length++;
	}
	
	public long getElem(int index)
	{
		return a[index];
	}
	
	public String printArr()
	{
		String str = "";
		for (int i = 0; i < length; i++){
			str += a[i] + " ";
		}
		return str;
	}
	
	public boolean find(long value)
	{
		int l = 0;
        int r = length-1;
        int current;

        while (l <= r) {
            current = (l+r)/2;
            if (a[current] == value) {
                return true;
            } else if (a[current] > value) {
                r = current - 1;
            } else {
                l = current + 1;
            }
        }
        return false;
	}
}
