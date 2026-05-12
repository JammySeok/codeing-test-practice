package test.java.coding.reference;

import main.java.coding.reference.유클리드_호제법;
import org.junit.jupiter.api.Test;

class 유클리드_호제법_Test {

    유클리드_호제법 ref = new 유클리드_호제법();

    @Test
    void 테스트1() {
        int a = 12;
        int b = 18;

        int[] solution = ref.solution(a, b);

        System.out.println("최대공약수(gcd): " + solution[0]);
        System.out.println("최소공배수(lcm): " + solution[1]);
    }

    @Test
    void 테스트2() {
        int a = 100;
        int b = 25;

        int[] solution = ref.solution(a, b);

        System.out.println("최대공약수(gcd): " + solution[0]);
        System.out.println("최소공배수(lcm): " + solution[1]);
    }

    @Test
    void 테스트3() {
        // 서로소
        int a = 17;
        int b = 13;

        int[] solution = ref.solution(a, b);

        System.out.println("최대공약수(gcd): " + solution[0]);
        System.out.println("최소공배수(lcm): " + solution[1]);
    }
}