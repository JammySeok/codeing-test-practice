package main.java.coding.progms.level2;

import java.util.LinkedList;

public class P1844_게임_맵_최단거리 {

    public int solution(int[][] maps) {
        // 방향
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // map 크기
        int N = maps.length;  // 세로 크기 (행의 개수)
        int M = maps[0].length;  // 가로 크기 (열의 개수)

        // 방문 했는지?
        boolean[][] visited = new boolean[N][M];
        // 거리 기록
        int[][] distance = new int[N][M];

        // 인접 리스트
        LinkedList<int[]> que = new LinkedList<>();

        // 현재 위치
        que.offer(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 1;

        while(!que.isEmpty()) {
            // 현재 좌표 설정
            int[] current = que.poll();
            int curX = current[0];
            int curY = current[1];

            for(int i = 0; i < 4; i++) {
                // 십자가 모양으로 갈 수 있는지 체크
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 끝(N, M)에 도달하는지 체크 후 있으면 거리 return
                if(curX == N-1 && curY == M-1) return distance[curX][curY];

                // 범위를 벗어나면 pass
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                // 방문했거나 장애물(0) 이면 pass
                if(visited[nextX][nextY] || maps[nextX][nextY] == 0) continue;

                // 여기까지 왔다면 올바른 길
                que.offer(new int[]{nextX, nextY});  // 다음 갈 길 queue에 저장
                visited[nextX][nextY] = true;  // 방문함
                distance[nextX][nextY] = distance[curX][curY] + 1;  // 다음 거리 = 현재 거리 + 1
            }
        }

        // 도착 못하면 -1
        return -1;
    }
}
