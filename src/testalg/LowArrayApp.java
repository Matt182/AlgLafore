package testalg;

public class LowArrayApp {
	public static void main(String[] args)
	{
		LowArray arr = new LowArray(10);
		arr.makeSA();
		System.out.println(arr.printArr());
        System.out.println(arr.find(9));
    }
}
