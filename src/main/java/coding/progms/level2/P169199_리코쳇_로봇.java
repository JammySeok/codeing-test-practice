package main.java.coding.progms.level2;

import java.util.ArrayDeque;

public class P169199_리코쳇_로봇 {

    // 상, 하, 좌, 우 순서
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int solution(String[] board) {
        int N = board.length;  // y 좌표 크기
        int M = board[0].length();  // x 좌표 크기

        // 시작 위치(X, Y) 설정
        int startX = 0, startY = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (board[y].charAt(x) == 'R') {
                    startX = x;
                    startY = y;
                    break;
                }
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();  // 인접 리스트
        boolean[][] visit = new boolean[N][M];  // 방문 했는지
        int[][] move = new int[N][M];  // 얼마나 이동 했는지

        // 시작값 넣기
        queue.offer(new int[]{startX, startY});
        visit[startY][startX] = true;
        move[startY][startX] = 0;

        // queue 빌 때까지
        while (!queue.isEmpty()) {
            // 하나 빼고 x, y 좌표 설정
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            // 현재 위치 'G'이면 이동한 개수 return
            if (board[curY].charAt(curX) == 'G') return move[curY][curX];

            // 4방향 이동
            for (int i = 0; i < 4; i++) {
                // 다음 이동할 좌표
                int nx = curX;
                int ny = curY;

                // 미끄러지기
                while (true) {
                    int nextX = nx + dx[i];
                    int nextY = ny + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) break;  // 다음 벽이면
                    if (board[nextY].charAt(nextX) == 'D') break;  // 다음 'D'이면

                    // 아니면 계속 진행
                    nx = nextX;
                    ny = nextY;
                }

                // 이동했는데 그전하고 같으면(벽이나 장애물에 박았으면)
                if (nx == curX && ny == curY) continue;
                // 방문했었던 곳이면
                if (visit[ny][nx]) continue;

                // queue에 넣고 방문처리
                queue.offer(new int[]{nx, ny});
                visit[ny][nx] = true;
                move[ny][nx] = move[curY][curX] + 1;
            }
        }

        return -1;
    }
}