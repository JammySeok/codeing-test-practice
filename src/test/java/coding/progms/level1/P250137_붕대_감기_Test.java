package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P250137_붕대_감기;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P250137_붕대_감기_Test {

    P250137_붕대_감기 p250137 = new P250137_붕대_감기();

    @Test
    void 테스트1() {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {
                {2, 10}, {9, 15}, {10, 5}, {11, 5}
        };
        int result = 5;

        int answer = p250137.solution(bandage, health, attacks);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int[] bandage = {3, 2, 7};
        int health = 20;
        int[][] attacks = {
                {1, 15}, {5, 16}, {8, 6}
        };
        int result = -1;

        int answer = p250137.solution(bandage, health, attacks);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        int[] bandage = {4, 2, 7};
        int health = 20;
        int[][] attacks = {
                {1, 15}, {5, 16}, {8, 6}
        };
        int result = -1;

        int answer = p250137.solution(bandage, health, attacks);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트4() {
        int[] bandage = {1, 1, 1};
        int health = 5;
        int[][] attacks = {
                {1, 2}, {3, 2}
        };
        int result = 3;

        int answer = p250137.solution(bandage, health, attacks);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}