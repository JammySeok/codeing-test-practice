package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P1844_게임_맵_최단거리;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P1844_게임_맵_최단거리_Test {

    P1844_게임_맵_최단거리 p1844 = new P1844_게임_맵_최단거리();

    @Test
    void 테스트1() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int result = 11;

        int answer = p1844.solution(maps);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        int result = -1;

        int answer = p1844.solution(maps);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}