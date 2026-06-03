package main.java.coding.reference;

import java.util.Arrays;

/**
 * 투 포인터 (Two Pointers)
 * - 배열이나 리스트에서 두 개의 인덱스 변수(포인터)를 사용하여 조건에 맞는 구간이나 데이터 쌍을 효율적으로 찾아내는 알고리즘 기법
 * - 완전 탐색 시 O(N^2)이 걸리는 문제를 불필요한 중복 계산을 건너뛰어 O(N)으로 최적화
 * * ex) 연속된 수열의 구간합 계산, 정렬된 배열에서 특정 합을 가지는 원소 쌍 찾기, 문자열 내 특정 패턴/알파벳 개수 매칭(슬라이딩 윈도우), 팰린드롬(좌우 대칭) 판별
 */
public class 투_포인터 {

    // 두 수의 합 찾기
    public boolean hasTwoSum(int[] nums, int target) {
        // 오름차순 정렬이 되어있어야 함
        Arrays.sort(nums);

        int left = 0;  // 왼쪽(작은 값)
        int right = nums.length - 1;  // 오른쪽(큰 값)

        while (left < right) {
            // 현재 합 (작은 값 + 큰 값)
            int currentSum = nums[left] + nums[right];

            if (currentSum == target) return true;  // 합이 목표값과 같으면 true 반환
            else if (currentSum < target) left++;  // 합이 작으면 left(작은 값)를 키움
            else right--;  // 합이 크면 right(큰 값)를 줄임
        }

        // 전부 돌았는데 없으면 false 반환
        return false;
    }

    // 고정 크기 슬라이딩 윈도우 (크기가 k로 고정된 구간합의 최대값)
    public int fixedSizeWindow(int[] nums, int k) {
        int currentSum = 0;  // 현재 합
        int maxSum;  // 최대 합

        // 처음 k개 원소의 합(초기 창문) 구하기
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        maxSum = currentSum;  // 초기 창문의 합을 최대합으로 설정

        // 창문을 한 칸씩 오른쪽으로 밀면서 이동 (right 포인터가 전진)
        for (int right = k; right < nums.length; right++) {
            // 새로 들어오는 값(nums[right])은 더하고, 나가는 값(nums[right - k])은 빼기
            currentSum += nums[right] - nums[right - k];
            // 현재 창문의 합과 기존 최대합을 비교하여 갱신
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    // 유동 크기 슬라이딩 윈도우 (구간합이 target 이상이 되는 최소 구간 길이)
    public int variableSizeWindow(int[] nums, int target) {
        int left = 0;  // 구간의 시작
        int currentSum = 0;  // 현재 합
        int minLength = Integer.MAX_VALUE;  // 최소 길이를 찾기 위해 큰 값으로 초기화

        // right 포인터를 한 칸씩 확장
        for (int right = 0; right < nums.length; right++) {
            // 새로운 값을 구간 합에 추가
            currentSum += nums[right];

            // 구간 합이 target 이상이면 구간을 최대한 축소
            while (currentSum >= target) {
                // 현재 만족하는 구간의 길이(right - left + 1)를 계산하여 최소 길이 갱신
                minLength = Math.min(minLength, right - left + 1);

                // 구간을 줄이기 위해 가장 왼쪽 값을 합에서 제외한 후, left 포인터를 오른쪽으로 전진
                currentSum -= nums[left];
                left++;
            }
        }

        // target을 만족하는 구간을 찾지 못했다면 0 반환, 찾았다면 최소 길이 반환
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}