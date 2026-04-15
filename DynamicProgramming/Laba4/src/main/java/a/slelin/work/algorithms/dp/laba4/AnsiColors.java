package a.slelin.work.algorithms.dp.laba4;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Утилитный класс с ANSI-кодами для подсветки текста в консоли.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AnsiColors {

    public static final String RESET = "\u001B[0m";

    public static final String RED = "\u001B[31m";

    public static final String GREEN = "\u001B[32m";

    public static final String YELLOW = "\u001B[33m";

    public static final String BLUE = "\u001B[34m";

    public static final String CYAN = "\u001B[36m";

    public static final String BOLD = "\u001B[1m";
}