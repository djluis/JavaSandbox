package sorting;

import djluis.sandbox.sorting.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static sorting.SortTestUtils.isArraySorted;
import static sorting.SortTestUtils.randomArrayGenerator;


public class SortingTests {

    private static final int RANDOM_ARRAY_SIZE = 100000;

    private static int[] BASE_RANDOM_ARRAY;

    @BeforeAll
    public static void prepareArray() {
        // We need the base array to be equal for all sort algorithms to be fair
        BASE_RANDOM_ARRAY = randomArrayGenerator(RANDOM_ARRAY_SIZE);
    }

    @DisplayName("Test with @MethodSource")
    @ParameterizedTest(name = "{0}")
    @MethodSource("sortAlgorithms")
    public void testSortingAlgorithm(SortAlgorithm sortAlgorithm) {
        int[] intArray = new int[BASE_RANDOM_ARRAY.length];
        System.arraycopy(BASE_RANDOM_ARRAY, 0, intArray, 0, intArray.length);
        sortAlgorithm.sort(intArray);
        Assertions.assertTrue(isArraySorted(intArray));
    }

    @Test
    public void testSortingAlgorithmWithSortedArray() {
        int[] intArray = new int[BASE_RANDOM_ARRAY.length];
        System.arraycopy(BASE_RANDOM_ARRAY, 0, intArray, 0, intArray.length);
        Arrays.sort(intArray);

        // Quicksort with sorted array is O(n^2), that means a huge number of recursion calls
        QuickSort quickSort = new QuickSort();

        assertThrows(StackOverflowError.class, () ->
                quickSort.sort(intArray)
        );
    }

    static Stream<SortAlgorithm> sortAlgorithms() {
        return Stream.of(
                new HeapSort(),
                new MergeSort(),
                new QuickSort(),
                new QuickSortRndPivotIterative(),
                new BubbleSort(),
                new InternalJavaArraySort()
        );
    }

}
