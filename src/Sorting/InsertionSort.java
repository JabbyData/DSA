package Sorting;

import java.util.ArrayList;

public class InsertionSort {
    /**
     * Sort the given entry using insertion sort
     * @param l ArrayList of int
     * @TimeComplexity O(N^2)
     * @MemoryComplewity 0(N)
     */
    public static void sort(ArrayList<Integer> l){
        for (int i = 1; i < l.size(); i++){
            int eltToInsert = l.get(i);
            int j = 0;
            while (j < i && l.get(j) <= eltToInsert ){j++;}
            if (j != i){
                l.add(j,l.remove(i));
            }
        }
    }

    public static void main(String[] args){
        ArrayList l = new ArrayList<>();
        l.add(2);l.add(8);l.add(6);l.add(3);l.add(9);
        sort(l);
        System.out.println("Content of the vector : ");
        for (int i = 0; i < l.size()-1; i++){
            System.out.print(l.get(i) + "->");
        }
        System.out.println(l.get(l.size()-1));
    }
}
