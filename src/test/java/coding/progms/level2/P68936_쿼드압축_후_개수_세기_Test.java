package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P68936_쿼드압축_후_개수_세기;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class P68936_쿼드압축_후_개수_세기_Test {

    P68936_쿼드압축_후_개수_세기 p68936 = new P68936_쿼드압축_후_개수_세기();

    @Test
    void 테스트1() {
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[] result = {4, 9};

        int[] answer = p68936.solution(arr);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트2() {
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        int[] result = {10, 15};

        int[] answer = p68936.solution(arr);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }
}