package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P12922_수박수박수;
import org.junit.jupiter.api.Test;

class P12922_수박수박수_Test {
    
    P12922_수박수박수 p12922 = new P12922_수박수박수();

    @Test
    void 테스트1() {
        int n = 3;

        String answer = p12922.solution(n);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int n = 4;

        String answer = p12922.solution(n);

        System.out.println("answer = " + answer);
    }
}