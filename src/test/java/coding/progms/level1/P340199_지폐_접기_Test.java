package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P340199_지폐_접기;
import org.junit.jupiter.api.Test;

class P340199_지폐_접기_Test {

    P340199_지폐_접기 p340199 = new P340199_지폐_접기();

    @Test
    void 테스트1 () {
        int[] wallet = {30, 15};
        int[] bill = {26, 17};

        int answer = p340199.solution(wallet, bill);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2 () {
        int[] wallet = {50, 50};
        int[] bill = {100, 241};

        int answer = p340199.solution(wallet, bill);

        System.out.println("answer = " + answer);
    }
}