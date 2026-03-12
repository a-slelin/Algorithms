package a.slelin.work.algorithms.sort.test.insertion;

import a.slelin.work.algorithms.sort.DemoUtil;
import a.slelin.work.algorithms.sort.insertion.InsertionSort;
import a.slelin.work.algorithms.sort.test.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Тестируем сортировку вставками")
public class InsertionSortTest {

    @Test
    @DisplayName("Тест c reverse=false")
    public void insertionSortTest() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        InsertionSort.sort(A);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.SortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=true")
    public void insertionSortTestWithReserve() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        InsertionSort.sort(A, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.reverseSortedArray, A);
    }
}
