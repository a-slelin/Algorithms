package a.slelin.work.algorithms.sort.test.counting;

import a.slelin.work.algorithms.sort.counting.CountingSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Тестируем сортировку подсчётом")
public class CountingSortTest {

    @Test
    @DisplayName("Тест c reverse=false")
    public void countingSortTest() {
        int[] A = {-2, 5, 3, 2, 2, 3, 5, 3, 3, 6, 0, -1};
        int n = A.length;

        int[] B = CountingSort.sort(A);

        assertNotNull(B);
        assertEquals(n, B.length);
        assertArrayEquals(new int[]{-2, -1, 0, 2, 2, 3, 3, 3, 3, 5, 5, 6}, B);
    }

    @Test
    @DisplayName("Тест c reverse=true")
    public void countingSortTestWithReserve() {
        int[] A = {-2, 5, 3, 2, 2, 3, 5, 3, 3, 6, 0, -1};
        int n = A.length;

        int[] B = CountingSort.sort(A, true);

        assertNotNull(B);
        assertEquals(n, B.length);
        assertArrayEquals(new int[]{6, 5, 5, 3, 3, 3, 3, 2, 2, 0, -1, -2}, B);
    }
}
