package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P42862_체육복;
import org.junit.jupiter.api.Test;

class P42862_체육복_Test {

    P42862_체육복 p42862 = new P42862_체육복();

    @Test
    void 테스트1() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int answer = p42862.solution(n, lost, reserve);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        int answer = p42862.solution(n, lost, reserve);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        int answer = p42862.solution(n, lost, reserve);

        System.out.println("answer = " + answer);
    }
}