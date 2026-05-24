package main.java.coding.reference;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 너비 우선 탐색 (BFS - Breadth-First Search)
 * - 시작점에서 가까운 곳부터 물결(동심원)처럼 일제히 퍼져나가며 탐색하는 알고리즘
 * - 처음 목적지를 발견한 순간이 곧 '최단 거리'임을 보장\
 * ex) 최단 거리 구하기, 최소 이동 횟수(미로 탈출), 전염병/바이러스 확산, 토마토 익히기, 주변 노드 탐색
 */
public class 너비우선탐색_BFS {

    /**
     * ==================
     * 2D (격자/지도) BFS
     * ==================
     */
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 격자의 크기 (세로 N, 가로 M)
    public static int N;
    public static int M;
    public static int[][] map;  // 2차원 배열
    public static boolean[][] visited2D;  // 방문

    // (최단거리 구하기) 최단 거리 기록용 배열
    public static int[][] distance2D;

    // 기본적인 BFS
    public void bfs2D(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 큐에 삽입 및 방문 처리
        queue.offer(new int[]{startX, startY});
        visited2D[startX][startY] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 현재 위치에서 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 격자 범위를 벗어났는지 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 이미 방문했거나, 갈 수 없는 곳(예: 벽)인지 체크 (조건은 문제에 따라 다름)
                if (visited2D[nx][ny] || map[nx][ny] == 0) continue;

                // 다음 갈 곳을 큐에 삽입 (방문 처리)
                queue.offer(new int[]{nx, ny});
                visited2D[nx][ny] = true;
            }
        }
    }

    // 특정 목적지까지의 최단 거리 BFS
    public int bfsShort2D(int startX, int startY, int destX, int destY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX, startY});
        visited2D[startX][startY] = true;

        // (최단거리 구하기) 거리 배열 초기화
        distance2D = new int[N][M];
        distance2D[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // (최단거리 구하기) 도착점 도달 체크
            if (cx == destX && cy == destY) {
                return distance2D[cx][cy];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited2D[nx][ny] || map[nx][ny] == 0) continue;

                queue.offer(new int[]{nx, ny});
                visited2D[nx][ny] = true;

                // (최단거리 구하기) 다음 칸의 거리 = 현재 칸까지의 거리 + 1
                distance2D[nx][ny] = distance2D[cx][cy] + 1;
            }
        }

        // (최단거리 구하기) 목적지 찾지 못하면 못가는 길
        return -1;
    }


    /**
     * ==================
     * 트리 / 그래프 BFS
     * ==================
     */
    public static List<List<Integer>> graph;  // 인접 리스트
    public static boolean[] visitedGraph;  // 방문

    // (최단거리 구하기) 최단 거리 기록용 배열
    public static int[] distanceGraph;

    // 기본적인 BFS
    public static void bfsGraph(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드 큐에 삽입 및 방문처리
        queue.offer(start);
        visitedGraph[start] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // 현재 노드와 연결된 모든 인접 노드 탐색
            for (int next : graph.get(curr)) {
                // 방문하지 않은 노드만 큐에 삽입
                if (!visitedGraph[next]) {
                    queue.offer(next);
                    visitedGraph[next] = true;  // 방문 처리
                }
            }
        }
    }

    // 특정 목적지까지의 최단 거리 BFS
    public static int bfsShortGraph(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visitedGraph[start] = true;

        // (최단거리 구하기) 거리 배열 초기화
        distanceGraph = new int[visitedGraph.length];
        distanceGraph[start] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // (최단거리 구하기) 도착점 도달 체크
            if (curr == dest) {
                return distanceGraph[curr];
            }

            for (int next : graph.get(curr)) {
                if (!visitedGraph[next]) {
                    queue.offer(next);
                    visitedGraph[next] = true;

                    // (최단거리 구하기) 다음 칸의 거리 = 현재 칸까지의 거리 + 1
                    distanceGraph[next] = distanceGraph[curr] + 1;
                }
            }
        }

        // (최단거리 구하기) 목적지 찾지 못하면 못가는 길
        return -1;
    }
}