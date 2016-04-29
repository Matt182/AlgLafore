package Calculator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by matt on 14.03.2016.
 */
public class CaclActions {
    private ArrayList<String> input;
    private Stack<Integer> stack;

    public CaclActions(ArrayList s)
    {
        input = s;
        stack = new Stack();
    }

    public int doAction()
    {
        int a, b;
        for (String i : input) {
            switch (i) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;
                case "^":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push((int) Math.pow(b, a));
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
    }
}
