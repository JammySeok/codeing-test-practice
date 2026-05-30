package test.java.coding.reference;

import main.java.coding.reference.이진_탐색;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class 이진_탐색_Test {

    이진_탐색 ref = new 이진_탐색();

    @Test
    void 테스트1_binarySearch() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target1 = 7;
        int target2 = 6;
        int result1 = 3;
        int result2 = -1;

        int answer1 = ref.binarySearch(arr, target1);
        int answer2 = ref.binarySearch(arr, target2);

        Assertions.assertEquals(result1, answer1);
        Assertions.assertEquals(result2, answer2);

        System.out.println("기본 탐색 성공 (target 7) -> answer: " + answer1);
        System.out.println("기본 탐색 실패 (target 6) -> answer: " + answer2);
    }

    @Test
    void 테스트1_lower_upper() {
        int[] arr = {1, 3, 3, 3, 5, 7, 7, 8, 10};
        int target = 3;
        int result1 = 1;
        int result2 = 4;

        int answerLower = ref.lowerBound(arr, target);
        int answerUpper = ref.upperBound(arr, target);

        Assertions.assertEquals(result1, answerLower);
        Assertions.assertEquals(result2, answerUpper);

        System.out.println("Lower Bound (target 3) -> answer: " + answerLower);
        System.out.println("Upper Bound (target 3) -> answer: " + answerUpper);
    }

    @Test
    void 테스트2_lower_upper() {
        int[] arr = {1, 3, 5, 7};
        int target = 10;
        int result = 4;

        int answerLower = ref.lowerBound(arr, target);
        int answerUpper = ref.upperBound(arr, target);

        Assertions.assertEquals(result, answerLower);
        Assertions.assertEquals(result, answerUpper);

        System.out.println("범위 초과시 Lower Bound -> answer: " + answerLower);
        System.out.println("범위 초과시 Upper Bound -> answer: " + answerUpper);
    }

    @Test
    void 테스트1_parametricSearch() {
        int[] arr = {802, 743, 457, 539};
        long target = 11;
        long result = 200;

        long answer = ref.parametricSearch(arr, target);

        Assertions.assertEquals(result, answer);
        System.out.println("파라메트릭 서치 최댓값 결과 -> answer: " + answer);
    }
}