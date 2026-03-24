package a.slelin.work.algorithms.dp.laba2;

import org.fusesource.jansi.Ansi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static final List<String> EXIT_KEY_WORDS = List.of(
            "\\exit", "\\quite", "\\stop", "\\end", "\\close",
            "\\выйти", "\\выход", "\\завершить", "\\стоп", "\\конец"
    );

    public static final List<String> YES_ANSWERS = List.of(
            "yes", "y", "да", "д"
    );

    public static final List<String> NO_ANSWERS = List.of(
            "no", "n", "нет", "н"
    );

    static void main() {

        String tmp;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                // Получаем число N (количество городов)
                boolean getN = false;
                int N = 0;
                while (!getN) {
                    System.out.print("Введите количество городов N (число, большее нуля): ");
                    tmp = br.readLine().trim();

                    if (isWantExit(tmp)) {
                        return;
                    }

                    if (tmp.isBlank()) {
                        error("введенная строка не должна быть пустой");
                        continue;
                    }

                    try {
                        N = Integer.parseInt(tmp);

                        if (N <= 0L) {
                            error("введенное значение N должно быть больше нуля");
                            continue;
                        }

                        if (N >= 16L) {
                            error("введенное значение N должно быть меньше, чем " + 16);
                            continue;
                        }

                    } catch (NumberFormatException ignore) {
                        error("невозможно преобразовать строку '%s' к числу".formatted(tmp));
                        continue;
                    }

                    getN = true;
                }

                // Считываем города
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; ++i) {
                    for (int j = i + 1; j < N; ++j) {

                        int distance = 0;

                        boolean getDistance = false;
                        while (!getDistance) {
                            System.out.printf("\tРасстояние от города " + Ansi.ansi().fgBlue().a(i + 1).reset()
                                    + " до города " + Ansi.ansi().fgBlue().a(j + 1).reset() + " (больше нуля): ");
                            tmp = br.readLine().trim();

                            if (isWantExit(tmp)) {
                                return;
                            }

                            if (tmp.isBlank()) {
                                error("расстояние не должно быть пустым");
                                continue;
                            }

                            try {
                                distance = Integer.parseInt(tmp);

                                if (distance <= 0) {
                                    error("расстояние должно быть больше нуля");
                                    continue;
                                }

                            } catch (NumberFormatException e) {
                                error("невозможно преобразовать расстояние '%s' к числу".formatted(tmp));
                                continue;
                            }

                            getDistance = true;
                        }

                        matrix[i][j] = distance;
                        matrix[j][i] = distance;
                    }
                }

                // Выводим на консоль итоговые введенные значения
                delimiter();
                System.out.println(Ansi.ansi().fgBlue().a("Итог:").reset());
                System.out.println(Ansi.ansi().fgBlue().a("\tГородов N = %d.".formatted(N)).reset());
                System.out.println(Ansi.ansi().fgBlue().a("\tМатрица городов:").reset());
                for (int i = 0; i < N; ++i) {
                    System.out.print("\t\t");
                    for (int j = 0; j < N; ++j) {
                        System.out.print(Ansi.ansi().fgBlue().a(matrix[i][j] + " ").reset());
                    }
                    System.out.println();
                }
                delimiter();

                // Запускаем алгоритм и также выводим результат его работы
                System.out.println("Запускаю алгоритм...");
                long start = System.nanoTime();
                Algorithm.Result result = Algorithm.solve(matrix);
                long end = System.nanoTime();

                System.out.println();
                System.out.println(Ansi.ansi().fgGreen().a("Минимальное расстояние ✅ : "
                        + result.getTotalDistance() + ".").reset());
                System.out.print(Ansi.ansi().fgGreen().a("Путь по городам \uD83C\uDFE2 : ").reset());
                List<Integer> towns = result.getTowns();
                for (int i = 0; i < N; ++i) {
                    if (i != N - 1) {
                        System.out.print(Ansi.ansi().fgGreen().a((towns.get(i) + 1) + " -> ").reset());
                    } else {
                        System.out.print(Ansi.ansi().fgGreen().a((towns.get(i) + 1) + ". \uD83C\uDF89").reset());
                    }
                }
                System.out.println();
                System.out.println(Ansi.ansi().fgGreen().a("Алгоритм отработал \uD83D\uDD50 за " + (end - start)
                        + " нс.").reset());
                delimiter();

                // После отработки алгоритма можно снова ввести новые данные или выйти
                boolean getAnswer = false;
                while (!getAnswer) {
                    System.out.print("Попробовать другой пример? (да, нет): ");
                    tmp = br.readLine().trim();

                    if (isWantExit(tmp)) {
                        return;
                    }

                    tmp = tmp.trim().toLowerCase();
                    if (YES_ANSWERS.contains(tmp)) {
                        delimiter();
                        getAnswer = true;
                    } else if (NO_ANSWERS.contains(tmp)) {
                        return;
                    } else {
                        error("не смог разобрать строку '%s'".formatted(tmp));
                    }
                }
            }
        } catch (Exception e) {
            error("неожиданная ошибка: " + e.getMessage());
        }
    }

    public static boolean isWantExit(String source) {
        return source != null && EXIT_KEY_WORDS.contains(source.toLowerCase());
    }

    public static void error(String message) {
        System.out.println(Ansi.ansi().fgRed().a("Ошибка: " + message + "!").reset());
    }

    public static void delimiter() {
        System.out.println(Ansi.ansi().fgYellow()
                .a("**********************************************************************").reset());
    }
}
