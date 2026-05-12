package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P12928_약수의_합;
import org.junit.jupiter.api.Test;

class P12928_약수의_합_Test {

    P12928_약수의_합 p12928 = new P12928_약수의_합();

    @Test
    void 테스트1() {
        int n = 12;

        int answer1 = p12928.solution1(n);  // 방법1
        int answer2 = p12928.solution2(n);  // 방법2 (최적화)

        System.out.println("answer = " + answer1);
        System.out.println("answer = " + answer2);
    }

    @Test
    void 테스트2() {
        int n = 5;
        int answer1 = p12928.solution1(n);  // 방법1
        int answer2 = p12928.solution2(n);  // 방법2 (최적화)

        System.out.println("answer = " + answer1);
        System.out.println("answer = " + answer2);
    }

}