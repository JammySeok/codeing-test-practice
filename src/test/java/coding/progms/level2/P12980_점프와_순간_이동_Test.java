package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P12980_점프와_순간_이동;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P12980_점프와_순간_이동_Test {

    P12980_점프와_순간_이동 p12980 = new P12980_점프와_순간_이동();

    @Test
    void 테스트1() {
        int n = 5;
        int result = 2;

        int answer1 = p12980.solution1(n);
        int answer2 = p12980.solution2(n);
        int answer3 = p12980.solution3(n);

        Assertions.assertEquals(result, answer1);
        Assertions.assertEquals(result, answer2);
        Assertions.assertEquals(result, answer3);
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

    @Test
    void 테스트2() {
        int n = 6;
        int result = 2;

        int answer1 = p12980.solution1(n);
        int answer2 = p12980.solution2(n);
        int answer3 = p12980.solution3(n);

        Assertions.assertEquals(result, answer1);
        Assertions.assertEquals(result, answer2);
        Assertions.assertEquals(result, answer3);
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }

    @Test
    void 테스트3() {
        int n = 5000;
        int result = 5;

        int answer1 = p12980.solution1(n);
        int answer2 = p12980.solution2(n);
        int answer3 = p12980.solution3(n);

        Assertions.assertEquals(result, answer1);
        Assertions.assertEquals(result, answer2);
        Assertions.assertEquals(result, answer3);
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
    }
}