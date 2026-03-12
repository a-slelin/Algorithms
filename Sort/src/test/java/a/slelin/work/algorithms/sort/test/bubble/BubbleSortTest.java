package a.slelin.work.algorithms.sort.test.bubble;

import a.slelin.work.algorithms.sort.DemoUtil;
import a.slelin.work.algorithms.sort.bubble.BubbleSort;
import a.slelin.work.algorithms.sort.test.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестируем сортировку пузырьком")
public class BubbleSortTest {

    @Test
    @DisplayName("Тест c reverse=false")
    public void bubbleSortTest() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        BubbleSort.sort(A);

        assertNotNull(A);
        assertEquals(n, A.length);
        assertArrayEquals(TestUtil.SortedArray, A);
    }

    @Test
    @DisplayName("Тест c reverse=true")
    public void bubbleSortTestWithReserve() {
        int[] A = DemoUtil.Array;
        int n = A.length;

        BubbleSort.sort(A, true);

        assertNotNull(A);
        assertEquals(n, A.length);
        System.out.println(Arrays.toString(A));
        assertArrayEquals(TestUtil.reverseSortedArray, A);
    }
}
