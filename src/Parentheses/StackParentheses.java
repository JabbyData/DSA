package Parentheses;
public class StackParentheses {
    private static final char LP = '(';
    private static final char RP = ')';
    private static final char LBK = '[';
    private static final char RBK = ']';
    private static final char LBC = '{';
    private static final char RBC = '}';

    public static boolean isBalanced(String s){
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++ ){
            if (s.charAt(i) == LP){stk.push(LP);}
            else if (s.charAt(i) == RP && (stk.isEmpty() || stk.pop() != LP)) {return false;}
            else if (s.charAt(i) == LBK){stk.push(LBK);}
            else if (s.charAt(i) == RBK && (stk.isEmpty() || stk.pop() != LBK)){return false;}
            else if (s.charAt(i) == LBC){stk.push(LBC);}
            else if (s.charAt(i) == RBC && (stk.isEmpty() || stk.pop() != LBC)) {return false;}
        }
        return stk.isEmpty();
    }
}
