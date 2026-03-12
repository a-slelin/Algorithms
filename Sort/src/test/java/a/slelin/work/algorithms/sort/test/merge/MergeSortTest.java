package a.slelin.work.algorithms.sort.test.merge;

import a.slelin.work.algorithms.sort.DemoUtil;
import a.slelin.work.algorithms.sort.merge.MergeSort;
import a.slelin.work.algorithms.sort.test.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестируем сортировку слиянием")
public class MergeSortTest {

    @Test
    @DisplayName("Тест c reverse=false")
    public void mergeSortTest() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        MergeSort.sort(A);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.SortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=true")
    public void mergeSortTestWithReserve() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        MergeSort.sort(A, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.reverseSortedArray, A);
    }
}
