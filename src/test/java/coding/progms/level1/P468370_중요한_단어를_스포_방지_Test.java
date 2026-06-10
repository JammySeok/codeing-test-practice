package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P468370_중요한_단어를_스포_방지;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P468370_중요한_단어를_스포_방지_Test {

    P468370_중요한_단어를_스포_방지 p468370 = new P468370_중요한_단어를_스포_방지();

    @Test
    void 테스트1() {
        String message = "here is muzi here is a secret message";
        int[][] spoiler_ranges = {
                {0, 3}, {23, 28}
        };
        int result = 1;

        int answer1 = p468370.solution1(message, spoiler_ranges);
        int answer2 = p468370.solution2(message, spoiler_ranges);

        Assertions.assertEquals(result, answer1);
        System.out.println("answer1 = " + answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer2 = " + answer2);
    }

    @Test
    void 테스트2() {
        String message = "my phone number is 01012345678 and may i have your phone number";
        int[][] spoiler_ranges = {
                {5, 5}, {25, 28}, {34, 40}, {53, 59}
        };
        int result = 4;

        int answer1 = p468370.solution1(message, spoiler_ranges);
        int answer2 = p468370.solution2(message, spoiler_ranges);

        Assertions.assertEquals(result, answer1);
        System.out.println("answer1 = " + answer1);
        Assertions.assertEquals(result, answer2);
        System.out.println("answer2 = " + answer2);
    }
}