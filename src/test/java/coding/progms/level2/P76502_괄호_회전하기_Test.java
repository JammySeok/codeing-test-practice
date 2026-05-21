package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P76502_괄호_회전하기;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P76502_괄호_회전하기_Test {

    P76502_괄호_회전하기 p76502 = new P76502_괄호_회전하기();

    @Test
    void 테스트1() {
        String s = "[](){}";
        int result = 3;

        int answer = p76502.solution(s);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        String s = "}]()[{";
        int result = 2;

        int answer = p76502.solution(s);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        String s = "[)(]";
        int result = 0;

        int answer = p76502.solution(s);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트4() {
        String s = "}}}";
        int result = 0;

        int answer = p76502.solution(s);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트5() {
        String s = "[{]}";
        int result = 0;

        int answer = p76502.solution(s);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}