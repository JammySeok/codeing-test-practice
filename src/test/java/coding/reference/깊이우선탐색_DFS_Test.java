package test.java.coding.reference;

import main.java.coding.reference.깊이우선탐색_DFS;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class 깊이우선탐색_DFS_Test {

    깊이우선탐색_DFS ref = new 깊이우선탐색_DFS();

    @Test
    void 테스트1_dfs2D() {
        // 4x4 미로 만들기
        깊이우선탐색_DFS.N = 4;
        깊이우선탐색_DFS.M = 4;
        깊이우선탐색_DFS.visited2D = new boolean[4][4];
        깊이우선탐색_DFS.map = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 1}
        };

        ref.dfs2D(0, 0);

        // 이어져 있는 곳은 모두 방문했는지?
        assertTrue(깊이우선탐색_DFS.visited2D[0][0]);
        assertTrue(깊이우선탐색_DFS.visited2D[0][1]);
        assertTrue(깊이우선탐색_DFS.visited2D[2][2]);
        assertTrue(깊이우선탐색_DFS.visited2D[3][3]);

        // 벽(0)이거나 끊긴 곳은 방문하지 않았는지?
        assertFalse(깊이우선탐색_DFS.visited2D[0][2]);
        assertFalse(깊이우선탐색_DFS.visited2D[0][3]);
    }

    @Test
    void 테스트2_dfs2D() {
        // 5x5 미로 (고립 구역 테스트)
        깊이우선탐색_DFS.N = 5;
        깊이우선탐색_DFS.M = 5;
        깊이우선탐색_DFS.visited2D = new boolean[5][5];
        깊이우선탐색_DFS.map = new int[][]{
                {1, 1, 0, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };

        ref.dfs2D(0, 0);

        assertTrue(깊이우선탐색_DFS.visited2D[0][4]); // 우회 도달 가능
        assertFalse(깊이우선탐색_DFS.visited2D[4][0]); // 고립 구역 도달 불가
    }

    @Test
    void 테스트1_dfsGraph() {
        // 노드 1~4번 그래프
        int nodeCount = 4;
        깊이우선탐색_DFS.visitedGraph = new boolean[nodeCount + 1];
        깊이우선탐색_DFS.graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            깊이우선탐색_DFS.graph.add(new ArrayList<>());
        }

        깊이우선탐색_DFS.graph.get(1).add(2);
        깊이우선탐색_DFS.graph.get(1).add(3);
        깊이우선탐색_DFS.graph.get(2).add(4);

        깊이우선탐색_DFS.dfsGraph(1);

        assertTrue(깊이우선탐색_DFS.visitedGraph[1]);
        assertTrue(깊이우선탐색_DFS.visitedGraph[4]);
        assertFalse(깊이우선탐색_DFS.visitedGraph[0]);
    }

    @Test
    void 테스트2_dfsGraph() {
        // 1~6번 단절된 그래프 테스트
        int nodeCount = 6;
        깊이우선탐색_DFS.visitedGraph = new boolean[nodeCount + 1];
        깊이우선탐색_DFS.graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            깊이우선탐색_DFS.graph.add(new ArrayList<>());
        }

        깊이우선탐색_DFS.graph.get(1).add(2);
        깊이우선탐색_DFS.graph.get(2).add(3);
        깊이우선탐색_DFS.graph.get(3).add(1);

        깊이우선탐색_DFS.graph.get(4).add(5);
        깊이우선탐색_DFS.graph.get(5).add(6);

        깊이우선탐색_DFS.dfsGraph(1);

        assertTrue(깊이우선탐색_DFS.visitedGraph[3]);
        assertFalse(깊이우선탐색_DFS.visitedGraph[4]);
    }

    /**
     * =======================
     * 목표 지점 도달 가능 여부 (경로 존재 여부)
     * =======================
     */
    @Test
    void 테스트3_dfsTarget2D() {
        깊이우선탐색_DFS.N = 4;
        깊이우선탐색_DFS.M = 4;
        깊이우선탐색_DFS.visited2D = new boolean[4][4];
        깊이우선탐색_DFS.map = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 1}
        };

        // 1. 도달 가능한 목적지 (0,0 -> 3,3)
        boolean isReachable = ref.dfsTarget2D(0, 0, 3, 3);
        assertTrue(isReachable);

        // 2. 도달 불가능한 목적지 (0,0 -> 0,3)
        깊이우선탐색_DFS.visited2D = new boolean[4][4]; // 탐색 전 초기화 필수!
        boolean isUnreachable = ref.dfsTarget2D(0, 0, 0, 3);
        assertFalse(isUnreachable);
    }

    @Test
    void 테스트3_dfsTargetGraph() {
        int nodeCount = 5;
        깊이우선탐색_DFS.visitedGraph = new boolean[nodeCount + 1];
        깊이우선탐색_DFS.graph = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            깊이우선탐색_DFS.graph.add(new ArrayList<>());
        }

        깊이우선탐색_DFS.graph.get(1).add(2);
        깊이우선탐색_DFS.graph.get(2).add(3);
        깊이우선탐색_DFS.graph.get(3).add(4);
        깊이우선탐색_DFS.graph.get(1).add(5);

        // 1. 도달 가능한 목적지 (1 -> 4)
        boolean isReachable = 깊이우선탐색_DFS.dfsTargetGraph(1, 4);
        assertTrue(isReachable);

        // 2. 도달 불가능한 목적지 (1 -> 6)
        깊이우선탐색_DFS.visitedGraph = new boolean[7];
        깊이우선탐색_DFS.graph.add(new ArrayList<>());

        boolean isUnreachable = 깊이우선탐색_DFS.dfsTargetGraph(1, 6);
        assertFalse(isUnreachable);
    }
}