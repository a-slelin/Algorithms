package a.slelin.work.algorithms.dp.laba2;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Algorithm {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Result {

        private Integer totalDistance;

        private List<Integer> towns;
    }

    public static Result solve(int[][] matrix) {

        if (matrix == null) {
            throw new IllegalArgumentException("Матрица должна быть задана.");
        }

        int n = matrix.length;

        // Убираем очевидные варианты - когда у нас 0 или 1 город
        if (n == 0 || n == 1) {
            return new Result(0, List.of(0));
        }

        // Скопируем данные в другой массив, чтобы не портить оригинал
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, dist[i], 0, n);
        }

        /* << n (* 2^n);
         * dp[mask][i] = минимальная стоимость пути, который посетил города,
         * указанные в маске mask, и закончился в городе i.
         * parent[mask][i] — предыдущий город, из которого мы пришли в
         * это состояние (нужно для восстановления маршрута).
         */
        int size = 1 << n;
        int[][] dp = new int[size][n];
        int[][] parent = new int[size][n];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        /* Заполняем начальное состояние (1 << 0):
         * Маска 00...01 и находимся в 0-ом городе.
         * Означает, что мы посетили только город 0 и стоим в нём.
         * Расстояние понятное дело ноль.
         * Предыдущего города нет.
         */
        dp[1][0] = 0;
        parent[1][0] = -1;

        // Цикл по всем маскам от 1 до 2^n -1
        for (int mask = 1; mask < size; mask++) {

            // Цикл по городам для каждой маски.
            for (int i = 0; i < n; i++) {

                /* Проверяем, есть ли город i в этой маске, т.е. мы его уже посетили.
                 * Это работает так: i-й город представим в двоичной системе так:
                 * 0-ой = 1 = 00...01
                 * 1-ый = 2 = 00...010
                 * 2-ой = 3 = 00...0100
                 * Для этого подходит операция 2^i или битовая операция сдвига 1 << i.
                 * А чтобы проверить есть ли в город в маске применим побитовую конъюнкцию.
                 * Например, mask = 0011, а проверяем i = 1 город:
                 * 1 город = 0010 в закодированном виде, далее конъюнкция:
                 * 0011
                 * 0010
                 * ----
                 * 0010 <> 0000 => значит мы посещали город.
                 * */
                if ((mask & (1 << i)) != 0 && dp[mask][i] < Integer.MAX_VALUE) {

                    /* Теперь, если мы посещали город i.
                     * Давай-те попробуем пойти в другой город j.
                     * Условие обратное: город j мы не посещали!
                     * */
                    for (int j = 0; j < n; j++) {
                        if ((mask & (1 << j)) == 0) {
                            int newMask = mask | (1 << j);
                            int newCost = dp[mask][i] + dist[i][j];
                            if (newCost < dp[newMask][j]) {
                                dp[newMask][j] = newCost;
                                parent[newMask][j] = i;
                            }
                        }
                    }
                }
            }
        }

        // Ищем минимальный путь для маски 11....111, где мы остановились неважно.
        int fullMask = size - 1;
        int best = Integer.MAX_VALUE;
        int bestLast = -1;
        for (int i = 1; i < n; i++) {
            if (dp[fullMask][i] < best) {
                best = dp[fullMask][i];
                bestLast = i;
            }
        }

        // Восстановление пути
        List<Integer> path = new ArrayList<>();
        if (bestLast != -1) {
            int curMask = fullMask;
            int curCity = bestLast;
            while (curMask != 1) {
                path.addFirst(curCity);
                int prev = parent[curMask][curCity];
                curMask ^= (1 << curCity);
                curCity = prev;
            }
            path.addFirst(0);
        }

        return new Result(best, path);
    }
}
