package djluis.sandbox;

import djluis.sandbox.sorting.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting");

        int[] intArray = {3,2,5,1,0,7,6,8,9,4};
        QuickSort.Sort(intArray, 0, intArray.length -1);
        System.out.println(Arrays.toString(intArray));
        System.out.println("End");
    }
}