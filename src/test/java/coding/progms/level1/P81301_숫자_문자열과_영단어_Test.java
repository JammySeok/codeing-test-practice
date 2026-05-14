package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P81301_숫자_문자열과_영단어;
import org.junit.jupiter.api.Test;

class P81301_숫자_문자열과_영단어_Test {

    P81301_숫자_문자열과_영단어 p81301 = new P81301_숫자_문자열과_영단어();

    @Test
    void 테스트1() {
        String s = "one4seveneight";

        int answer1 = p81301.solution2(s);
        int answer2 = p81301.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트2() {
        String s = "23four5six7";

        int answer1 = p81301.solution1(s);
        int answer2 = p81301.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트3() {
        String s = "2three45sixseven";

        int answer1 = p81301.solution1(s);
        int answer2 = p81301.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트4() {
        String s = "123";

        int answer1 = p81301.solution1(s);
        int answer2 = p81301.solution2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}