package a.slelin.work.algorithms.ordinal.test;

import a.slelin.work.algorithms.ordinal.OrdinalStatics;
import a.slelin.work.algorithms.sort.DemoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Тестируем порядковые статики")
public class OrdinalTest {

    @Test
    @DisplayName("Тест для минимума")
    public void testMin() {
        int[] A = DemoUtil.Array;

        int min = OrdinalStatics.getMin(A);
        assertEquals(1, min);
    }

    @Test
    @DisplayName("Тест для максимума")
    public void testMax() {
        int[] A = DemoUtil.Array;

        int max = OrdinalStatics.getMax(A);
        assertEquals(16, max);
    }

    @Test
    @DisplayName("Тест для максимума и минимума вместе")
    public void testMinMax() {
        int[] A = DemoUtil.Array;

        int[] result = OrdinalStatics.getMinMax(A);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(16, result[1]);
    }

    @Test
    @DisplayName("Тест получения 4-ой статики")
    public void test4Statics() {
        int[] A = DemoUtil.Array;

        int statics = OrdinalStatics.getStatics(A, 4);
        assertEquals(7, statics);
    }
}
