package main.java.coding.reference;

import java.util.List;

/**
 * 깊이 우선 탐색 (DFS - Depth-First Search)
 * - 갈림길에서 한 우물만 끝까지 파고들었다가 막히면 돌아와서 다른 길을 가는 알고리즘
 * - 최단 거리를 보장하지 않지만, 경로의 특징이나 모든 경우의 수를 파악하는 데 유리함
 * ex) 목적지 도달 가능 여부(경로 존재 여부), 모든 경우의 수 탐색(순열/조합/백트래킹), 특정 조건을 만족하는 경로 찾기, 사이클 검사
 */
public class 깊이우선탐색_DFS {

    /**
     * ==================
     * 2D (격자/지도) DFS
     * ==================
     */
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 격자의 크기 (세로 N, 가로 M)
    public static int N;
    public static int M;
    public static int[][] map;  // 2차원 배열
    public static boolean[][] visited2D;  // 방문

    // 기본적인 DFS (연결된 모든 구역 방문)
    public void dfs2D(int cx, int cy) {
        // 현재 위치 방문 처리
        visited2D[cx][cy] = true;

        // 현재 위치에서 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            // 격자 범위를 벗어났는지 체크
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            // 이미 방문했거나, 갈 수 없는 곳(예: 벽)인지 체크
            if (visited2D[nx][ny] || map[nx][ny] == 0) continue;

            // 조건에 맞으면 재귀적으로 깊이 탐색
            dfs2D(nx, ny);
        }
    }

    // 특정 목적지 도달 가능 여부를 확인하는 DFS
    public boolean dfsTarget2D(int cx, int cy, int destX, int destY) {
        // (목적지 도달 체크) 현재 위치가 목적지라면 true 반환
        if (cx == destX && cy == destY) {
            return true;
        }

        visited2D[cx][cy] = true;

        // 현재 위치에서 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited2D[nx][ny] || map[nx][ny] == 0) continue;

            // (목적지 탐색) 다음 길로 깊이 들어갔을 때 목적지를 찾았다면, 즉시 true 반환하며 탈출
            if (dfsTarget2D(nx, ny, destX, destY)) {
                return true;
            }
        }

        // 모든 방향을 다 뒤져도 목적지가 없다면 false 반환
        return false;
    }


    /**
     * ==================
     * 트리 / 그래프 DFS
     * ==================
     */
    public static List<List<Integer>> graph;  // 인접 리스트
    public static boolean[] visitedGraph;  // 방문

    // 기본적인 DFS (연결된 모든 노드 방문)
    public static void dfsGraph(int curr) {
        // 현재 노드 방문 처리
        visitedGraph[curr] = true;

        // 현재 노드와 연결된 모든 인접 노드 탐색
        for (int next : graph.get(curr)) {
            // 방문하지 않은 노드만 재귀적으로 탐색
            if (!visitedGraph[next]) {
                dfsGraph(next);
            }
        }
    }

    // 특정 목적지 도달 가능 여부를 확인하는 DFS
    public static boolean dfsTargetGraph(int curr, int dest) {
        // (목적지 도달 체크)
        if (curr == dest) {
            return true;
        }

        visitedGraph[curr] = true;

        // 현재 노드와 연결된 모든 인접 노드 탐색
        for (int next : graph.get(curr)) {
            if (!visitedGraph[next]) {
                // (목적지 탐색) 연결된 노드를 파고들어서 목적지를 찾았다면 즉시 true 반환
                if (dfsTargetGraph(next, dest)) {
                    return true;
                }
            }
        }

        // 끝까지 파고들어도 목적지가 없다면 false 반환
        return false;
    }
}