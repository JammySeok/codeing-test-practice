package test.java.coding.reference;

import main.java.coding.reference.멘헤튼_거리;
import org.junit.jupiter.api.Test;

class 멘헤튼_거리_Test {

    멘헤튼_거리 ref = new 멘헤튼_거리();

    @Test
    void 테스트1() {
        int x1 = 1, y1 = 2;
        int x2 = 4, y2 = 6;

        int answer = ref.solution(x1, y1, x2, y2);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int x1 = 10, y1 = 5;
        int x2 = 20, y2 = 5;

        int answer = ref.solution(x1, y1, x2, y2);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        int x1 = -2, y1 = -3;
        int x2 = 3, y2 = 2;

        int answer = ref.solution(x1, y1, x2, y2);

        System.out.println("answer = " + answer);
    }

}