package a.slelin.work.algorithms.sort.test.heap;

import a.slelin.work.algorithms.sort.DemoUtil;
import a.slelin.work.algorithms.sort.heap.HeapSort;
import a.slelin.work.algorithms.sort.test.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Тестируем пирамидальную сортировку")
public class HeapSortTest {

    @Test
    @DisplayName("Тест c reverse=false")
    public void heapSortTest() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        HeapSort.sort(A);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.SortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=true")
    public void heapSortTestWithReserve() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        HeapSort.sort(A, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.reverseSortedArray, A);
    }
}
