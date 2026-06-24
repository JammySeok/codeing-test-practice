package main.java.coding.progms.level2;

import java.util.PriorityQueue;

public class P181188_요격_시스템 {

/*
    입력: {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}
    미사일 정렬 (최대값 기준)
     ```
        1 2 3 4
              4 5
            3 4 5 6 7
              4 5 6 7 8
                5 6 7 8 9 10 11 12
                             11 12 13
                          10 11 12 13 14
    ```
    시나리오
    1) 1~4 미사일 체크 -> 끝(3~4) 부분 요격 (1~4, 3~7 삭제), result+1
    2) 4~5 미사일 체크 -> 끝(4~5) 부분 요격 (4~5, 4~8 삭제), result+1
    3) 5~12 미사일 체크 -> 끝(11~12) 부분 요격 (5~12, 11~13, 10~14 삭제), result+1
    4) 미사일 없음 -> return result;
*/
    public int solution(int[][] targets) {
        int result = 0;

        // PriorityQueue에 미사일 정보 집어넣기 (최대값 기준 내림차순 정렬)
        PriorityQueue<int[]> missiles = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int[] target : targets) {
            missiles.add(target);
        }

        // 요격시점 -1 로 초기화
        double attack = -1;
        // 미사일 전부 요격 될 동안 반복
        while(!missiles.isEmpty()) {
            // 맨 앞 미사일 꺼내기
            int[] missile = missiles.poll();

            if (missile[0] >= attack) {
                // 미사일 요격 후 마지막 요격시점 세팅
                attack = missile[1] - 0.5;
                result++;
            }
        }

        return result;
    }
}
