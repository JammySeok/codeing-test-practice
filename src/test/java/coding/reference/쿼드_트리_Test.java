package test.java.coding.reference;

import main.java.coding.reference.쿼드_트리;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class 쿼드_트리_Test {

    쿼드_트리 ref = new 쿼드_트리();

    @Test
    void 테스트1() {
        int[][] board = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[] result = {4, 9};

        int[] answer = ref.quadTree(board);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트2() {
        int[][] board = {
                {1, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1}
        };
        int[] result = {9, 7};

        int[] answer = ref.quadTree(board);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }
}