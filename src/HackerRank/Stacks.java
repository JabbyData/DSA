package HackerRank;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Stacks {
    public static List<Integer> getMax(List<String> operations) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stk = new ArrayDeque<>();
        for (String op : operations) {
            char c = op.charAt(0);
            if (c == '1'){
                int x = Integer.parseInt(op.substring(2,op.length()));
                stk.push(x);
            }
            else if(c == '2'){stk.pop();}
            else if(c == '3'){
                // look for the max
                int max = 0;
                for (int i : stk){
                    if (i > max){
                        max = i;
                    }
                }
                res.add(max);
            }
        }
        return res;
    }
}
