package djluis.sandbox.sorting;

import java.util.Arrays;

public class InternalJavaArraySort implements SortAlgorithm{
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
