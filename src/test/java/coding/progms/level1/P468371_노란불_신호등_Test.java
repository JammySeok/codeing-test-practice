package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P468371_노란불_신호등;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P468371_노란불_신호등_Test {

    P468371_노란불_신호등 p468371 = new P468371_노란불_신호등();

    @Test
    void 테스트1() {
        int[][] signals = {
                {2, 1, 2},
                {5, 1, 1}
        };
        int result = 13;

        int answer = p468371.solution(signals);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int[][] signals = {
                {2, 3, 2},
                {3, 1, 3},
                {2, 1, 1}
        };
        int result = 11;

        int answer = p468371.solution(signals);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        int[][] signals = {
                {3, 3, 3},
                {5, 4, 2},
                {2, 1, 2}
        };
        int result = 193;

        int answer = p468371.solution(signals);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트4() {
        int[][] signals = {
                {1, 1, 4},
                {2, 1, 3},
                {3, 1, 2},
                {4, 1, 1}
        };
        int result = -1;

        int answer = p468371.solution(signals);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}