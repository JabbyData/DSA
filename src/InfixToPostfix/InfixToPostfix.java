package InfixToPostfix;
import Parentheses.Stack;
import Parentheses.StackParentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**** Strategy
 scan expression from right to left
 -> '(', push it to the stack
 -> if ')', pop stack until empty or '(' found, then discard both parentheses
 -> If other character, put it in the expression
 -> If operator, if precedence and associativity of the operator > those in  the stack, (or stack empty or just a '('), push it to the stack
 -> Else, pop until elt with less precedence or associativity
 Op : '+', '-', '/', '*' (left asso) and '^' (right asso) ****/

public class InfixToPostfix {
    public static int prec(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public static char assoc(char c) {
        if (c == '^') {
            return 'R';
        } else {
            return 'L';
        }
    }

    public static String toPostfix(String s) throws Exception {
        Stack<Character> stk = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                res.append(c);
            } else if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                while (!stk.isEmpty() && stk.take() != '(') {
                    res.append(stk.pop());
                }
            } else {
                while (!stk.isEmpty() && (prec(s.charAt(i)) < prec(stk.take()) ||
                        prec(s.charAt(i)) == prec(stk.take()) &&
                                assoc(s.charAt(i)) == 'L')) {
                    res.append(stk.pop());
                }
                stk.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }
        return res.toString();
    }

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter something: ");
        // Read a line of input from the user
        try {
            String userInput = reader.readLine();
            System.out.println("You entered: " + userInput + "\nResult : " + toPostfix(userInput));
        }catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
