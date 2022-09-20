package djluis.sandbox.sorting;

import java.util.Random;
import static djluis.sandbox.sorting.SortingUtils.swap;

public class QuickSortRndPivotIterative extends AbstractQuickSort {

    private final Random rnd = new Random();

    @Override
    protected int pivotSelector(int[] array, int lower, int upper) {
        int randomPivotIdx = rnd.nextInt(upper - lower) + lower;
        swap(array, randomPivotIdx, upper);
        return array[upper];
    }

    @Override
    protected void sortLogic(int[] array, int lower, int upper) {
        int[] stack = new int[upper - lower + 1]; // Java Stack is for Object types

        int stackIdx = 0;

        stack[stackIdx++] = lower;
        stack[stackIdx++] = upper;

        while (stackIdx >= 2) {

            int stackUpper = stack[--stackIdx];
            int stackLower = stack[--stackIdx];

            int partitionIdx = partition(array, stackLower, stackUpper);

            if (partitionIdx - 1 > stackLower) {
                stack[stackIdx++] = stackLower;
                stack[stackIdx++] = partitionIdx - 1;
            }

            if (partitionIdx + 1 < stackUpper) {
                stack[stackIdx++] = partitionIdx + 1;
                stack[stackIdx++] = stackUpper;
            }
        }
    }
}
