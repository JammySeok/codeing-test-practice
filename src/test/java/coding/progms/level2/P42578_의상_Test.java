package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P42578_의상;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P42578_의상_Test {

    P42578_의상 p42578 = new P42578_의상();

    @Test
    void 테스트1() {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int result = 5;

        int answer = p42578.solution(clothes);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        String[][] clothes = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        int result = 3;

        int answer = p42578.solution(clothes);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}