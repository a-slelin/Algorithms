package a.slelin.work.algorithms.dp.laba2.test;

import a.slelin.work.algorithms.dp.laba2.Algorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Другие тесты для алгоритма")
public class OtherTest {

    @Test
    @DisplayName("Тест для 0 городов")
    public void test0Town() {
        Algorithm.Result result = Algorithm.solve(new int[][]{});
        assertNotNull(result);
        assertNotNull(result.getTotalDistance());
        assertEquals(0, result.getTotalDistance());
        assertNotNull(result.getTowns());
        assertEquals(List.of(0), result.getTowns());
    }

    @Test
    @DisplayName("Тест для 1 города")
    public void test1Town() {
        Algorithm.Result result = Algorithm.solve(new int[][]{{0}});
        assertNotNull(result);
        assertNotNull(result.getTotalDistance());
        assertEquals(0, result.getTotalDistance());
        assertNotNull(result.getTowns());
        assertEquals(List.of(0), result.getTowns());
    }

    @Test
    @DisplayName("Тест для 15 городов")
    public void test15Town() {
        /*
         * Матрица создаётся таким образом, что от i-го города к i + 1-му городу
         * расстояние равно 1, к i + 2-му городу - равно 2 и так далее. Получается
         * самый короткий путь просто идти по пути 0 -> 1 -> 2 ..., причём каждый
         * переход будет стоить единицу.
         * */
        int n = 15;
        int[][] matrix = new int[n][n];
        List<Integer> expectedPath = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            expectedPath.add(i);
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i == j ? 0 : Math.abs(i - j);
            }
        }

        Algorithm.Result result = Algorithm.solve(matrix);
        assertNotNull(result);
        assertNotNull(result.getTotalDistance());
        assertEquals(14, result.getTotalDistance());
        assertNotNull(result.getTowns());
        assertEquals(expectedPath, result.getTowns());
    }
}
