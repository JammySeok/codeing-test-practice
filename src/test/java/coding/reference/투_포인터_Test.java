package test.java.coding.reference;

import main.java.coding.reference.투_포인터;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class 투_포인터_Test {

    투_포인터 ref = new 투_포인터();

    @Test
    void 테스트1_hasTwoSum() {
        // 합이 9가 되는 쌍(2, 7)이 존재하는 경우
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        boolean result = true;

        boolean answer = ref.hasTwoSum(nums, target);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2_hasTwoSum() {
        // 합이 10이 되는 쌍이 존재하지 않는 경우
        int[] nums = {1, 2, 3, 5};
        int target = 10;
        boolean result = false;

        boolean answer = ref.hasTwoSum(nums, target);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트1_fixedSizeWindow() {
        // 일반적인 배열에서 3개 원소의 최대합
        int[] nums = {2, 1, 3, 2, 5, 1};
        int k = 3;
        int result = 10;

        int answer = ref.fixedSizeWindow(nums, k);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2_fixedSizeWindow() {
        // 전체 배열 크기와 k가 같을 때
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        int result = 15;

        int answer = ref.fixedSizeWindow(nums, k);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트1_variableSizeWindow() {
        // 합이 7 이상이 되는 가장 짧은 구간
        int[] nums = {2, 3, 1, 2, 4, 3, 5};
        int target = 7;
        int result = 2;

        int answer = ref.variableSizeWindow(nums, target);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2_variableSizeWindow() {
        // 배열의 전체를 다 더해도 target에 도달하지 못하는 경우
        int[] nums = {1, 2, 4};
        int target = 8;
        int result = 0;

        int answer = ref.variableSizeWindow(nums, target);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}