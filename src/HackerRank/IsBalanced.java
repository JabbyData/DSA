package HackerRank;
import java.util.ArrayDeque;
public class IsBalanced {
    public static String isBalanced(String s) {
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check symbols '(',')','{','}','[',']'
            if (c == '(' || c == '{' || c == '[') {stk.push(c);}
            else if (c == ')' && (stk.isEmpty() || stk.pop() != '(')) {return "NO";}
            else if (c == '}' && (stk.isEmpty() || stk.pop() != '{')) {return "NO";}
            else if (c == ']' && (stk.isEmpty() || stk.pop() != '[')) {return "NO";}
        }
        if (stk.isEmpty()) {
            return "YES";
        } else return "NO";
    }

    public static void main(String[] args){
        System.out.println(isBalanced("()"));
    }
}
