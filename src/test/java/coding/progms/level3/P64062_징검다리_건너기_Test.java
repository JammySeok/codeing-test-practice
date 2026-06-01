package test.java.coding.progms.level3;

import main.java.coding.progms.level3.P64062_징검다리_건너기;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P64062_징검다리_건너기_Test {

    P64062_징검다리_건너기 p64062 = new P64062_징검다리_건너기();

    @Test
    void 테스트1() {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int result = 3;

        int answer = p64062.solution(stones, k);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}