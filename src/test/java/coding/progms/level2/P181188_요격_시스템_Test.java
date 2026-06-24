package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P181188_요격_시스템;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P181188_요격_시스템_Test {

    P181188_요격_시스템 p181188 = new P181188_요격_시스템();

    @Test
    void 테스트1() {
        int[][] targets = {
            {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}
        };
        int result = 3;

        int answer = p181188.solution(targets);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

}