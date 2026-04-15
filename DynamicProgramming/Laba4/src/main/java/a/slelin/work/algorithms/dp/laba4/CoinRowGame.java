package a.slelin.work.algorithms.dp.laba4;

import lombok.Getter;

import java.util.Arrays;

/**
 * Класс, представляющий игру "Монетный ряд".
 */
public class CoinRowGame {

    private final int[] coins;         // номиналы монет
    private int left;                  // текущий левый индекс
    private int right;                 // текущий правый индекс

    @Getter
    private int playerScore;           // счёт игрока

    @Getter
    private int computerScore;        // счёт компьютера

    @Getter
    private Turn turn;        // чей сейчас ход
    private final DpSolver solver;     // алгоритм для решения динамической задачи

    public CoinRowGame(int[] coins) {
        if (coins == null || coins.length == 0) {
            throw new IllegalArgumentException("Ряд монет не может быть пустым.");
        }

        this.coins = Arrays.copyOf(coins, coins.length);
        this.left = 0;
        this.right = coins.length - 1;
        this.playerScore = 0;
        this.computerScore = 0;
        this.turn = Turn.PLAYER;        // первым ходит игрок
        this.solver = new DpSolver(this.coins);
    }

    public boolean isGameOver() {
        return left > right;
    }

    public int[] getCurrentCoins() {
        if (left > right) return new int[0];
        return Arrays.copyOfRange(coins, left, right + 1);
    }

    /**
     * Ход игрока: взять монету с левого или правого конца.
     */
    public void playerMove(Choice choice) {
        if (turn == Turn.COMPUTER) {
            throw new IllegalStateException("Сейчас не ваш ход.");
        }

        if (isGameOver()) {
            throw new IllegalStateException("Игра уже завершена.");
        }

        int taken = choice == Choice.LEFT ? coins[left++] : coins[right--];
        playerScore += taken;
        turn = Turn.COMPUTER;

        System.out.println("\uD83D\uDE80 Вы выбрали " + AnsiColors.BLUE + AnsiColors.BOLD
                + (choice == Choice.LEFT ? "левую" : "правую") + AnsiColors.RESET
                + " монету достоинством : "
                + AnsiColors.GREEN + AnsiColors.BOLD + taken + AnsiColors.RESET + ".");
        System.out.println();
    }

    /**
     * Ход компьютера: выбирает оптимальный конец с помощью DP.
     */
    public void computerMove() {
        if (turn == Turn.PLAYER) {
            throw new IllegalStateException("Сейчас ход игрока, компьютер не может ходить.");
        }

        if (isGameOver()) {
            throw new IllegalStateException("Игра уже завершена.");
        }

        // Получаем рекомендацию от DP-решателя
        Choice choice = solver.optimalMove(left, right);
        int taken = choice == Choice.LEFT ? coins[left++] : coins[right--];
        computerScore += taken;
        turn = Turn.PLAYER;

        System.out.println("\uD83D\uDCCA Компьютер выбирает " + AnsiColors.BLUE + AnsiColors.BOLD
                + (choice == Choice.LEFT ? "левую" : "правую") + AnsiColors.RESET
                + " монету достоинством : "
                + AnsiColors.GREEN + AnsiColors.BOLD + taken + AnsiColors.RESET + ".");
        System.out.println();
    }

    /**
     * Вложенный класс, реализующий динамическое программирование
     * для задачи оптимальной игры в монетный ряд.
     */
    private static class DpSolver {
        private final int[] coins;
        private final int n;
        private final int[][] dp;    // dp[i][j] – максимальный выигрыш первого игрока на подмассиве i..j
        private final Choice[][] choice;

        public DpSolver(int[] coins) {
            this.coins = coins;
            this.n = coins.length;
            this.dp = new int[n][n];
            this.choice = new Choice[n][n];
            buildTable();
        }

        /**
         * Заполняет таблицы DP и choice.
         * dp[i][j] = max( coins[i] + min(dp[i+2][j], dp[i+1][j-1]),
         * coins[j] + min(dp[i+1][j-1], dp[i][j-2]) )
         * (Учитываем, что противник тоже играет оптимально.)
         */
        private void buildTable() {
            // Базовый случай: один элемент
            for (int i = 0; i < n; i++) {
                dp[i][i] = coins[i];
                choice[i][i] = Choice.LEFT; // неважно, берём левую (единственную)
            }

            // Подмассивы длины 2 и более
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;

                    // Вариант 1: берём левую монету coins[i]
                    int leftGain = coins[i];
                    if (i + 1 <= j) {
                        // Противник после нашего хода будет выбирать лучшее для себя,
                        // что оставит нам минимум из двух возможных продолжений.
                        int opponentLeft = (i + 2 <= j) ? dp[i + 2][j] : 0;
                        int opponentRight = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                        leftGain += Math.min(opponentLeft, opponentRight);
                    }

                    // Вариант 2: берём правую монету coins[j]
                    int rightGain = coins[j];
                    if (i <= j - 1) {
                        int opponentLeft = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                        int opponentRight = (i <= j - 2) ? dp[i][j - 2] : 0;
                        rightGain += Math.min(opponentLeft, opponentRight);
                    }

                    if (leftGain >= rightGain) {
                        dp[i][j] = leftGain;
                        choice[i][j] = Choice.LEFT;   // выгоднее взять левую
                    } else {
                        dp[i][j] = rightGain;
                        choice[i][j] = Choice.RIGHT;  // выгоднее взять правую
                    }
                }
            }
        }

        /**
         * Возвращает оптимальный ход для текущей позиции (left, right).
         */
        public Choice optimalMove(int left, int right) {
            if (left > right) {
                throw new IllegalArgumentException("Некорректные границы.");
            }

            return choice[left][right];
        }
    }
}