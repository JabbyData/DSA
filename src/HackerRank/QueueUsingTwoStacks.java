package HackerRank;
import java.util.ArrayDeque;
import java.io.*;
public class QueueUsingTwoStacks {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        // Read from stdIn
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // iterate through queries
        int nb_queries = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < nb_queries; i++){
            String query = br.readLine();
            if (query.charAt(0) == 1){
                // type 1
                stk.addLast(Integer.parseInt(query.substring(2,query.length())));
            }
            else if (query.charAt(0) == '2'){
                // type 2
                stk.pop();
            }
            else if (query.charAt(0) == '3'){
                // type 3
                System.out.println(stk.peek());
            }
        }
    }

}
