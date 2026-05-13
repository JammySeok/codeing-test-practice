package test.java.coding.progms.level1;


import main.java.coding.progms.level1.P67256_키패드_누르기;
import org.junit.jupiter.api.Test;

class P67256_키패드_누르기_Test {

    P67256_키패드_누르기 p67256 = new P67256_키패드_누르기();

    @Test
    void 테스트1() {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        String answer = p67256.solution(numbers, hand);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        String answer = p67256.solution(numbers, hand);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        String answer = p67256.solution(numbers, hand);

        System.out.println("answer = " + answer);
    }
}