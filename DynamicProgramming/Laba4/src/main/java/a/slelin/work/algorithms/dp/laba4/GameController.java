package a.slelin.work.algorithms.dp.laba4;

import java.util.Scanner;

/**
 * Контроллер игры: отображение состояния, обработка ввода, управление ходами.
 */
public class GameController {

    private final Scanner scanner;

    private CoinRowGame game;

    private final int delimiterLength = 100;

    public GameController() {
        this.scanner = new Scanner(System.in);
        this.game = null;
    }

    public void start() {
        printWelcome();

        int[] initialCoins = {5, 10, 3, 8, 7, 2, 9, 4};
        game = new CoinRowGame(initialCoins);

        while (!game.isGameOver()) {
            printState();

            if (game.getTurn() == Turn.PLAYER) {
                handlePlayerMove();
            } else {
                handleComputerMove();
            }
        }

        printGameResult();
        askReplay();
    }

    private void printWelcome() {
        String welcome = " МОНЕТНЫЙ РЯД ";
        delimiterLn(delimiterLength + welcome.length());
        delimiter(delimiterLength / 2);
        System.out.print(AnsiColors.CYAN + AnsiColors.BOLD + welcome + AnsiColors.RESET);
        delimiterLn(delimiterLength / 2);
        delimiterLn(delimiterLength + welcome.length());
        System.out.println();

        delimiterLn(delimiterLength + welcome.length());
        System.out.println("Вы и компьютер по очереди берёте монету \uD83D\uDCB0 с одного из концов ряда.");
        System.out.println("Ваша цель – \uD83E\uDD47 набрать больше очков, чем компьютер \uD83E\uDD16.");
        System.out.println("Обдумывайте \uD83E\uDD2F каждый свой шаг и удачи \uD83C\uDFAF!!!");
        delimiterLn(delimiterLength + welcome.length());
        System.out.println();
    }

    private void printState() {
        int[] currentCoins = game.getCurrentCoins();

        System.out.println(AnsiColors.YELLOW + "Текущий ряд \uD83D\uDCB5: " + AnsiColors.RESET);
        for (int i = 0; i < currentCoins.length; i++) {
            if (i == 0) {
                System.out.print(AnsiColors.GREEN + "["
                        + AnsiColors.BOLD + currentCoins[i] + AnsiColors.RESET
                        + AnsiColors.GREEN + "]" + AnsiColors.RESET);
            } else if (i == currentCoins.length - 1) {
                System.out.print(" " + AnsiColors.GREEN + "["
                        + AnsiColors.BOLD + currentCoins[i] + AnsiColors.RESET
                        + AnsiColors.GREEN + "]" + AnsiColors.RESET);
            } else {
                System.out.print(" " + currentCoins[i]);
            }
        }

        System.out.println();
        System.out.println(AnsiColors.BLUE + "Счёт: \uD83D\uDE00 Вы = "
                + AnsiColors.RESET + AnsiColors.GREEN + AnsiColors.BOLD + game.getPlayerScore()
                + AnsiColors.RESET + AnsiColors.BLUE + " | \uD83E\uDD16 Компьютер = "
                + AnsiColors.RESET + AnsiColors.RED + AnsiColors.BOLD + game.getComputerScore()
                + AnsiColors.RESET);
        System.out.println();
    }

    private void handlePlayerMove() {
        System.out.print("Ваш ход. ⏳ Введите '"
                + AnsiColors.CYAN + AnsiColors.BOLD + "Л" + AnsiColors.RESET
                + "' (левая монета) или '"
                + AnsiColors.CYAN + AnsiColors.BOLD + "П" + AnsiColors.RESET
                + "' (правая монета): ");
        String input = scanner.nextLine().trim();

        if (WordsUtil.isIntoSet(input, "exit")) {
            System.exit(0);
        }

        Choice choice;
        if (WordsUtil.isIntoSet(input, "left")) {
            choice = Choice.LEFT;
        } else if (WordsUtil.isIntoSet(input, "right")) {
            choice = Choice.RIGHT;
        } else {
            System.out.println(AnsiColors.RED
                    + "Ошибка: введите Л или П!"
                    + AnsiColors.RESET);
            System.out.println();
            return;
        }
        delimiterLn(delimiterLength);
        System.out.println();

        try {
            game.playerMove(choice);
        } catch (IllegalStateException e) {
            System.out.println(AnsiColors.RED + "Ошибка: " + e.getMessage() + AnsiColors.RESET);
        }
    }

    private void handleComputerMove() {
        System.out.println(AnsiColors.CYAN + "⌛ Ход компьютера..." + AnsiColors.RESET);

        try {
            game.computerMove();
        } catch (IllegalStateException e) {
            System.out.println(AnsiColors.RED + "Ошибка в ходе компьютера: " + e.getMessage() + AnsiColors.RESET);
        }

        // Симулируем размышления компьютера
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
    }

    private void printGameResult() {
        System.out.println("\uD83C\uDFC1".repeat(36));
        System.out.print("\uD83C\uDFC1".repeat(14));
        System.out.print(AnsiColors.CYAN + AnsiColors.BOLD + " ИГРА ОКОНЧЕНА! " + AnsiColors.RESET);
        System.out.println("\uD83C\uDFC1".repeat(14));
        System.out.println("\uD83C\uDFC1".repeat(36));
        System.out.println();

        int player = game.getPlayerScore();
        int computer = game.getComputerScore();
        System.out.println(AnsiColors.BLUE + "Итоговый счёт: \uD83D\uDE00 Вы = " + AnsiColors.RESET
                + AnsiColors.GREEN + AnsiColors.BOLD + player + AnsiColors.RESET + AnsiColors.BLUE
                + ", \uD83E\uDD16 Компьютер = " + AnsiColors.RESET + AnsiColors.RED + AnsiColors.BOLD
                + computer + AnsiColors.RESET);
        System.out.println();

        if (player > computer) {
            System.out.println(AnsiColors.GREEN + AnsiColors.BOLD
                    + "\uD83C\uDF89 Поздравляем! \uD83D\uDE01 Вы победили! \uD83C\uDFC6" + AnsiColors.RESET);
        } else if (player < computer) {
            System.out.println(AnsiColors.RED + AnsiColors.BOLD
                    + "\uD83D\uDE28 Компьютер выиграл. \uD83E\uDD48" + AnsiColors.RESET);
        } else {
            System.out.println(AnsiColors.YELLOW + AnsiColors.BOLD
                    + "\uD83D\uDE11 Ничья! \uD83E\uDD14" + AnsiColors.RESET);
        }
    }

    private void askReplay() {
        System.out.print("\nХотите сыграть ещё раз? (да/нет): ");
        String answer = scanner.nextLine().trim();
        System.out.println();

        if (WordsUtil.isIntoSet(answer, "exit")) {
            System.exit(0);
        }

        if (WordsUtil.isIntoSet(answer, "yes")) {
            start();
        } else if (WordsUtil.isIntoSet(answer, "no")) {
            System.out.println(AnsiColors.CYAN + AnsiColors.BOLD + "\uD83E\uDD29 Спасибо за игру! Возвращайтесь! \uD83D\uDC4B" + AnsiColors.RESET);
            scanner.close();
        } else {
            System.out.println(AnsiColors.RED + "Ошибка: не разобрал " + answer + AnsiColors.RESET);
            askReplay();
        }
    }

    private void delimiter(int count) {
        System.out.print(AnsiColors.YELLOW + "*".repeat(count) + AnsiColors.RESET);
    }

    private void delimiterLn(int count) {
        delimiter(count);
        System.out.println();
    }
}