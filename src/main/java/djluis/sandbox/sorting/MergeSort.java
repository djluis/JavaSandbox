package djluis.sandbox.sorting;

public class MergeSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        Sort(array, 0, array.length - 1);
    }

    private void Sort(int[] array, int lower, int upper) {
        if (lower >= upper)
            return;

        int middleIndex = (lower + upper) / 2;

        Sort(array, lower, middleIndex);
        Sort(array, middleIndex + 1, upper);
        merge(array, lower, middleIndex, upper);
    }

    private void merge(int[] array, int lower, int midleIndex, int upper) {
        int[] copyLowerArray = new int[midleIndex - lower + 1];
        int[] copyUpperArray = new int[upper - midleIndex];

        System.arraycopy(array, lower, copyLowerArray, 0, copyLowerArray.length);
        System.arraycopy(array, midleIndex + 1, copyUpperArray, 0, copyUpperArray.length);

        int mergedArrayIdx = lower;
        int lowerIdx = 0;
        int upperIdx = 0;

        while (lowerIdx < copyLowerArray.length && upperIdx < copyUpperArray.length) {
            if (copyLowerArray[lowerIdx] <= copyUpperArray[upperIdx]) {
                array[mergedArrayIdx] = copyLowerArray[lowerIdx];
                lowerIdx++;
            } else {
                array[mergedArrayIdx] = copyUpperArray[upperIdx];
                upperIdx++;
            }
            mergedArrayIdx++;
        }

        if (lowerIdx < copyLowerArray.length) {
            System.arraycopy(copyLowerArray, lowerIdx, array, mergedArrayIdx, copyLowerArray.length - lowerIdx);
        }

        if (upperIdx < copyUpperArray.length) {
            System.arraycopy(copyUpperArray, upperIdx, array, mergedArrayIdx, copyUpperArray.length - upperIdx);
        }
    }
}
