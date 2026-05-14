package main.java.coding.reference;

public class 누적합 {

    public int solution(int[] arr, int left, int right) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        return prefix[right + 1] - prefix[left];
    }
}
