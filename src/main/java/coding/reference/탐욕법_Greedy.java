package main.java.coding.reference;

import java.util.Arrays;

/**
 * 탐욕법 (Greedy) 접근법
 * - 매 순간 가장 좋아 보이는 것만 선택하여 최적의 해를 구하는 알고리즘
 * - DP처럼 과거의 결과를 누적하지 않고, 한 번 선택한 것은 다시 번복하지 않음
 *
 * [1단계] 최적의 기준 파악 및 정렬하기
 * 생각해야 할 부분: "어떤 순서로 선택해야 가장 효율적일까?"
 * ex) 동전 개수 최소화 -> 가장 큰 단위의 동전부터 내림차순 정렬
 * ex) 회의 최대한 많이 하기 -> 끝나는 시간이 가장 빠른 순으로 오름차순 정렬
 *
 * [2단계] 현재 상태에서 기준에 따라 최선의 선택하기
 * 생각해야 할 부분: "정렬된 순서대로 탐색하며, 조건에 맞으면 무조건 선택(또는 차감)한다."
 *
 * [3단계] 선택 후 남은 문제(상태) 갱신하기
 * 생각해야 할 부분: "선택을 완료했으니, 목표치(남은 금액, 남은 시간, 남은 인원 등)를 줄이자."
 */
public class 탐욕법_Greedy {

    /**
     * [템플릿 1] 단순 정렬 후 차감형 (거스름돈 문제)
     * 예시: 주어진 금액을 최소한의 동전 개수로 거슬러 주기
     * (단, 동전이 1원, 5원, 10원, 50원 처럼 배수로 커져야만 그리디 성립)
     */
    public int coinChange(int amount, int[] coins) {
        int count = 0;

        // [1단계] 정렬: 그리디는 무조건 '가장 큰 것'부터 집어야 하므로 내림차순 탐색이 필요
        // (배열이 오름차순 정렬되어 있다고 가정하고 뒤에서부터 탐색)
        Arrays.sort(coins);

        // [2단계] 최선의 선택: 가장 큰 단위의 동전부터 확인
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];

            // 현재 동전 단위가 남은 금액보다 작거나 같을 때만 사용 가능
            if (amount >= coin) {
                // 해당 동전으로 거슬러 줄 수 있는 최대 개수를 구함
                count += amount / coin;

                // [3단계] 상태 갱신: 동전을 사용하고 남은 나머지 금액으로 목표치 갱신
                amount %= coin;
            }
        }

        return count;
    }

    /**
     * [템플릿 2] 다중 조건 정렬형 (활동 선택 / 회의실 배정)
     * 예시: 하나의 회의실에서 가장 많은 회의를 진행할 수 있는 최대 회의 개수 구하기
     */
    public int activitySelection(int[][] meetings) {
        // [1단계] 정렬: "회의가 빨리 끝나야 다음 회의를 빨리 시작할 수 있다"는 기준 적용
        // 종료 시간을 기준으로 오름차순 정렬하되, 종료 시간이 같다면 시작 시간이 빠른 순으로 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        int currentTime = 0;  // 현재 진행 중인 회의가 끝난 시간 기록

        // [2단계] 최선의 선택: 정렬된 회의들을 순차적으로 탐색
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];

            // 현재 회의의 시작 시간이 이전 회의의 종료 시간과 같거나 크다면 진행 가능
            if (startTime >= currentTime) {
                count++;  // 회의 진행 횟수 증가

                // [3단계] 상태 갱신: 현재 시간을 방금 진행한 회의의 종료 시간으로 갱신
                currentTime = endTime;
            }
        }

        return count;
    }

    /**
     * [템플릿 3] 투 포인터(Two-Pointer) 결합형 (구명보트 문제)
     * 예시: 몸무게 제한(limit)이 있는 보트에 최대 2명씩 탈 때, 구명보트를 최소로 사용하는 횟수
     */
    public int twoPointer(int[] people, int limit) {
        // [1단계] 정렬: 몸무게를 오름차순으로 정렬
        Arrays.sort(people);

        int count = 0;
        int left = 0;  // 가장 가벼운 사람의 인덱스
        int right = people.length - 1;  // 가장 무거운 사람의 인덱스

        // [2단계] 최선의 선택: 가장 무거운 사람과 가장 가벼운 사람을 짝지어 태움
        while (left <= right) {
            // 가벼운 사람 + 무거운 사람의 합이 제한 무게 이하라면 둘 다 태움
            if (people[left] + people[right] <= limit) {
                left++;  // 가벼운 사람 탑승 처리 (포인터 이동)
            }

            // 무거운 사람은 조건이 맞든 안 맞든 무조건 보트 1대를 차지해서 출발
            right--;

            // [3단계] 보트 1대 출발 상태 반영
            count++;
        }

        return count;
    }

    /**
     * [Greedy]
     * - 언제? 정렬 후 "가장 큰/작은 것"부터 골라도 예외(반례)가 없을 때
     * - 특징: 매 순간의 선택이 다음 선택에 영향을 주지 않음
     *
     * [DP]
     * - 언제? 지금 최선의 선택을 하면 나중에 손해나 예외가 발생할 때
     * - 특징: 모든 경우의 수를 누적 계산하며 과거의 기록을 조합해야 함
     */
}