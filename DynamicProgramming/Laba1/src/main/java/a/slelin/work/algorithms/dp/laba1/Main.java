package a.slelin.work.algorithms.dp.laba1;

import org.fusesource.jansi.Ansi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        String tmp = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                // Получаем строку S
                boolean getS = false;
                while (!getS) {
                    System.out.print("Введите значение для строки S (строчные латинские буквы): ");
                    tmp = br.readLine().trim();

                    if (isWantExit(tmp)) {
                        return;
                    }

                    if (tmp.isBlank()) {
                        error("введенное значение строки S должно быть не путо");
                        continue;
                    }

                    if (!tmp.matches("[a-z]+")) {
                        error("введенное значение строки S должно состоять из строчных латинских букв");
                        continue;
                    }

                    if (tmp.length() > 100000) {
                        error("длина введенного значения строки S должна быть меньше, чем " + 100000);
                        continue;
                    }

                    getS = true;
                }
                String S = tmp;

                // Получаем число M (количество записей в словаре)
                boolean getM = false;
                long M = 0;
                while (!getM) {
                    System.out.print("Введите количество записей в словаре M (число, большее нуля): ");
                    tmp = br.readLine().trim();

                    if (isWantExit(tmp)) {
                        return;
                    }

                    if (tmp.isBlank()) {
                        error("введенная строка не должна быть пустой");
                        continue;
                    }

                    try {
                        M = Long.parseLong(tmp);

                        if (M <= 0L) {
                            error("введенное значение M должно быть больше нуля");
                            continue;
                        }

                        if (M > 10000) {
                            error("введенное значение М должно быть меньше, чем " + 10000);
                            continue;
                        }

                    } catch (NumberFormatException ignore) {
                        error("невозможно преобразовать строку '%s' к числу".formatted(tmp));
                        continue;
                    }

                    getM = true;
                }

                // Считываем словарь слов и их весов
                Map<String, Long> map = new HashMap<>();
                for (int i = 0; i < M; ++i) {
                    String key = "";
                    long value = 0;

                    boolean getPair = false;
                    while (!getPair) {
                        System.out.printf("\tПара N%d (слово:вес): ", i + 1);
                        tmp = br.readLine().trim();

                        if (isWantExit(tmp)) {
                            return;
                        }

                        if (tmp.isBlank()) {
                            error("пара не должна быть пустая");
                            continue;
                        }

                        String[] pair;
                        try {
                            pair = tmp.split(":");

                            if (pair.length != 2) {
                                error("в паре должно быть только 2 значения (слово:вес)");
                                continue;
                            }

                        } catch (Exception e) {
                            error("не смог разобрать пару (слово:вес)");
                            continue;
                        }

                        key = pair[0].trim();

                        if (key.isBlank()) {
                            error("слово (ключ) в паре не должно быть пустым");
                            continue;
                        }

                        try {
                            value = Long.parseLong(pair[1].trim());

                            if (value <= 0L) {
                                error("вес должен быть больше нуля");
                                continue;
                            }

                        } catch (NumberFormatException e) {
                            error("невозможно преобразовать вес '%s' к числу".formatted(pair[1]));
                            continue;
                        }

                        getPair = true;
                    }

                    map.put(key, value);
                }

                // Считываем число L (максимальная длина слова из словаря),
                // причём проверяем "не обманывает ли" нас пользователь.
                long L;
                System.out.print("Введите значение L (максимальная длина слова из словаря): ");
                tmp = br.readLine().trim();

                if (isWantExit(tmp)) {
                    return;
                }

                String maxKey = map.keySet().stream()
                        .max(Comparator.comparing(String::length))
                        .orElseThrow(() ->
                                new RuntimeException("Не удалось определить максимальный ключ (значение для L)."));

                try {
                    L = Long.parseLong(tmp);

                    if (L != maxKey.length()) {
                        L = maxKey.length();
                        error("неверный ввод L! Найдено слово '%s' с длиной L = %d".formatted(maxKey, maxKey.length()));
                    }

                } catch (Exception ignore) {
                    error("не смог разобрать введенное значение L из строки '%s'".formatted(tmp));
                    L = maxKey.length();
                    System.out.printf("Автоматическое вычисление значения L! Найдено слово '%s' с длиной L = %d.%n",
                            maxKey, L);
                }

                // Выводим на консоль итоговые введенные значения
                delimiter();
                System.out.println(Ansi.ansi().fgBlue().a("Итог:").reset());
                System.out.println(Ansi.ansi().fgBlue().a("\tS = '%s'.".formatted(S)).reset());
                System.out.println(Ansi.ansi().fgBlue().a("\tM = %d.".formatted(M)).reset());
                System.out.println(Ansi.ansi().fgBlue().a("\tL = %d.".formatted(L)).reset());
                System.out.println(Ansi.ansi().fgBlue().a("\tСловарь:").reset());
                map.forEach((key, value) -> System.out.println(Ansi.ansi().fgBlue()
                        .a("\t\tПара: (%s:%d).".formatted(key, value)).reset()));
                delimiter();

                // Запускаем алгоритм и также выводим результат его работы
                System.out.println("Запускаю алгоритм...");
                Algorithm.Result result = Algorithm.solve(S, map, L);

                if (result.isUnresolved()) {
                    System.out.println(Ansi.ansi().fgGreen()
                            .a("Разбиение с введенными данными невозможно!").reset());
                } else {
                    System.out.println();
                    System.out.println(Ansi.ansi().fgGreen().a("Максимальная сумма: " + result.getTotalWeight())
                            .reset());
                    System.out.println(Ansi.ansi().fgGreen()
                            .a("Комбинирование строки (слова разбиения): " + "\"" + String.join("\" \"",
                                    result.getWords()) + "\"").reset());
                }

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
