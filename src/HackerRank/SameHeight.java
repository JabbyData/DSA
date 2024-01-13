package HackerRank;
import java.util.ArrayDeque;
import java.util.List;

public class SameHeight {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        ArrayDeque<Integer> s1 = new ArrayDeque<Integer>(h1);
        ArrayDeque<Integer> s2 = new ArrayDeque<Integer>(h2);
        ArrayDeque<Integer> s3 = new ArrayDeque<Integer>(h3);

        int h1Size = s1.stream().mapToInt(Integer::valueOf).sum();
        int h2Size = s2.stream().mapToInt(Integer::valueOf).sum();
        int h3Size = s3.stream().mapToInt(Integer::valueOf).sum();

        while(true){
            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()){
                return 0;
            }

            if (h1Size == h2Size && h2Size == h3Size){
                return h1Size;
            }

            if (h1Size > h2Size || h1Size > h3Size){
                h1Size -= s1.pop();
            }
            else if (h2Size > h1Size || h2Size > h3Size){
                h2Size -= s2.pop();
            }
            else if (h3Size > h2Size || h3Size > h1Size){
                h3Size -= s3.pop();
            }
        }
    }
}
