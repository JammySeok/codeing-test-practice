package test.java.coding.reference;

import main.java.coding.reference.누적합;
import org.junit.jupiter.api.Test;

class 누적합_Test {

    누적합 ref = new 누적합();

    @Test
    void 테스트1() {
        int[] arr = {1, 2, 3, 4, 5};
        int left = 1;
        int right = 3;

        int answer = ref.prefixSum(arr, left, right);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int[] arr = {10, 20, 30, 40};
        int left = 0;
        int right = 2;

        int answer = ref.prefixSum(arr, left, right);

        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        int[] arr = {5, 8, 12, 15};
        int left = 2;
        int right = 2;

        int answer = ref.prefixSum(arr, left, right);

        System.out.println("answer = " + answer);
    }
}