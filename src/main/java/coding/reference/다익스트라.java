package main.java.coding.reference;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 다익스트라 (Dijkstra)
 * - 음의 간선(가중치)이 없을 때, 하나의 시작 노드에서 다른 모든 노드까지의 최단 거리를 구하는 알고리즘
 * - 매 단계마다 방문하지 않은 노드 중 가장 비용이 적은 노드를 선택하는 그리디(Greedy) 기반 알고리즘
 * * ex) 내비게이션 특정 목적지 최단 경로 탐색(조기 종료 응용), 네트워크 라우팅 프로토콜(OSPF), 그래프 내 최소 비용 최적화 문제
 */
public class 다익스트라 {

    // 그래프의 간선 정보 및 격자 좌표를 표현하기 위한 클래스
    public static class Edge implements Comparable<Edge> {
        int nextNode;  // 다음 노드(그래프용)
        int x, y;  // x, y 좌표 (2차원 격자형용)
        int cost;  // 이동 비용(가중치)

        // 그래프용 생성자
        public Edge(int nextNode, int cost) {
            this.nextNode = nextNode;
            this.cost = cost;
        }

        // 2차원 격자용 생성자
        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        // 가중치(비용) 기준 오름차순
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    /**
     * 표준 다익스트라 (그래프)
     * @param v: 노드의 개수
     * @param graph: 그래프
     * @param start: 시작 노드 번호
     */
    public int[] dijkstra(int v, List<List<Edge>> graph, int start) {
        // 최단 거리 테이블 초기화
        int[] dist = new int[v + 1];  // 각 노드까지의 최단 거리를 저장할 배열
        Arrays.fill(dist, Integer.MAX_VALUE);  // 아직 방문하지 않은 곳은 전부 큰 값(Integer.MAX_VALUE)으로 설정

        // 가중치가 가장 작은 간선을 먼저 꺼내기 위한 우선순위 큐
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 시작 간선 설정
        dist[start] = 0;  // 자기 자신으로 가는 거리는 0
        pq.offer(new Edge(start, 0));  // 시작 간선 정보를 큐에 삽입

        while (!pq.isEmpty()) {
            // 현재 비용이 가장 작은 간선을 큐에서 꺼냄
            Edge current = pq.poll();
            int currNode = current.nextNode;  // 현재 방문한 노드 번호
            int currCost = current.cost;  // 현재 칸까지 오는데 걸린 누적 비용

            // 이미 처리된 적이 있는 간선이라면 패스
            if (dist[currNode] < currCost) continue;

            // 현재 노드와 연결된 노드들 확인
            for (Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.nextNode;  // 다음 노드 번호

                // 비용 = 현재 노드까지 온 누적 비용(currCost) + 주변 노드로 가는 간선 비용(neighbor.cost)
                int nextCost = currCost + neighbor.cost;

                // 새로 계산한 비용(nextCost)이 기존에 기록되어 있던 거리(dist[nextNode])보다 작다면
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;  // 최단 거리로 수정
                    pq.offer(new Edge(nextNode, nextCost));  // 다음 탐색을 위해 큐에 삽입
                }
            }
        }

        // 시작 노드로부터 모든 노드까지의 최단 거리가 담긴 배열 반환
        return dist;
    }

    /**
     * 다익스트라 목표 노드 찾기 (그래프)
     * @param v: 노드의 개수
     * @param graph: 그래프
     * @param start: 시작 노드 번호
     * @param target: 최종 목적지 노드 번호
     */
    public int dijkstraTarget(int v, List<List<Edge>> graph, int start, int target) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currNode = current.nextNode;
            int currCost = current.cost;

            if (dist[currNode] < currCost) continue;

            // 큐에서 꺼낸 간선이 목표 노드(target)라면 누적 비용 반환
            if (currNode == target) return currCost;

            for (Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.nextNode;
                int nextCost = currCost + neighbor.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }

        // 만약 탐색이 끝날 때까지 target을 못 만났다면 최대값 반환
        return dist[target];  // Integer.MAX_VALUE
    }

    /**
     * 2차원 격자 맵 다익스트라 (상하좌우 이동 시 비용이 발생하는 최단 경로)
     * @param map: 맵(2차원 배열)
     * @param targetX: 찾을 x 좌표
     * @param targetY: 찾을 y 좌표
     */
    public int dijkstra2D(int[][] map, int targetX, int targetY) {
        int n = map.length;
        int m = map[0].length;

        // 2차원 최단 거리 테이블
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 상하좌우 탐색을 위한 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 시작점 (0, 0) 설정
        dist[0][0] = map[0][0];
        pq.offer(new Edge(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            // 현재까지 쌓인 누적 비용이 가장 적은 칸을 꺼냄
            Edge current = pq.poll();
            int cx = current.x;  // 현재 칸의 x 좌표
            int cy = current.y;  // 현재 칸의 y 좌표
            int currCost = current.cost;  // 현재 칸까지 오는데 걸린 누적 비용

            // 이미 처리된 적이 있는 좌표라면 패스
            if (dist[cx][cy] < currCost) continue;

            // 목적지에 도착했다면 최단 비용 반환
            if (cx == targetX && cy == targetY) return dist[cx][cy];

            // 현재 위치에서 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];  // 다음 x 좌표
                int ny = cy + dy[i];  // 다음 y 좌표

                // 맵 범위 내에 있는지 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 비용 = 현재 칸까지의 누적 비용(currCost) + 새로 이동할 칸에 적힌 비용(map[nx][ny])
                    int nextCost = currCost + map[nx][ny];

                    // 새로 계산한 비용(nextCost)이 기존 칸에 기록되어 있던 비용(dist[nx][ny])보다 작다면
                    if (nextCost < dist[nx][ny]) {
                        dist[nx][ny] = nextCost;  // 최단 거리 테이블 업데이트
                        pq.offer(new Edge(nx, ny, nextCost));  // 다음 탐색을 위해 큐에 삽입
                    }
                }
            }
        }

        // 최종 목적지 칸의 최단 비용 반환
        return dist[targetX][targetY];
    }

    // todo. 상태 추가 다익스트라
}