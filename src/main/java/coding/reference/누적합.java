package main.java.coding.reference;

/**
 * 누적합 (Prefix Sum / Partial Sum)
 * - 배열의 특정 구간 합을 매번 처음부터 더하지 않고, 미리 구해둔 누적된 합을 이용해 O(1)만에 빠르게 구하는 기법
 * - 특정 구간의 합을 여러 번 빈번하게 구해야 할 때 시간 초과(Time Out)를 방지
 * ex) 특정 구간 [L, R]의 데이터 합계 구하기, 연속된 부분 배열의 최대/최소합, 2차원 배열(보드)의 특정 영역 합
 */
public class 누적합 {

    public int prefixSum(int[] arr, int left, int right) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        return prefix[right + 1] - prefix[left];
    }
}