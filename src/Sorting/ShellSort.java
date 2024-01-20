package Sorting;

public class ShellSort {
    /**
     * Sort the given entry using Shell sort (sequences of h-sorted arrays)
     * @param l ArrayList of int
     * @TimeComplexity O(N^2) with N/(2^k) increments, O(N*log^2(N)) with 3-smooth numbers (Pratt demo, 2^p*3^q, Ex. 1,3,4,6,8,9,...)
     * @MemoryComplewity 0(N)
     */
    public static void sort(int[] l){
        int n = l.length;
        int gap = n / 2;
        while (gap > 0){
            int j = gap;
            while (j < n){
                int i = j-gap;
                while (i>=0){
                    if (l[i+gap] < l[i]){
                        int temp = l[i+gap];
                        l[i+gap] = l[i];
                        l[i] = temp;
                    }
                    i -= gap;
                }
                j++;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args){
        int[] l = {2,4,9,7,6,5,1,0};
        sort(l);
        for (int i = 0; i < l.length-1; i++){
            System.out.print(l[i] + "->");
        }
        System.out.println(l[l.length-1]);
    }
}
