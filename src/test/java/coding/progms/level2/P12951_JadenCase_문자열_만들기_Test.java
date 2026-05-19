package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P12951_JadenCase_문자열_만들기;
import org.junit.jupiter.api.Test;

class P12951_JadenCase_문자열_만들기_Test {

    P12951_JadenCase_문자열_만들기 p12951 = new P12951_JadenCase_문자열_만들기();

    @Test
    void 테스트1() {
        String s = "3people unFollowed me";

        String answer1 = p12951.solution1(s);
        String answer2 = p12951.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트2() {
        String s = "for the last week";

        String answer1 = p12951.solution1(s);
        String answer2 = p12951.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트3() {
        String s = "hello   world  java";

        String answer1 = p12951.solution1(s);
        String answer2 = p12951.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트4() {
        String s = "  hello world  ";

        String answer1 = p12951.solution1(s);
        String answer2 = p12951.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트5() {
        String s = "    ";

        String answer1 = p12951.solution1(s);
        String answer2 = p12951.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트6() {
        String s = "a";

        String answer1 = p12951.solution1(s);
        String answer2 = p12951.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}