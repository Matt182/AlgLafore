package Calculator;

import testalg.StackX;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by matt on 14.03.2016.
 */
public class InToPost {
    private StackX stack;
    private String input;
    private ArrayList<String> output2 = new ArrayList<>();
    private int outInd = 0;
    private boolean flag = false;

    public InToPost(String in)
    {
        input = in;
        int stackSize = in.length();
        stack = new StackX(stackSize);
    }

    public void doTrans()
    {
        for (int i = 0; i < input.length() ; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case 's':
                    Stack sstack = new Stack();
                    int j;
                    for (j = i +3; j < input.length(); j++) {
                        char tch = input.charAt(j);
                        switch (tch) {
                            case '(':
                                sstack.add(tch);
                                break;
                            case ')':
                                sstack.pop();
                                break;
                            default:
                                break;
                        }
                        if (sstack.empty()) {
                            break;
                        }
                    }
                    InToPost temp = new InToPost(input.substring(i+3, j+1));
                    temp.doTrans();
                    //System.out.println(temp.getResult() + "___func___");
                    CaclActions a = new CaclActions(temp.getResult());
                    int res = (int) Math.sin(Math.toRadians(a.doAction()));
                    if (!flag) {
                        output2.add(String.valueOf(res));
                        flag = true;
                    } else {
                        output2.set(outInd, output2.get(outInd) + res);
                    }
                    i += j-(i+3)+3;
                    //System.out.println(res + "___func___");
                    break;
                case 'c':
                    Stack cstack = new Stack();
                    int cj;
                    for (cj = i +3; cj < input.length(); cj++) {
                        char tch = input.charAt(cj);
                        switch (tch) {
                            case '(':
                                cstack.add(tch);
                                break;
                            case ')':
                                cstack.pop();
                                break;
                            default:
                                break;
                        }
                        if (cstack.empty()) {
                            break;
                        }
                    }
                    InToPost ctemp = new InToPost(input.substring(i+3, cj+1));
                    ctemp.doTrans();
                    //System.out.println(temp.getResult() + "___func___");
                    CaclActions ca = new CaclActions(ctemp.getResult());
                    int cres = (int) Math.cos(Math.toRadians(ca.doAction()));
                    if (!flag) {
                        output2.add(String.valueOf(cres));
                        flag = true;
                    } else {
                        output2.set(outInd, output2.get(outInd) + cres);
                    }
                    i += cj-(i+3)+3;
                    //System.out.println(res + "___func___");
                    break;
                case 'l':
                    Stack lstack = new Stack();
                    int lj;
                    for (lj = i +3; lj < input.length(); lj++) {
                        char tch = input.charAt(lj);
                        switch (tch) {
                            case '(':
                                lstack.add(tch);
                                break;
                            case ')':
                                lstack.pop();
                                break;
                            default:
                                break;
                        }
                        if (lstack.empty()) {
                            break;
                        }
                    }
                    InToPost ltemp = new InToPost(input.substring(i+3, lj+1));
                    ltemp.doTrans();
                    //System.out.println(temp.getResult() + "___func___");
                    CaclActions la = new CaclActions(ltemp.getResult());
                    int lres = (int) Math.log(la.doAction());
                    if (!flag) {
                        output2.add(String.valueOf(lres));
                        flag = true;
                    } else {
                        output2.set(outInd, output2.get(outInd) + lres);
                    }
                    i += lj-(i+3)+3;
                    //System.out.println(res + "___func___");
                    break;
                case '+':
                case '-':
                    gotOper(ch, 1);
                    outInd++;
                    flag = false;
                    break;
                case '*':
                case '/':
                case '^':
                    gotOper(ch, 2);
                    outInd++;
                    flag = false;
                    break;
                case '(':
                    stack.push(ch);
                    flag = false;
                    break;
                case ')':
                    gotParen(ch);
                    flag = false;
                    break;
                default:
                    if (!flag) {
                        output2.add(String.valueOf(ch));
                        flag = true;
                    } else {
                        output2.set(outInd, output2.get(outInd) + ch);
                    }
                    break;
            }
        }
        while (!stack.isEmpty()) {
            output2.add(String.valueOf(stack.pop()));
        }
    }

    public void gotOper(char opThis, int prec)
    {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec > prec2) {
                    stack.push(opTop);
                    break;
                } else {
                    output2.add(String.valueOf(opTop));
                    outInd++;
                }
            }
        }
        stack.push(opThis);
    }

    public void gotParen(char ch)
    {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output2.add(String.valueOf(chx));
                outInd++;
            }
        }
    }

    public ArrayList<String> getResult()
    {
        return output2;
    }
}
