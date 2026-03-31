package a.slelin.work.algorithms.dp.laba3.test;

import a.slelin.work.algorithms.dp.laba3.MDP;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SimpleTest {

    @Test
    public void test1() {
        MDP mdp = new MDP(5, 12, 6, 1, 0, 0.9, 1.5);
        double[] valueIteration = mdp.valueIteration();
        System.out.println(valueIteration[3]);
        int[] policy = mdp.extractPolicy();
        System.out.println(Arrays.toString(policy));
    }

    @Test
    public void test2() {
        MDP mdp = new MDP(5, 12, 6, 1, 0, 0.9, 0.5);
        double[] valueIteration = mdp.valueIteration();
        System.out.println(valueIteration[3]);
        int[] policy = mdp.extractPolicy();
        System.out.println(Arrays.toString(policy));
    }

    @Test
    public void test3() {
        MDP mdp = new MDP(5, 12, 6, 1, 0, 0.9, 3.0);
        double[] valueIteration = mdp.valueIteration();
        System.out.println(valueIteration[3]);
        int[] policy = mdp.extractPolicy();
        System.out.println(Arrays.toString(policy));
    }
}
