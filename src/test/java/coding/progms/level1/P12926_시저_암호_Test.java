package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P12926_시저_암호;
import org.junit.jupiter.api.Test;

class P12926_시저_암호_Test {

    P12926_시저_암호 p12926 = new P12926_시저_암호();

    @Test
    void 테스트1() {
        String s = "AB";
        int n = 1;

        String answer1 = p12926.solution1(s, n);
        String answer2 = p12926.solution2(s, n);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트2() {
        String s = "z";
        int n = 1;

        String answer1 = p12926.solution1(s, n);
        String answer2 = p12926.solution2(s, n);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트3() {
        String s = "a B z";
        int n = 4;

        String answer1 = p12926.solution1(s, n);
        String answer2 = p12926.solution2(s, n);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}