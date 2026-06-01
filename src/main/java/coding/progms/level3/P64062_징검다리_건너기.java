package main.java.coding.progms.level3;

public class P64062_징검다리_건너기 {

    public int solution(int[] stones, int k) {
        long result = -1;
        long left = 1;  // 시작값
        long right = 0;  // 끝값

        // 최대값(right) 탐색 및 세팅
        for (int s : stones) {
            if (s > right) right = s;
        }

        // 몇명의 인원까지 수용이 가능한지 이진 탐색으로 찾기
        while (left <= right) {
            // 중간 값 설정
            long mid = left + (right - left) / 2;

            // 건널 수 있는지 검사
            if (isValid(stones, mid, k)) {
                result = mid;  // 현재 중간 값 result 세팅
                left = mid + 1;  // 시작값(start) 중간으로 설정
            }
            else {
                right = mid - 1;  // 끝값(left) 중간으로 설정
            }
        }

        // long -> int로 변환
        return Math.toIntExact(result);
    }

    // 현재 인원으로 건널 수 있는지 확인하는 메소드
    private boolean isValid(int[] stones, long mid, long k) {
        // k칸까지 뛸 수 있음 = 밟을 수 있는 돌의 life가 k개 있음
        long life = k;

        for (int stone : stones) {
            // 인원수만큼 돌이 수용하지 못하면 life -1
            if (stone < mid) life--;
            // 인원수만큼 돌이 수용가능하면 life k값으로 초기화
            else life = k;

            // life가 0이 되었다면 현재 인원으로는 건널 수 없다는 의미
            if (life == 0) return false;
        }

        // 위의 for문을 통과했다면 현재 인원으로 통과할 수 있음
        return true;
    }
}
