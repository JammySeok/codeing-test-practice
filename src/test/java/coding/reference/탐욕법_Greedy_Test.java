package test.java.coding.reference;

import main.java.coding.reference.탐욕법_Greedy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class 탐욕법_Greedy_Test {

    탐욕법_Greedy ref = new 탐욕법_Greedy();

    @Test
    void 테스트1_coinChange() {
        // Given: 동전 단위가 서로 배수 관계
        int[] coins = {10, 50, 100, 500};
        int amount = 1260;
        // 500원 2개 + 100원 2개 + 50원 1개 + 10원 1개
        int result = 6;

        // When
        int answer = ref.coinChange(amount, coins);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트1_activitySelection() {
        // Given
        int[][] meetings = {
                {1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}
        };
        // (1, 4) 선택 -> (5, 7) 선택 -> (8, 11) 선택
        int result = 3;

        // When
        int answer = ref.activitySelection(meetings);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3_twoPointer() {
        // Given
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result = 3;

        // When
        int answer = ref.twoPointer(people, limit);

        // Then
        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}