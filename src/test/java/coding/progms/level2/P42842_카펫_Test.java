package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P42842_카펫;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class P42842_카펫_Test {

    P42842_카펫 p42842 = new P42842_카펫();

    @Test
    void 테스트1() {
        int brown = 10;
        int yellow = 2;
        int[] result = {4, 3};

        int[] answer1 = p42842.solution1(brown, yellow);
        int[] answer2 = p42842.solution2(brown, yellow);

        Assertions.assertArrayEquals(result, answer1);
        Assertions.assertArrayEquals(result, answer2);
        System.out.println("answer = " + Arrays.toString(answer1));
        System.out.println("answer = " + Arrays.toString(answer2));
    }

    @Test
    void 테스트2() {
        int brown = 8;
        int yellow = 1;
        int[] result = {3, 3};

        int[] answer1 = p42842.solution1(brown, yellow);
        int[] answer2 = p42842.solution2(brown, yellow);

        Assertions.assertArrayEquals(result, answer1);
        Assertions.assertArrayEquals(result, answer2);
        System.out.println("answer = " + Arrays.toString(answer1));
        System.out.println("answer = " + Arrays.toString(answer2));
    }

    @Test
    void 테스트3() {
        int brown = 24;
        int yellow = 24;
        int[] result = {8, 6};

        int[] answer1 = p42842.solution1(brown, yellow);
        int[] answer2 = p42842.solution2(brown, yellow);

        Assertions.assertArrayEquals(result, answer1);
        Assertions.assertArrayEquals(result, answer2);
        System.out.println("answer = " + Arrays.toString(answer1));
        System.out.println("answer = " + Arrays.toString(answer2));
    }
}