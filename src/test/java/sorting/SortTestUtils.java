package sorting;

import java.util.Random;

public class SortTestUtils {
    public static int[] randomArrayGenerator(int size) {
        int[] randomArray = new int[size];
        Random rnd = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rnd.nextInt();
        }

        return randomArray;
    }

    public static Boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }

        return true;
    }
}
