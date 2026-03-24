package a.slelin.work.algorithms.dp.laba1;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Algorithm {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Result {

        private Long totalWeight;

        private List<String> words;

        public static Result unresolved() {
            return new Result(-1L, null);
        }

        public boolean isUnresolved() {
            return this.totalWeight == -1L && this.words == null;
        }

    }

    public static Result solve(String S, Map<String, Long> dictionary, Long L) {

        if (S == null || dictionary == null || L == null) {
            throw new IllegalArgumentException("Значения для решения алгоритма не должны быть null!");
        }

        int n = S.length();

        /*
         * Создаем базовый массив для записи максимального набора весов для слова длины i.
         * [a, b, a, b, c]
         * [0, -1, -1, -1, -1, -1]
         * В последней ячейке будет находиться ответ, причём если он -1, то значит невозможно
         * составить слово по словарю.
         * */
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;

        // Для хранения информации о разбиении
        int[] prevIndex = new int[n + 1];
        String[] usedWord = new String[n + 1];
        Arrays.fill(prevIndex, -1);

        // Для оптимизации создания подстрок используем char[]
        char[] chars = S.toCharArray();

        // Будем идти по каждой букве строки S и заполнять массив dp
        for (int i = 1; i <= n; i++) {

            // Будем перебирать подстроки, которые длины меньше, чем L, от текущей буквы.
            long start = Math.max(0, i - L);

            // Используем StringBuilder для эффективного создания подстрок
            StringBuilder sb = new StringBuilder();

            // Перебираем возможные начала слов от i-1 до start
            for (int j = i - 1; j >= start; j--) {

                // Вставляем символ в начало StringBuilder
                sb.insert(0, chars[j]);
                String candidate = sb.toString();

                /*
                 * Проверяем есть ли такая подстрока в словаре.
                 * Если нет, то пропускаем её, если же есть, то необходимо посчитать
                 * сумму веса этой подстроки с её уже оптимальным значением веса.
                 * Далее следует выбрать максимальную и запомнить её.
                 * [a, b, a, b]
                 * [1, 2, 3, ?]
                 * a:2,ba:2
                 * Для aba - так как такой строки нет, то пропускаем.
                 * Для ba - weight = 2 + 2 = 4
                 * Для a - weight = 3 + 2 = 5
                 * Значит максимальное на этом этапе 5
                 * [1, 2, 3, 5] и запоминаем строку "a".
                 * */
                Long weight = dictionary.get(candidate);
                if (weight != null && dp[j] != Long.MIN_VALUE) {
                    long newWeight = dp[j] + weight;

                    if (newWeight > dp[i]) {
                        dp[i] = newWeight;
                        prevIndex[i] = j;
                        usedWord[i] = candidate;
                    }
                }
            }
        }

        // Если последнее значение в массиве равно -1, то невозможно составить слово по словарю.
        if (dp[n] == Long.MIN_VALUE) {
            return Result.unresolved();
        }

        // Восстанавливаем разбиение
        List<String> words = new ArrayList<>();
        int current = n;

        while (current > 0) {
            words.add(usedWord[current]);
            current = prevIndex[current];
        }
        words = words.reversed();

        return new Result(dp[n], words);
    }
}
