package a.slelin.work.algorithms.dp.laba3;

import org.fusesource.jansi.Ansi;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

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

        System.out.println(Ansi.ansi().fgRgb(255, 122, 247).a("Марковские процессы с пуассоновским спросом.\n").reset());
        delimiter();

        while (true) {

            int C = readInt("Введите максимальную вместимость склада C (по умолчанию 5): ", 5, 1, 5);
            double price = readDouble("Введите цену продажи за единицу (по умолчанию 12): ", 12, 0, Double.MAX_VALUE);
            double cost = readDouble("Введите стоимость заказа за единицу (по умолчанию 6): ", 6, 0, Double.MAX_VALUE);
            double holding = readDouble("Введите штраф за хранение за единицу (по умолчанию 1): ", 1, 0, Double.MAX_VALUE);
            double shortage = readDouble("Введите штраф за дефицит за единицу (по умолчанию 0): ", 0, 0, Double.MAX_VALUE);
            double gamma = readDouble("Введите коэффициент дисконтирования γ (0 ≤ γ < 1, по умолчанию 0.9): ", 0.9, 0, 1);
            double lambda = readDouble("Введите параметр λ распределения Пуассона (по умолчанию 1.5): ", 1.5, 0.001, Double.MAX_VALUE);
            int startState = readInt("Введите начальный уровень запаса (0.." + C + ", по умолчанию " + (C / 2) + "): ", C / 2, 0, C);

            delimiter();
            System.out.println(Ansi.ansi().fgBlue().a("Итог:").reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tВместимость склада C = " + C).reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tЦена продажи price = " + price).reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tСтоимость заказа cost = " + cost).reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tШтраф за хранение holding = " + holding).reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tШтраф за дефицит shortage = " + shortage).reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tКоэффициент дисконтирования γ = " + gamma).reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tПараметр распределения Пуассона λ = " + gamma).reset());
            System.out.println(Ansi.ansi().fgBlue().a("\tНачальный уровень запаса startStage = " + gamma).reset());
            delimiter();

            System.out.println(Ansi.ansi().fgBlue().a("Считаем распределение спроса...").reset());
            MDP mdp = new MDP(C, price, cost, holding, shortage, gamma, lambda);

            double[] probs = mdp.getDemandProbs();
            int maxDemand = mdp.getMaxDemand();

            int colWidth = 10;
            for (int d = 0; d <= maxDemand; d++) {
                String probStr = String.format("%.6f", probs[d]);
                colWidth = Math.max(colWidth, probStr.length());
            }
            colWidth = Math.max(colWidth, "Вероятность".length());

            System.out.printf("%-12s", Ansi.ansi().fgGreen().a("Спрос (d)").reset());
            for (int d = 0; d <= maxDemand; d++) {
                System.out.print(Ansi.ansi().fgCyan().a(("%" + colWidth + "d").formatted(d)).reset());
            }
            System.out.println();

            System.out.printf("%-12s", Ansi.ansi().fgGreen().a("Вероятность (p)").reset());
            for (int d = 0; d <= maxDemand; d++) {
                System.out.print(Ansi.ansi().fg(Ansi.Color.MAGENTA).a(("%" + colWidth + ".6f").formatted(probs[d])).reset());
            }
            System.out.println();
            delimiter();

            System.out.println(Ansi.ansi().fgBlue().a("Считаем функцию ценности V(s)...").reset());
            double[] V = mdp.valueIteration();

            System.out.println(Ansi.ansi().fgGreen().a("Состояние (запас) | Ценность").reset());
            for (int s = 0; s <= C; s++) {
                System.out.print(Ansi.ansi().fgCyan().a(("%-18d").formatted(s)).reset());
                System.out.print(" | ");
                System.out.println(Ansi.ansi().fg(Ansi.Color.MAGENTA).a(("%.6f").formatted(V[s])).reset());
            }
            delimiter();

            System.out.println(Ansi.ansi().fgBlue().a("Считаем оптимальная политику π(s)...").reset());
            int[] policy = mdp.extractPolicy(V);

            System.out.println(Ansi.ansi().fgGreen().a("Состояние (запас) | Оптимальный заказ | Запас после заказа").reset());
            for (int s = 0; s <= C; s++) {
                int a = policy[s];
                System.out.print(Ansi.ansi().fgCyan().a(("%-18d").formatted(s)).reset());
                System.out.print(" | ");
                System.out.print(Ansi.ansi().fg(Ansi.Color.MAGENTA).a(("%-17d").formatted(a)).reset());
                System.out.print(" | ");
                System.out.println(Ansi.ansi().fgRgb(250, 205, 82).a(("%d").formatted(s + a)).reset());
            }
            delimiter();

            System.out.println(Ansi.ansi().fgGreen().a("Ценность начального состояния %d : %.6f".formatted(startState, V[startState])).reset());

            double[] Vpi = mdp.policyIteration();
            System.out.println(Ansi.ansi().fgGreen().a("Ценность начального состояния (Policy Iteration) %d : %.6f".formatted(startState, Vpi[startState])).reset());
            delimiter();

            while (true) {
                System.out.println("Хотите попробовать ещё один пример?");
                String input = scanner.nextLine().trim();

                if (isWantExit(input) || NO_ANSWERS.contains(input.toLowerCase())) {
                    System.exit(0);
                } else if (YES_ANSWERS.contains(input.toLowerCase())) {
                    delimiter();
                    break;
                } else {
                    error("не смог разобрать ваш ответ");
                }
            }

        }
    }

    private static int readInt(String prompt, int defaultValue, int min, int max) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isBlank()) {
            System.out.println(Ansi.ansi().fgBlue().a("Используется значение по умолчанию: " + defaultValue)
                    .reset());
            return defaultValue;
        }

        try {

            if (isWantExit(input)) {
                System.exit(0);
            }

            int value = Integer.parseInt(input);

            if (value < min) {
                error("значение должно быть больше, чем " + min);
                return readInt(prompt, defaultValue, min, max);
            }

            if (value > max) {
                error("значение должно быть меньше, чем " + max);
                return readInt(prompt, defaultValue, min, max);
            }

            return value;
        } catch (NumberFormatException e) {
            error("не смог преобразовать строку '%s' к числу".formatted(input));
            return readInt(prompt, defaultValue, min, max);
        }
    }

    private static double readDouble(String prompt, double defaultValue, double min, double max) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isBlank()) {
            System.out.println(Ansi.ansi().fgBlue().a("Используется значение по умолчанию: " + defaultValue)
                    .reset());
            return defaultValue;
        }

        try {
            if (isWantExit(input)) {
                System.exit(0);
            }

            double value = Double.parseDouble(input);

            if (value < min) {
                error("значение должно быть больше, чем " + min);
                return readDouble(prompt, defaultValue, min, max);
            }

            if (value > max) {
                error("значение должно быть меньше, чем " + max);
                return readDouble(prompt, defaultValue, min, max);
            }

            return value;
        } catch (NumberFormatException e) {
            error("не смог преобразовать строку '%s' к числу".formatted(input));
            return readDouble(prompt, defaultValue, min, max);
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