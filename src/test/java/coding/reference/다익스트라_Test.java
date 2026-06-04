package test.java.coding.reference;

import main.java.coding.reference.다익스트라;
import main.java.coding.reference.다익스트라.Edge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 다익스트라_Test {

    다익스트라 ref = new 다익스트라();

    @Test
    void 테스트1_dijkstra() {
        int v = 5;  // 노드 5개
        int start = 1;  // 1번 노드부터 시작

        // 그래프 인접 리스트 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 추가 (출발, 도착, 비용)
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 5));
        graph.get(2).add(new Edge(3, 2));
        graph.get(2).add(new Edge(4, 6));
        graph.get(3).add(new Edge(4, 1));
        graph.get(4).add(new Edge(5, 3));

        int[] result = {Integer.MAX_VALUE, 0, 2, 4, 5, 8};

        int[] answer = ref.dijkstra(v, graph, start);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트2_dijkstra() {
        int v = 5;  // 노드 5개
        int start = 1;  // 1번 노드부터 시작

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 5번 노드는 연결하는 간선이 없어 도달이 불가능한 상태
        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(3, 1));
        graph.get(3).add(new Edge(4, 2));

        int[] result = {Integer.MAX_VALUE, 0, 3, 4, 6, Integer.MAX_VALUE};

        int[] answer = ref.dijkstra(v, graph, start);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    @Test
    void 테스트1_dijkstraTarget() {
        int v = 5;  // 노드 5개
        int start = 1;  // 1번 노드 출발
        int target = 4;  // 4번 노드 목적지 지정

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 5));
        graph.get(2).add(new Edge(3, 2));
        graph.get(2).add(new Edge(4, 6));
        graph.get(3).add(new Edge(4, 1));
        graph.get(4).add(new Edge(5, 3));

        int result = 5;

        int answer = ref.dijkstraTarget(v, graph, start, target);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2_dijkstraTarget() {
        int v = 5;  // 노드 5개
        int start = 1;  // 1번 노드 출발
        int target = 5; // 5번 노드 목적지 지정

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 5번으로 가는 길은 완전히 끊어진 그래프
        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(3, 1));
        graph.get(3).add(new Edge(4, 2));

        // 5번 노드는 도달할 수 없으므로 테이블의 초기값(Integer.MAX_VALUE) 리턴
        int result = Integer.MAX_VALUE;

        int answer = ref.dijkstraTarget(v, graph, start, target);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트1_dijkstra2D() {
        int[][] map = {
                {0, 5, 4},
                {9, 0, 8},
                {1, 2, 0}
        };
        int targetX = 2;
        int targetY = 2;
        int result = 7;

        int answer = ref.dijkstra2D(map, targetX, targetY);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2_dijkstra2D() {
        // 중앙이 큰 비용(99)으로 막혀있음
        int[][] map = {
                {0,  1,  1},
                {5, 99,  1},
                {5,  5,  0}
        };
        int targetX = 2;
        int targetY = 1;
        int result = 8;

        int answer = ref.dijkstra2D(map, targetX, targetY);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}