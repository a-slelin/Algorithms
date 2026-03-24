package a.slelin.work.algorithms.dp.laba1.test;

import a.slelin.work.algorithms.dp.laba1.Algorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Базовый тест из условий")
public class SimpleTest {

    public static final Map<String, Long> map = Map.of(
            "ab", 2L,
            "abc", 5L,
            "bc", 3L,
            "ca", 4L,
            "a", 1L,
            "b", 1L,
            "c", 1L
    );

    @Test
    @DisplayName("Тест со строкой \"abc\"")
    public void testAbc() {
        Algorithm.Result result = Algorithm.solve("abc", map, 3L);
        assertNotNull(result);
        assertNotNull(result.getTotalWeight());
        assertEquals(5L, result.getTotalWeight());
        assertNotNull(result.getWords());
        assertEquals(List.of("abc"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"ababc\"")
    public void testAbabc() {
        Algorithm.Result result = Algorithm.solve("ababc", map, 3L);
        assertNotNull(result);
        assertNotNull(result.getTotalWeight());
        assertEquals(7L, result.getTotalWeight());
        assertNotNull(result.getWords());
        assertEquals(List.of("a", "b", "abc"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"xyz\"")
    public void testXyz() {
        Algorithm.Result result = Algorithm.solve("xyz", map, 3L);
        assertNotNull(result);
        assertTrue(result.isUnresolved());
        assertNotNull(result.getTotalWeight());
        assertEquals(-1L, result.getTotalWeight());
        assertNull(result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"a\"")
    public void testSingleCharA() {
        Algorithm.Result result = Algorithm.solve("a", map, 3L);
        assertNotNull(result);
        assertEquals(1L, result.getTotalWeight());
        assertEquals(List.of("a"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"ab\"")
    public void testExactMatchAb() {
        Algorithm.Result result = Algorithm.solve("ab", map, 3L);
        assertNotNull(result);
        assertEquals(2L, result.getTotalWeight());
        assertEquals(List.of("a", "b"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"abcabc\"")
    public void testAbcabc() {
        Algorithm.Result result = Algorithm.solve("abcabc", map, 3L);
        assertNotNull(result);
        assertEquals(10L, result.getTotalWeight());
        assertEquals(List.of("abc", "abc"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"abca\" - поиск оптимального разбиения")
    public void testAbca() {
        Algorithm.Result result = Algorithm.solve("abca", map, 3L);
        assertNotNull(result);
        assertEquals(6L, result.getTotalWeight());
        assertEquals(List.of("abc", "a"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"cabc\"")
    public void testCabc() {
        Algorithm.Result result = Algorithm.solve("cabc", map, 3L);
        assertNotNull(result);
        assertEquals(7L, result.getTotalWeight());
        assertEquals(List.of("ca", "bc"), result.getWords());
    }

    @Test
    @DisplayName("Тест с максимальной длиной слова 2")
    public void testWithMaxWordLength2() {
        Algorithm.Result result = Algorithm.solve("abcabc", map, 2L);
        assertNotNull(result);
        assertEquals(9L, result.getTotalWeight());
        assertEquals(List.of("a", "b", "ca", "bc"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"ac\"")
    public void testAcNoDirectMatch() {
        Algorithm.Result result = Algorithm.solve("ac", map, 3L);
        assertNotNull(result);
        assertEquals(2L, result.getTotalWeight());
        assertEquals(List.of("a", "c"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"bac\"")
    public void testBac() {
        Algorithm.Result result = Algorithm.solve("bac", map, 3L);
        assertNotNull(result);
        assertEquals(3L, result.getTotalWeight());
        assertEquals(List.of("b", "a", "c"), result.getWords());
    }

    @Test
    @DisplayName("Тест с пустой строкой")
    public void testEmptyString() {
        Algorithm.Result result = Algorithm.solve("", map, 3L);
        assertNotNull(result);
        assertEquals(0L, result.getTotalWeight());
        assertTrue(result.getWords().isEmpty());
    }

    @Test
    @DisplayName("Тест со строкой, которую невозможно разбить")
    public void testImpossibleString() {
        Algorithm.Result result = Algorithm.solve("abcd", map, 3L);
        assertNotNull(result);
        assertTrue(result.isUnresolved());
        assertEquals(-1L, result.getTotalWeight());
        assertNull(result.getWords());
    }

    @Test
    @DisplayName("Тест с максимальной длиной слова 1")
    public void testWithMaxWordLength1() {
        Algorithm.Result result = Algorithm.solve("abc", map, 1L);
        assertNotNull(result);
        assertEquals(3L, result.getTotalWeight());
        assertEquals(List.of("a", "b", "c"), result.getWords());
    }

    @Test
    @DisplayName("Тест со строкой \"caab\"")
    public void testCaab() {
        Algorithm.Result result = Algorithm.solve("caab", map, 3L);
        assertNotNull(result);
        assertEquals(6L, result.getTotalWeight());
        assertEquals(6L, result.getTotalWeight());
    }

    @Test
    @DisplayName("Тест с очень большой максимальной длиной слова")
    public void testWithVeryLargeMaxLength() {
        Algorithm.Result result = Algorithm.solve("abc", map, 100L);
        assertNotNull(result);
        assertEquals(5L, result.getTotalWeight());
        assertEquals(List.of("abc"), result.getWords());
    }

    @Test
    @DisplayName("Тест с большой строкой")
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testRandomValidString() {
        Algorithm.Result result = Algorithm.solve("abc".repeat(3333) + "a", map, 3L);
        assertNotNull(result);
        assertEquals(16666L, result.getTotalWeight());
        assertNotNull(result.getWords());
        assertEquals(3334, result.getWords().size());
    }
}
