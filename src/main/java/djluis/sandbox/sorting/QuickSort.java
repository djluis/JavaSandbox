package djluis.sandbox.sorting;

public class QuickSort extends AbstractQuickSort {
    @Override
    protected int pivotSelector(int[] array, int lower, int upper) {
        return array[upper];
    }

    @Override
    protected void sortLogic(int[] array, int lower, int upper) {
        if (lower < upper) {
            int partitionIdx = partition(array, lower, upper);

            sortLogic(array, lower, partitionIdx - 1);
            sortLogic(array, partitionIdx + 1, upper);
        }
    }
}
