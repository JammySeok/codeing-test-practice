package main.java.coding.progms.level2;

public class P340212_퍼즐_게임_챌린지 {

    // 내가 푼 방법 (시간초과)
    public int solution1(int[] diffs, int[] times, long limit) {
        int answer = 1;  // 숙련도

        long initLimit = limit;  // 처음 제공된 시간
        int curStage = 0;  // 현재 스테이지

        while (curStage <= diffs.length - 1) {
            if (diffs[curStage] > answer) {
                long count = diffs[curStage] - answer;  // 틀린 횟수
                long penalty = times[curStage] + times[curStage - 1];  // 한번 틀릴 때 소모되는 시간
                limit -= count * penalty;
            }
            // 문제 해결
            limit -= times[curStage];
            curStage++;

            // 만약 stage를 시간안에 해결하지 못했다면?
            if (limit < 0) {
                answer++;  // 숙련도 증가
                // stage하고 limit 초기화
                curStage = 0;
                limit= initLimit;
            }
        }

        return answer;
    }

    // 시간 초과 해결 (파라메트릭 서치)
    public int solution2(int[] diffs, int[] times, long limit) {
        long result = -1;

        long left = 1;
        long right = 0;

        // 최대값 설정 (가장 어려운 난이도)
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (solveQuiz(diffs, times, limit, mid)) {
                result = mid;  // 조건을 만족하므로 일단 정답 후보로 저장
                right = mid - 1;  // 조건을 만족하지 못하므로 값을 줄이기 위해 끝 값(right)을 왼쪽으로 이동
            }
            else {
                left = mid + 1;  // 더 큰 최댓값이 존재할 수 있으므로 시작 값(left)을 오른쪽으로 이동
            }
        }

        return (int)result;
    }

    private boolean solveQuiz(int[] diffs, int[] times, long limit, long target) {
        int curStage = 0;  // 현재 스테이지

        while (curStage <= diffs.length - 1) {
            if (diffs[curStage] > target) {
                long count = diffs[curStage] - target;  // 틀린 횟수
                long penalty = times[curStage] + times[curStage - 1];  // 한번 틀릴 때 소모되는 시간
                limit -= count * penalty;
            }
            // 문제 해결
            limit -= times[curStage];
            curStage++;

            // 만약 stage를 시간안에 해결하지 못했다면?
            if (limit < 0) {
                return false;
            }
        }

        return true;
    }
}
