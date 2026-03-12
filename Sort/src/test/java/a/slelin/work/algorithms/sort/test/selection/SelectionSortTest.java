package a.slelin.work.algorithms.sort.test.selection;

import a.slelin.work.algorithms.sort.DemoUtil;
import a.slelin.work.algorithms.sort.selection.SelectionSort;
import a.slelin.work.algorithms.sort.test.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестируем сортировку выборкой")
public class SelectionSortTest {

    @Test
    @DisplayName("Тест c reverse=false")
    public void selectionSortTest() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        SelectionSort.sort(A);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.SortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=true")
    public void selectionSortTestWithReserve() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        SelectionSort.sort(A, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.reverseSortedArray, A);
    }
}
