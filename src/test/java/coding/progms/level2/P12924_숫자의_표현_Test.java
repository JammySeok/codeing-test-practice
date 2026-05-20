package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P12924_숫자의_표현;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P12924_숫자의_표현_Test {

    P12924_숫자의_표현 p12924 = new P12924_숫자의_표현();

    @Test
    void 테스트1() {
        int n = 15;
        int result = 4;

        int answer1 = p12924.solution1(n);
        int answer2 = p12924.solution2(n);

        Assertions.assertEquals(result, answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트2() {
        int n = 2;
        int result = 1;

        int answer1 = p12924.solution1(n);
        int answer2 = p12924.solution2(n);

        Assertions.assertEquals(result, answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}