package djluis.sandbox.sorting;

import static djluis.sandbox.sorting.SortingUtils.swap;

public abstract class AbstractQuickSort implements SortAlgorithm{

    protected abstract int pivotSelector(int[] array, int lower, int upper);

    // The implementation will choose between recursive or iterative
    protected abstract void sortLogic(int[] array, int lower, int upper);

    public void sort(int[] array) {
        sortLogic(array, 0, array.length - 1);
    }

    protected int partition(int[] array, int lower, int upper) {
        int pivot = pivotSelector(array,lower,upper);

        int idxOfSmallerElement = lower - 1;

        for (int idx = lower; idx <= upper - 1; idx++) {
            if (array[idx] < pivot) {
                idxOfSmallerElement++;
                swap(array, idxOfSmallerElement, idx);
            }
        }

        swap(array, idxOfSmallerElement + 1, upper);
        return idxOfSmallerElement + 1;
    }
}
