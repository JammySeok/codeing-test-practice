package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P340212_퍼즐_게임_챌린지;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P340212_퍼즐_게임_챌린지_Test {

    P340212_퍼즐_게임_챌린지 p340212 = new P340212_퍼즐_게임_챌린지();

    @Test
    void 테스트1() {
        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        long limit = 30;
        int result = 3;

        int answer1 = p340212.solution1(diffs, times, limit);
        int answer2 = p340212.solution2(diffs, times, limit);

        Assertions.assertEquals(result, answer1);
        System.out.println("answer1 = " + answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트2() {
        int[] diffs = {1, 4, 4, 2};
        int[] times = {6, 3, 8, 2};
        long limit = 59;
        int result = 2;

        int answer1 = p340212.solution1(diffs, times, limit);
        int answer2 = p340212.solution2(diffs, times, limit);

        Assertions.assertEquals(result, answer1);
        System.out.println("answer1 = " + answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트3() {
        int[] diffs = {1, 328, 467, 209, 54};
        int[] times = {2, 7, 1, 4, 3};
        long limit = 1723;
        int result = 294;

        int answer1 = p340212.solution1(diffs, times, limit);
        int answer2 = p340212.solution2(diffs, times, limit);

        Assertions.assertEquals(result, answer1);
        System.out.println("answer1 = " + answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트4() {
        int[] diffs = {1, 99999, 100000, 99995};
        int[] times = {9999, 9001, 9999, 9001};
        long limit = 3456789012L;
        int result = 39354;

        int answer1 = p340212.solution1(diffs, times, limit);
        int answer2 = p340212.solution2(diffs, times, limit);

        Assertions.assertEquals(result, answer1);
        System.out.println("answer1 = " + answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer2 = " + answer2);
    }
}