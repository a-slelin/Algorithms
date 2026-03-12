package a.slelin.work.algorithms.sort.test.quick;

import a.slelin.work.algorithms.sort.DemoUtil;
import a.slelin.work.algorithms.sort.quick.QuickSort;
import a.slelin.work.algorithms.sort.test.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестируем быструю сортировку")
public class QuickSortTest {

    @Test
    @DisplayName("Тест c reverse=false, randomized=false")
    public void quickSortTest() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        QuickSort.sort(A);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.SortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=true, randomize=false")
    public void quickSortTestWithReserve() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        QuickSort.sort(A, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.reverseSortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=false, randomized=true")
    public void quickSortTestWithRandomized() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        QuickSort.sort(A, false, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.SortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=true, randomize=true")
    public void quickSortTestWithReserveAndRandomized() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        QuickSort.sort(A, true, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.reverseSortedArray, A);
    }
}
