package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P12973_짝지어_제거하기;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P12973_짝지어_제거하기_Test {

    P12973_짝지어_제거하기 p12973 = new P12973_짝지어_제거하기();

    @Test
    void 테스트1() {
        String s = "baabaa";
        int result = 1;

        int answer = p12973.solution(s);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        String s = "cdcd";
        int result = 0;

        int answer = p12973.solution(s);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}