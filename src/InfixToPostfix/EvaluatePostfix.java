package InfixToPostfix;
import Parentheses.Stack;

public class EvaluatePostfix {
    public static void Evaluate(String s) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stk.push(stk.pop() * stk.pop());
            }
            else if (c == '+') {
                stk.push(stk.pop() + stk.pop());
            }
            else if (c == '-') {
                stk.push(stk.pop() - stk.pop());
            }
            else if (c == '/') {
                stk.push(stk.pop() / stk.pop());
            }
            else if (c != ' '){
                StringBuilder s1 = new StringBuilder();
                while (c != ' ' && i < s.length()){
                    s1.append(c);
                    i++;
                    c = s.charAt(i);
                }
                stk.push(Integer.parseInt(s1.toString())); }
        }
        System.out.println("resultat : " + stk.pop());
    }

    public static void main(String[] args){
        Evaluate("3 11 1 * + 2 +");
        }
    }
