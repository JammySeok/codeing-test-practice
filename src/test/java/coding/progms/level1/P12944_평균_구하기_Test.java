package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P12944_평균_구하기;
import org.junit.jupiter.api.Test;

class P12944_평균_구하기_Test {

    P12944_평균_구하기 p12944 = new P12944_평균_구하기();

    @Test
    void 테스트1() {
        // given
        int[] arr = {1, 2, 3, 4};

        // when
        double answer = p12944.solution(arr);

        // then
        System.out.println("answer = " + answer);
    }
}