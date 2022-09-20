package djluis.sandbox.sorting;

import static djluis.sandbox.sorting.SortingUtils.swap;

/***
 * Bubble Sort the bad boy :(
 */
public class BubbleSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int idx = 0; idx < array.length - 1; idx++) {
            for (int internalIdx = 0; internalIdx < array.length - idx - 1; internalIdx++) {
                if (array[internalIdx] > array[internalIdx + 1]) {
                    swap(array, internalIdx, internalIdx+1);
                }
            }
        }
    }
}
