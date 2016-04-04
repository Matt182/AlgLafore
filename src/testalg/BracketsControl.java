package testalg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by matt on 14.03.2016.
 */
public class BracketsControl {
    public static void main(String[] args) throws IOException {
        StackX stack = new StackX(10);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    System.out.println("Errors occured");
                    return;
                }
            }
        }
        System.out.println("brackets is right");
        System.out.println((int)Math.log(8));
        System.out.println((int)Math.sin(90));
    }
}
