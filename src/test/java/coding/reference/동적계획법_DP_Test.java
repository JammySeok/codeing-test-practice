package test.java.coding.reference;

import main.java.coding.reference.동적계획법_DP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class 동적계획법_DP_Test {

    동적계획법_DP ref = new 동적계획법_DP();

    @Test
    void 테스트1_fibonacci() {
        // Given: 피보나치 수열의 6번째 숫자는 8 (0, 1, 1, 2, 3, 5, 8)
        int n = 6;
        int result = 8;

        // When
        int answer = ref.fibonacci(n);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트1_minCostStairs() {
        // Given: 각 계단을 밟을 때 발생하는 비용
        int[] cost = {10, 15, 20, 5};
        int result = 20;

        // When
        int answer = ref.minCostStairs(cost);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트1_gridPath() {
        // Given: 3행 3열 크기의 격자 맵 구조
        int m = 3;
        int n = 3;
        int result = 6;

        // When
        int answer = ref.gridPath(m, n);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트1_coinChange() {
        // Given
        int[] coins = {1, 3, 4};
        int amount = 6;
        int result = 2;

        // When
        int answer = ref.coinChange(coins, amount);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2_coinChange() {
        // Given: 2원짜리 동전만 가지고 9원을 만들어야 하는 상황
        int[] coins = {2};
        int amount = 9;
        int result = -1;

        // When
        int answer = ref.coinChange(coins, amount);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}