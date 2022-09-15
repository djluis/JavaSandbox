package djluis.sandbox.sorting;

public class QuickSort {

    public static void Sort(int[] array, int lower, int upper) {
        if (lower < upper) {

            int partitionIdx = partition(array, lower, upper);

            Sort(array, lower, partitionIdx - 1);
            Sort(array, partitionIdx + 1, upper);
        }
    }

    private static void swap(int[] array, int indexA, int indexB) {
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }

    private static int partition(int[] array, int lower, int upper) {
        int pivot = array[upper];

        int idxOfSmallerElement = lower - 1;

        for (int idx = lower; idx <= upper - 1; idx++) {
            if (array[idx] < pivot) {
                idxOfSmallerElement++;
                swap(array, idxOfSmallerElement, idx);
            }
        }

        swap(array, idxOfSmallerElement + 1, upper);
        return idxOfSmallerElement+1;
    }
}
