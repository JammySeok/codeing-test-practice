package main.java.coding.reference;

/**
 * 이진 탐색 (Binary Search) 및 응용
 * - 반드시 '정렬된' 데이터를 대상으로, 탐색 범위를 절반씩 줄여가며 원하는 값을 O(log N)만에 빠르게 찾아내는 알고리즘
 * - 기본 탐색 외에도 경계값 찾기(Lower/Upper Bound)와 최적화 문제를 결정 문제로 바꾸는 기법(Parametric Search)으로 확장됨
 * ex) 특정 데이터의 빠른 검색, 특정 범위 내 원소 개수 세기, 랜선 자르기/입국심사 등 최대/최솟값 최적화 문제
 */
public class 이진_탐색 {

    /**
     * 기본 이진 탐색
     * - 배열에서 target과 '정확히 일치하는' 값의 인덱스 중 아무거나 하나를 반환
     * - 중복 값이 있을 때 어떤 인덱스가 걸릴지 예측할 수 없고, target이 없으면 -1을 반환
     * - ex1. [2, 3, 4, 4, 5, ...]이고 찾는값이 4면, 2 혹은 3을 반환 (4 위치 중 하나)
     * - ex2. [2, 3, 4, 7, 9, ...]이고 찾는값이 5면, -1 반환
     */
    public int binarySearch(int[] arr, int target) {
        // 올바른 배열인지 체크
        if (arr == null || arr.length == 0) return -1;

        int left = 0;  // 시작 값
        int right = arr.length - 1;  // 끝 값

        // 시작 - 끝 목표 값(targetScore) 비교하면서 절반 씩 줄이기
        while (left <= right) {
            // 중간 값 설정 - 'mid = (left + right) / 2' 와 같은 코드
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;  // target을 찾았다면 찾은 인덱스 반환
            else if (arr[mid] < target) left = mid + 1;  // mid가 target보다 작으면 시작 값(left)을 중간(mid + 1)으로
            else right = mid - 1;  // mid가 target보다 크거면 끝값(right)을 중간(mid - 1)으로
        }

        // 찾은 값이 없다면 -1 반환
        return -1;
    }

    /**
     * 하한선 탐색 (Lower Bound)
     * - target '이상'의 값이 처음으로 나타나는 인덱스 반환
     * - 중복 값이 있을 때 중복값 중 처음으로 나온 인덱스 반환
     * - target 값이 없으면 target 보다 큰 값 중 처음으로 나온 인덱스 반환
     * - ex1. [2, 3, 4, 4, 5, ...]이고 찾는값이 4면, 2 반환 (4가 처음 나오는 위치)
     * - ex2. [2, 3, 4, 7, 9, ...]이고 찾는값이 5면, 3 반환 (7이 처음 나오는 위치)
     */
    public int lowerBound(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) left = mid + 1;  // mid가 target보다 작으면 시작 값(left)을 중간(mid + 1)으로
            else right = mid;  // mid가 target보다 크거나 같으면 끝 값(right)을 중간(mid)으로
        }

        // 찾은 값이 없다면 시작 값 반환 (target 보다 큰 값 중 처음으로 나온 인덱스)
        return left;
    }

    /**
     * 상한선 탐색 (Upper Bound)
     * - target을 '초과'하는(target보다 큰) 값이 처음으로 나타나는 인덱스 반환
     * - 중복 값이 있을 때 중복값들의 바로 다음(오른쪽) 인덱스 반환
     * - target 값이 없으면 target 보다 큰 값 중 처음으로 나온 인덱스 반환
     * - ex1. [2, 3, 4, 4, 5, ...]이고 찾는값이 4면, 4 반환 (5가 처음 나오는 위치)
     * - ex2. [2, 3, 4, 7, 9, ...]이고 찾는값이 5면, 3 반환 (7이 처음 나오는 위치)
     */
    public int upperBound(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) left = mid + 1;  // mid가 target보다 작거나 같으면 시작 값(left)을 중간(mid + 1)으로
            else right = mid;  // mid가 target보다 크면 끝 값(right)을 중간(mid)으로
        }

        // 찾은 값이 없다면 시작 값 반환 (target 보다 큰 값 중 처음으로 나온 인덱스)
        return left;
    }

    /**
     * 파라메트릭 서치 (Parametric Search)
     * - 최적화 문제(최댓값/최솟값 구하기)를 결정 문제('조건을 만족하는가? True/False')로 바꾸어 해결하는 기법
     * - 이진 탐색을 이용하여 조건을 만족하는 가장 큰(또는 작은) 정답을 좁혀가며 탐색
     * - 데이터의 범위가 매우 크고, 특정 시점을 기준으로 '만족(True) -> 불만족(False)'으로 상태가 갈릴 때 사용
     */
    public int parametricSearch(int[] arr, long target) {
        long result = -1;
        long left = 1;  // 탐색 가능한 최소 범위
        long right = 0;  // 탐색 가능한 최대 범위

        // 문제 조건에 따른 최댓값 탐색 (배열 내 가장 큰 값을 right로 설정)
        for (int val : arr) {
            if (val > right) right = val;
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;

            // 현재 값(mid)이 문제 조건(target)을 충족하는지 체크
            if (isValid(arr, mid, target)) {
                result = mid;  // 조건을 만족하므로 일단 정답 후보로 저장
                left = mid + 1;  // 더 큰 최댓값이 존재할 수 있으므로 시작 값(left)을 오른쪽으로 이동
            }
            else {
                right = mid - 1;  // 조건을 만족하지 못하므로 값을 줄이기 위해 끝 값(right)을 왼쪽으로 이동
            }
        }

        // 목표 값 반환
        return Math.toIntExact(result);
    }

    // 파라메트릭 서치용 조건 검증 메서드 (문제에 따라 로직이 다름)
    private boolean isValid(int[] arr, long mid, long target) {
        // ex. 랜선 자르기, 나무 자르기

        if (mid == 0) return true;
        long count = 0;

        for (int val : arr) {
            count += (val / mid);
        }

        return count >= target;
    }
}