package a.slelin.work.algorithms.dp.laba3;

import lombok.Getter;

@Getter
public class MDP {

    // Точность
    public final double epsilon = 1e-9;

    private final int C;                // запас на складе (максимальное число)
    private final double price;                // цена продажи за единицу
    private final double cost;                 // стоимость заказа за единицу
    private final double holding;              // штраф за хранение за единицу
    private final double shortage;             // штраф за дефицит за единицу
    private final double gamma;                // коэффициент дисконтирования
    private final double lambda;               // параметр распределения Пуассона

    private int maxDemand;                     // максимальное значение спроса, учитываемое в расчётах
    private double[] demandProbs;              // вероятности спроса (индекс i = d)
    private final int numStates;                     // количество состояний = С + 1 (ещё нулевое)
    private final double[][][] transitions;          // transitions[s][a][sp] = вероятность перехода
    private final double[][] expectedReward;         // expectedReward[s][a] = ожидаемая мгновенная награда

    public MDP(int C, double price, double cost, double holding,
               double shortage, double gamma, double lambda) {
        this.C = C;
        this.price = price;
        this.cost = cost;
        this.holding = holding;
        this.shortage = shortage;
        this.gamma = gamma;
        this.lambda = lambda;
        this.numStates = C + 1;

        // Вычисляем вероятности спроса по Пуассону
        computeDemandProbabilities();

        // Инициализируем массивы переходов и ожидаемых наград
        transitions = new double[numStates][numStates][numStates];
        expectedReward = new double[numStates][numStates];

        // Заполняем их
        computeTransitionsAndRewards();
    }

    /**
     * Вычисляет вероятности спроса по формуле Пуассона.
     */
    private void computeDemandProbabilities() {
        maxDemand = 5;
        demandProbs = new double[maxDemand + 1];
        double sum = 0.0;
        for (int d = 0; d <= 5; d++) {
            demandProbs[d] = poissonProbability(d, lambda);
            sum += demandProbs[d];
        }

        // Нормализация
        for (int d = 0; d <= 5; d++) {
            demandProbs[d] /= sum;
        }
    }

    private double poissonProbability(int k, double lambda) {
        return Math.exp(-lambda) * Math.pow(lambda, k) / factorial(k);
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    /**
     * Для каждого состояния s и действия a (0..C-s) вычисляет:
     * - вероятности перехода в sp (новое состояние)
     * - ожидаемую мгновенную награду
     */
    private void computeTransitionsAndRewards() {
        // Для каждого состояния (сколько есть сейчас на складе)
        for (int s = 0; s < numStates; s++) {
            // Для каждого действия (сколько заказываем дополнительное на склад)
            for (int a = 0; a <= C - s; a++) {

                // Для каждого возможного спроса d (сколько у нас купят по распределению)
                // Разные спросы могут приводить возможно к одному и тому же новому состоянию sp (поэтому +=)
                for (int d = 0; d <= maxDemand; d++) {

                    // Вероятность такого спроса
                    double probD = demandProbs[d];

                    // Новое состояние
                    int sp = s + a - d;

                    // Неудовлетворенный спрос
                    if (sp < 0) sp = 0;

                    // Вероятность перехода
                    transitions[s][a][sp] += probD;

                    // Мгновенная награда при данном спросе
                    double reward = computeReward(s, a, d);
                    expectedReward[s][a] += probD * reward;
                }
            }
        }
    }

    /**
     * Вычисляет награду за один шаг: s -> a при реализации спроса d.
     */
    private double computeReward(int s, int a, int d) {
        int available = s + a; // доступно
        int sold = Math.min(d, available); // продали
        int leftover = Math.max(available - d, 0); // осталось
        int unsatisfied = Math.max(d - available, 0); // не удовлетворили

        return price * sold - cost * a - holding * leftover - shortage * unsatisfied;
    }

    /**
     * Итерация по ценности.
     */
    public double[] valueIteration() {
        double[] V = new double[numStates];
        double[] Vnew = new double[numStates];
        int maxIter = 1000;
        int iter = 0;
        double delta; // разница между векторами (чтобы когда будет маленькая выйти)

        do {
            delta = 0.0;
            for (int s = 0; s < numStates; s++) {
                double best = -Double.MAX_VALUE;
                for (int a = 0; a <= C - s; a++) {
                    double value = expectedReward[s][a];

                    for (int sp = 0; sp < numStates; sp++) {
                        value += gamma * transitions[s][a][sp] * V[sp];
                    }

                    if (value > best) {
                        best = value;
                    }
                }
                Vnew[s] = best;
                delta = Math.max(delta, Math.abs(Vnew[s] - V[s]));
            }

            // переставляем вектора
            double[] tmp = V;
            V = Vnew;
            Vnew = tmp;

            iter++;
        } while (delta >= epsilon && iter < maxIter);

        return V;
    }

    /**
     * Извлекает оптимальную политику из заданной функции ценности V.
     */
    public int[] extractPolicy(double[] V) {
        int[] policy = new int[numStates];

        for (int s = 0; s < numStates; s++) {
            double bestValue = -Double.MAX_VALUE;
            int bestAction = 0;
            for (int a = 0; a <= C - s; a++) {
                double value = expectedReward[s][a];

                for (int sp = 0; sp < numStates; sp++) {
                    value += gamma * transitions[s][a][sp] * V[sp];
                }

                if (value > bestValue) {
                    bestValue = value;
                    bestAction = a;
                }
            }
            policy[s] = bestAction;
        }
        return policy;
    }

    public int[] extractPolicy() {
        return extractPolicy(valueIteration());
    }

    /**
     * Итерация по политике (Policy Iteration).
     */
    public double[] policyIteration() {
        // Начальная политика: всегда заказывать 0
        int[] policy = new int[numStates];

        boolean changed;
        do {
            // Оценка политики: решаем систему линейных уравнений V = R + γ * P * V
            double[] V = evaluatePolicy(policy);

            // Улучшение политики
            changed = false;
            for (int s = 0; s < numStates; s++) {
                double bestValue = -Double.MAX_VALUE;
                int bestAction = policy[s];
                for (int a = 0; a <= C - s; a++) {
                    double value = expectedReward[s][a];
                    for (int sp = 0; sp < numStates; sp++) {
                        value += gamma * transitions[s][a][sp] * V[sp];
                    }
                    if (value > bestValue) {
                        bestValue = value;
                        bestAction = a;
                    }
                }
                if (bestAction != policy[s]) {
                    policy[s] = bestAction;
                    changed = true;
                }
            }
        } while (changed);

        // После сходимости возвращаем ценности для финальной политики
        return evaluatePolicy(policy);
    }

    /**
     * Оценка заданной политики: решаем систему (I - γ*P) V = R.
     * Используется итерационный метод (оценка политики итеративно).
     * Для простоты реализуем итерации до сходимости.
     */
    private double[] evaluatePolicy(int[] policy) {
        double[] V = new double[numStates];
        double[] Vnew = new double[numStates];
        double epsilon = 1e-6;
        int maxIter = 1000;
        int iter = 0;
        double delta;

        do {
            delta = 0.0;
            for (int s = 0; s < numStates; s++) {
                int a = policy[s];
                double value = expectedReward[s][a];
                for (int sp = 0; sp < numStates; sp++) {
                    value += gamma * transitions[s][a][sp] * V[sp];
                }
                Vnew[s] = value;
                delta = Math.max(delta, Math.abs(Vnew[s] - V[s]));
            }
            double[] tmp = V;
            V = Vnew;
            Vnew = tmp;
            iter++;
        } while (delta >= epsilon && iter < maxIter);
        return V;
    }
}