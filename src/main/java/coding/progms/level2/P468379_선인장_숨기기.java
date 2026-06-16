package main.java.coding.progms.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P468379_선인장_숨기기 {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        // 격자판 초기화 (비가 안 오는 곳은 무한대로 설정)
        int INF = Integer.MAX_VALUE;
        int[][] desert = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(desert[i], INF);
        }

        int time = 1;
        for (int[] drop : drops) {
            int y = drop[0];
            int x = drop[1];

            // 같은 칸에 비가 또 왔다면 가장 먼저 온 시간 (INF 일때만 동작)
            if (desert[y][x] == INF) desert[y][x] = time;
            time++;
        }

        // 가로(행) 방향 슬라이딩 윈도우 (크기 W짜리 창문)
        // 각 행마다 너비 W 구간의 최솟값(비를 맞는 시간)을 찾기
        int[][] rowMin = new int[m][n - w + 1];

        for (int i = 0; i < m; i++) {
            // 배열의 인덱스(j)를 저장
            Deque<Integer> deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                // 만료된 인덱스 제거
                if (!deque.isEmpty() && deque.peekFirst() <= j - w) {
                    deque.pollFirst();
                }

                // 최솟값을 맨 앞으로 보내기
                // 현재 값보다 크거나 같은 이전 값들은 필요없는 값 이므로 뒤에서 제거
                while (!deque.isEmpty() && desert[i][deque.peekLast()] >= desert[i][j]) {
                    deque.pollLast();
                }

                deque.offerLast(j);

                // 창문이 차면 최솟값 저장
                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = desert[i][deque.peekFirst()];
                }
            }
        }

        // 세로(열) 방향 슬라이딩 윈도우 (크기 H짜리 창문)
        // rowMin을 가지고, 열을 따라 내려감
        int[][] finalMin = new int[m - h + 1][n - w + 1];
        for (int j = 0; j < n - w + 1; j++) {
            Deque<Integer> deque = new ArrayDeque<>();

            // 행(i)을 내려가며 탐색
            for (int i = 0; i < m; i++) {
                // 만료된 인덱스 제거
                if (!deque.isEmpty() && deque.peekFirst() <= i - h) {
                    deque.pollFirst();
                }

                // 최솟값 찾기
                while (!deque.isEmpty() && rowMin[deque.peekLast()][j] >= rowMin[i][j]) {
                    deque.pollLast();
                }

                deque.offerLast(i);

                // 창문이 차면 최종 배열에 저장
                if (i >= h - 1) {
                    finalMin[i - h + 1][j] = rowMin[deque.peekFirst()][j];
                }
            }
        }

        // 정답 찾기
        int bestTime = -1;
        int ansY = -1;
        int ansX = -1;
        // 왼쪽 위 부터 탐색
        for (int i = 0; i < m - h + 1; i++) {
            for (int j = 0; j < n - w + 1; j++) {
                // 현재 영역이 비를 맞는 시간
                int currentTime = finalMin[i][j];

                // bestTime와 currentTime 비교해서 가장 큰 값으로 갱신
                if (currentTime > bestTime) {
                    bestTime = currentTime;
                    ansY = i;
                    ansX = j;
                }
            }
        }

        // 정답 좌표 반환
        return new int[]{ansY, ansX};
    }
}
