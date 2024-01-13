package Jophesus;
import Parentheses.Queue;

public class JophesusProblem {
    public static void main(String[] args) throws Exception{
        if (args.length > 2){throw new Exception("too many arguments : usage : java JophesusProblem M N");}
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < Integer.parseInt(args[1]); i++){
            q.enqueue(i);
        }
        while (!q.isEmpty()){
            for (int i = 0 ; i < Integer.parseInt(args[0])-1; i++){
                q.enqueue(q.dequeue());
            }
            System.out.println(q.dequeue());
        }
    }
}
