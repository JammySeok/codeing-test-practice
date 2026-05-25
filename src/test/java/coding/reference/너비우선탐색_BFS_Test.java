package test.java.coding.reference;

import main.java.coding.reference.너비우선탐색_BFS;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class 너비우선탐색_BFS_Test {

    너비우선탐색_BFS ref = new 너비우선탐색_BFS();

    @Test
    void 테스트1_bfs2D() {
        // 4x4 미로 만들기 (1: 이동 가능, 0: 벽)
        너비우선탐색_BFS.N = 4;
        너비우선탐색_BFS.M = 4;
        너비우선탐색_BFS.visited2D = new boolean[4][4];
        너비우선탐색_BFS.map = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 1}
        };

        // 시작 좌표
        int startX = 0;
        int startY = 0;

        ref.bfs2D(startX, startY);

        // 시작점에서 길이 이어져 있는 곳은 모두 방문(true)했는지?
        assertTrue(너비우선탐색_BFS.visited2D[0][0]);
        assertTrue(너비우선탐색_BFS.visited2D[0][1]);
        assertTrue(너비우선탐색_BFS.visited2D[2][2]);
        assertTrue(너비우선탐색_BFS.visited2D[3][3]);

        // 벽(0)이거나 길이 끊겨서 못 가는 곳은 방문하지 않았는지?
        assertFalse(너비우선탐색_BFS.visited2D[0][2]); // 벽
        assertFalse(너비우선탐색_BFS.visited2D[0][3]);
    }

    @Test
    void 테스트2_bfs2D() {
        // 5x5 미로 (길이 완전히 끊겨서 도달할 수 없는 고립 구역 테스트)
        너비우선탐색_BFS.N = 5;
        너비우선탐색_BFS.M = 5;
        너비우선탐색_BFS.visited2D = new boolean[5][5];
        너비우선탐색_BFS.map = new int[][]{
                {1, 1, 0, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}, // 모든 길이 막힌 뚫을 수 없는 벽
                {1, 1, 1, 1, 1}  // 길(1)이지만 시작점에서 도달 불가능한 구역
        };

        // 시작 좌표
        int startX = 0;
        int startY = 0;

        ref.bfs2D(startX, startY);

        // 이어져 있는 길은 멀리 돌아가더라도 모두 방문했는지?
        assertTrue(너비우선탐색_BFS.visited2D[0][0]);
        assertTrue(너비우선탐색_BFS.visited2D[2][2]);
        assertTrue(너비우선탐색_BFS.visited2D[0][4]); // ㄷ자 모양으로 우회해서 도달 가능

        // 벽(0)은 방문하지 않았는지?
        assertFalse(너비우선탐색_BFS.visited2D[0][2]);
        assertFalse(너비우선탐색_BFS.visited2D[3][2]);

        // 길(1)이긴 하지만 벽으로 완전히 가로막혀서 못 가는 곳은 false인지?
        assertFalse(너비우선탐색_BFS.visited2D[4][0]);
        assertFalse(너비우선탐색_BFS.visited2D[4][4]);
    }

    @Test
    void 테스트1_bfsGraph() {
        // 노드 1~4번 그래프 세팅
        int nodeCount = 4;
        너비우선탐색_BFS.visitedGraph = new boolean[nodeCount + 1];  // 1번 인덱스부터 쓰기 위해 +1
        너비우선탐색_BFS.graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            너비우선탐색_BFS.graph.add(new ArrayList<>());
        }

        // 간선 연결: 1-2, 1-3, 2-4 연결 (단방향)
        너비우선탐색_BFS.graph.get(1).add(2);
        너비우선탐색_BFS.graph.get(1).add(3);
        너비우선탐색_BFS.graph.get(2).add(4);

        // 시작 노드 1번
        int start = 1;

        // BFS 실행
        너비우선탐색_BFS.bfsGraph(start);

        // 1번에서 갈 수 있는 1, 2, 3, 4번 노드는 모두 방문(true)했는지?
        assertTrue(너비우선탐색_BFS.visitedGraph[1]);
        assertTrue(너비우선탐색_BFS.visitedGraph[2]);
        assertTrue(너비우선탐색_BFS.visitedGraph[3]);
        assertTrue(너비우선탐색_BFS.visitedGraph[4]);

        // 사용하지 않는 0번 인덱스는 false인지?
        assertFalse(너비우선탐색_BFS.visitedGraph[0]);
    }

    @Test
    void 테스트2_bfsGraph() {
        // 노드 1~6번 그래프 세팅 (단절된 그래프 및 사이클 테스트)
        int nodeCount = 6;
        너비우선탐색_BFS.visitedGraph = new boolean[nodeCount + 1];
        너비우선탐색_BFS.graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            너비우선탐색_BFS.graph.add(new ArrayList<>());
        }

        // 간선 연결 1: 1-2, 2-3, 3-1 (순환하는 1~3번 그룹)
        너비우선탐색_BFS.graph.get(1).add(2);
        너비우선탐색_BFS.graph.get(2).add(3);
        너비우선탐색_BFS.graph.get(3).add(1);

        // 간선 연결 2: 4-5, 5-6 (1번 그룹과 아예 이어지지 않은 4~6번 그룹)
        너비우선탐색_BFS.graph.get(4).add(5);
        너비우선탐색_BFS.graph.get(5).add(6);

        // 시작 노드 1번
        int start = 1;

        // BFS 실행
        너비우선탐색_BFS.bfsGraph(start);

        // 1번 그룹(1, 2, 3)은 사이클이 있어도 무한루프 없이 모두 방문(true)했는지?
        assertTrue(너비우선탐색_BFS.visitedGraph[1]);
        assertTrue(너비우선탐색_BFS.visitedGraph[2]);
        assertTrue(너비우선탐색_BFS.visitedGraph[3]);

        // 단절되어 있어서 1번 노드에서 출발해 갈 수 없는 4, 5, 6번 노드는 false인지?
        assertFalse(너비우선탐색_BFS.visitedGraph[4]);
        assertFalse(너비우선탐색_BFS.visitedGraph[5]);
        assertFalse(너비우선탐색_BFS.visitedGraph[6]);
    }

    /**
     * =======================
     * 목표까지 최단거리 구하기
     * =======================
     */
    @Test
    void 테스트3_bfsShort2D() {
        // 4x4 미로 (최단 거리 테스트)
        너비우선탐색_BFS.N = 4;
        너비우선탐색_BFS.M = 4;
        너비우선탐색_BFS.visited2D = new boolean[4][4];
        너비우선탐색_BFS.map = new int[][]{
                {1, 1, 0, 1}, // (0,3)은 사방이 막힌 고립된 위치
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 1}
        };

        // 도달 가능한 목적지 테스트 (0,0 -> 3,3)
        // 경로: (0,0)->(0,1)->(1,1)->(2,1)->(2,2)->(2,3)->(3,3)
        // 시작점 거리를 1로 세팅했으므로 총 7칸(거리 7)이 나와야 함
        int shortestPath = ref.bfsShort2D(0, 0, 3, 3);
        assertEquals(7, shortestPath);

        // 도달 불가능한 목적지 테스트 (0,0 -> 0,3)
        // 테스트 전 visited2D 배열을 초기화해줍니다 (위에서 탐색하며 더럽혀졌으므로)
        너비우선탐색_BFS.visited2D = new boolean[4][4];
        int unreachablePath = ref.bfsShort2D(0, 0, 0, 3);
        assertEquals(-1, unreachablePath); // 도달 불가능하므로 -1 반환 확인
    }

    @Test
    void 테스트3_bfsShortGraph() {
        // 노드 1~5번 그래프 세팅 (최단 거리 테스트)
        int nodeCount = 5;
        너비우선탐색_BFS.visitedGraph = new boolean[nodeCount + 1];
        너비우선탐색_BFS.graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            너비우선탐색_BFS.graph.add(new ArrayList<>());
        }

        // 간선 연결
        // 1번에서 4번으로 가는 길: 1 -> 2 -> 3 -> 4
        // 1번에서 5번으로 가는 길: 1 -> 5 (바로 감)
        너비우선탐색_BFS.graph.get(1).add(2);
        너비우선탐색_BFS.graph.get(2).add(3);
        너비우선탐색_BFS.graph.get(3).add(4);
        너비우선탐색_BFS.graph.get(1).add(5);

        // 도달 가능한 목적지 테스트 (1번 노드 -> 4번 노드)
        // 1(시작거리1) -> 2(거리2) -> 3(거리3) -> 4(거리4) 이므로 4가 나와야 함
        int shortestPath = 너비우선탐색_BFS.bfsShortGraph(1, 4);
        assertEquals(4, shortestPath);

        // 도달 불가능한 목적지 테스트 (1번 노드 -> 6번 노드)
        // 아예 연결되지 않은 6번 노드를 가정하고 새로 세팅
        너비우선탐색_BFS.visitedGraph = new boolean[7]; // 6번 노드까지 담을 수 있게 크기 변경
        너비우선탐색_BFS.graph.add(new ArrayList<>()); // 6번 노드용 리스트 추가

        int unreachablePath = 너비우선탐색_BFS.bfsShortGraph(1, 6);
        assertEquals(-1, unreachablePath); // 도달 불가능하므로 -1 반환 확인
    }
}