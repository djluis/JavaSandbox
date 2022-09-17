package sorting;

import djluis.sandbox.sorting.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static sorting.SortUtils.isArraySorted;
import static sorting.SortUtils.randomArrayGenerator;


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
        sortAlgorithm.Sort(intArray);
        Assertions.assertTrue(isArraySorted(intArray));
    }

    static Stream<SortAlgorithm> sortAlgorithms() {
        return Stream.of(
                new MergeSort(),
                new QuickSort(),
                new BubbleSort(),
                new HeapSort()
        );
    }

}
