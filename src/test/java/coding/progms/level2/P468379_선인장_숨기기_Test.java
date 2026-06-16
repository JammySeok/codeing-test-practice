package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P468379_선인장_숨기기;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class P468379_선인장_숨기기_Test {

    P468379_선인장_숨기기 p468379 = new P468379_선인장_숨기기();

    @Test
    void 테스트1() {
        int m = 4, n = 5;  // 사막 범위
        int h = 2, w = 2;  // 선인장 범위
        int[][] drops = {
                {0, 0}, {3, 1}, {1, 3}, {2, 4}, {1, 1}, {2, 2}, {2, 3}, {0, 4}
        };
        int[] result = {2, 2};

        int[] answer = p468379.solution(m, n, h, w, drops);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트2() {
        int m = 3, n = 3;
        int h = 1, w = 1;
        int[][] drops = {
                {0, 0}, {0, 1}, {0, 2}, {1, 0}
        };
        int[] result = {1, 1};

        int[] answer = p468379.solution(m, n, h, w, drops);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트3() {
        int m = 4, n = 6;
        int h = 3, w = 4;
        int[][] drops = {
                {1, 2}
        };
        int[] result = {0, 0};

        int[] answer = p468379.solution(m, n, h, w, drops);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트4() {
        int m = 4, n = 6;
        int h = 1, w = 2;
        int[][] drops = {
                {0, 1}, {0, 3}, {0, 5}, {1, 1}, {1, 3}, {1, 5}, {2, 1}, {2, 3}, {2, 5}, {3, 1}, {3, 3}, {3, 5}
        };
        int[] result = {3, 4};

        int[] answer = p468379.solution(m, n, h, w, drops);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트5() {
        int m = 2, n = 2;
        int h = 2, w = 2;
        int[][] drops = {
                {0, 0}, {0, 1}, {1, 1}, {1, 0}
        };
        int[] result = {0, 0};

        int[] answer = p468379.solution(m, n, h, w, drops);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트6() {
        int m = 4, n = 4;
        int h = 3, w = 1;
        int[][] drops = {
                {2, 0}, {1, 3}, {3, 2}, {0, 1}
        };
        int[] result = {0, 2};

        int[] answer = p468379.solution(m, n, h, w, drops);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }
}