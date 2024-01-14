package HackerRank;
import java.util.ArrayList;
import java.util.List;

public class GameOfTwoStacks {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int indexA = 0;
        int indexB = 0;
        int maxCount = 0;
        int sum = 0;
        int removedItems = 0;

        //Start with max sum possible using a elts
        while(indexA <  a.size() && sum + a.get(indexA)  <= maxSum) {
            sum = sum + a.get(indexA);
            indexA++;
            removedItems++;
            maxCount++;
        }

        while(indexA >= 0) {

            // try to add to sum as much items from b as possible
            while(indexB <  b.size() && sum + b.get(indexB) <= maxSum) {
                sum = sum + b.get(indexB);
                indexB++;
                removedItems++;
                if(removedItems > maxCount) {
                    maxCount = removedItems;
                }
            }
            if(indexA == 0)
                break;
            indexA--;
            int preRemovedElement = a.get(indexA);
            sum = sum - preRemovedElement;
            removedItems--;
        }
        return maxCount;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);a.add(6);a.add(4);a.add(2);a.add(4);
        b.add(5);b.add(8);b.add(5);b.add(1);b.add(2);
        System.out.println(twoStacks(10,a,b));
    }
}
