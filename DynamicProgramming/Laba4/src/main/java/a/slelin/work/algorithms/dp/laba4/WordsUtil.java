package a.slelin.work.algorithms.dp.laba4;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Утилитный класс с разной возможностью написать слово.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WordsUtil {

    public final static List<String> leftSet;

    public final static List<String> rightSet;

    public final static List<String> exitSet;

    public final static List<String> yesSet;

    public final static List<String> noSet;

    static {
        leftSet = List.of("l", "left", "л", "левая");

        rightSet = List.of("r", "right", "п", "правая");

        exitSet = List.of(
                "\\exit", "\\quite", "\\stop", "\\end", "\\close",
                "\\выйти", "\\выход", "\\завершить", "\\стоп", "\\конец"
        );

        yesSet = List.of("yes", "y", "да", "д");

        noSet = List.of("no", "n", "нет", "н");
    }

    public static boolean isIntoSet(String key) {
        return isIntoSet(key, "exit");
    }

    public static boolean isIntoSet(String key, String setName) {
        List<String> set = determineSet(setName);

        for (String str : set) {
            if (str.equalsIgnoreCase(key)) {
                return true;
            }
        }

        return false;
    }

    public static List<String> determineSet(String name) {
        return switch (name) {
            case "left" -> leftSet;
            case "right" -> rightSet;
            case "exit" -> exitSet;
            case "yes" -> yesSet;
            case "no" -> noSet;
            default -> throw new IllegalArgumentException("Illegal set name: " + name);
        };
    }
}
