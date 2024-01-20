package Sorting;

import java.util.ArrayList;

public class SelectionSort {
    /**
     * Sort the given entry
     * @param l Array of integers
     * @TimeComplexity O(N^2)
     * @MemoryComplexity O(N)
     */
    public static void SelectionSort(int[] l){
        for (int i = 0; i < l.length-1; i++){
            int indexMin = i;
            int minimum = l[i];
            for (int j = i+1; j < l.length; j++){
                int elt = l[j];
                if (elt < minimum){minimum = elt; indexMin = j;}
            }
            if (indexMin != i){
                int temp = l[i];
                l[i] = minimum;
                l[indexMin] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] l = {0,1,8,5,4,9};
        SelectionSort(l);
        System.out.println("Content of the vector : ");
        for (int i = 0; i < l.length-1; i++){
            System.out.print(l[i] + "->");
        }
        System.out.println(l[l.length-1]);
    }
}
