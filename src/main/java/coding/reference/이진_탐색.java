package main.java.coding.reference;

public class 이진_탐색 {

    /**
     * 기본 이진 탐색
     * - 배열에 정확히 target과 일치하는 값이 있으면 해당 인덱스 반환
     * - 없으면 -1 반환
     */
    public int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 하한선 탐색 (Lower Bound)
     * - target '이상'의 값이 처음으로 나타나는 인덱스 반환
     * - 만약 배열의 모든 원소가 target보다 작다면 arr.length 반환
     */
    public int lowerBound(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 상한선 탐색 (Upper Bound)
     * - target을 '초과'하는 값이 처음으로 나타나는 인덱스 반환
     * - 만약 배열의 모든 원소가 target 이하 시 arr.length 반환
     */
    public int upperBound(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 파라메트릭 서치 (Parametric Search) 기본 템플릿
     * - 최적화 문제(최솟값/최댓값 구하기)를 결정 문제(T/F)로 바꾸어 풀 때 사용
     */
    public int parametricSearch(int[] arr, long target) {
        long result = -1;
        long left = 1;
        long right = 0;

        // 문제 조건에 따른 최댓값 탐색 (필요 시 상수로 대체 가능)
        for (int val : arr) {
            if (val > right) right = val;
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isValid(arr, mid, target)) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return Math.toIntExact(result);
    }

    // 파라메트릭 서치용 조건 검증 메서드 (문제 따라 다름)
    private boolean isValid(int[] arr, long mid, long target) {
        // ex. 랜선 자르기

        if (mid == 0) return true;
        long count = 0;

        for (int val : arr) {
            count += (val / mid);
        }

        return count >= target;
    }
}