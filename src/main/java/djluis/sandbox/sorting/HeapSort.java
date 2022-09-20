package djluis.sandbox.sorting;

import static djluis.sandbox.sorting.SortingUtils.swap;

public class HeapSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {

        for (int idx = (array.length / 2) - 1; idx >= 0; idx--)
            heapify(array, array.length, idx);


        for (int idx = array.length - 1; idx > 0; idx--) {
            swap(array,0, idx);

            heapify(array, idx, 0);
        }
    }

    private void heapify(int[] array, int size, int rootIdx) {

        int biggestNodeIdx = rootIdx;
        int leftNode = 2 * rootIdx + 1;
        int rightNode = 2 * rootIdx + 2;

        if (leftNode < size && array[leftNode] > array[biggestNodeIdx])
            biggestNodeIdx = leftNode;

        if (rightNode < size && array[rightNode] > array[biggestNodeIdx])
            biggestNodeIdx = rightNode;

        if (biggestNodeIdx != rootIdx) {
            swap(array, rootIdx, biggestNodeIdx);

            heapify(array, size, biggestNodeIdx);
        }
    }
}
