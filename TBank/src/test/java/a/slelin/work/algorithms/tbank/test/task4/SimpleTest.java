package a.slelin.work.algorithms.tbank.test.task4;

import a.slelin.work.algorithms.tbank.task4.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unchecked")
public class SimpleTest {

    @Test
    public void test1() {
        List<Integer>[] list = new ArrayList[3];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        list[0].add(1);
        list[0].add(2);

        list[1].add(2);
        list[1].add(3);

        list[2].add(1);
        list[2].add(3);

        int result = Main.solve(3, 3, list);
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        List<Integer>[] list = new ArrayList[7];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        list[0].add(1);
        list[0].add(6);

        list[1].add(6);
        list[1].add(4);

        list[2].add(4);
        list[2].add(2);

        list[3].add(2);
        list[3].add(5);

        list[4].add(5);
        list[4].add(6);

        list[5].add(2);
        list[5].add(3);

        list[6].add(3);
        list[6].add(5);

        int result = Main.solve(6, 7, list);
        assertEquals(3, result);
    }
}
