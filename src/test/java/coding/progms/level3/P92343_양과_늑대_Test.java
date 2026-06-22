package test.java.coding.progms.level3;

import main.java.coding.progms.level3.P92343_양과_늑대;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P92343_양과_늑대_Test {

    P92343_양과_늑대 p92343 = new P92343_양과_늑대();

    @Test
    void 테스트1() {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4,3}, {6, 5}, {4, 6}, {8, 9}
        };
        int result = 5;

        int answer = p92343.solution(info, edges);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int[] info = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}
        };
        int result = 5;

        int answer = p92343.solution(info, edges);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}