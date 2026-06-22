package main.java.coding.progms.level3;

import java.util.ArrayList;
import java.util.List;

public class P92343_양과_늑대 {
    // 최대 양의 개수를 판별 할 전역번수
    int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        // 트리 만들기
        List<List<Integer>> tree = new ArrayList<>();
        for (int n : info) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        // 최대 모을 수 있는 양 개수 구하기 (DP)
        collectSheep(info, tree, 0, 0, 0, new ArrayList<>());

        return maxSheep;
    }

    void collectSheep(int[] info, List<List<Integer>> tree, int sheep, int wolf, int curNode, List<Integer> nextNode) {
        // 현재 node가 양(0)이면 sheep 더하기
        if (info[curNode] == 0) sheep++;
        // 늑대(1)이면 wolf 더하기
        else wolf++;

        // 늑대가 더 많아지면 재귀 종료
        if (wolf >= sheep) return;

        // 양의 개수 가장 많은것 기록
        maxSheep = Math.max(maxSheep, sheep);

        // 다음 노드 세팅
        List<Integer> next = new ArrayList<>(nextNode);
        next.remove(Integer.valueOf(curNode));  // 현재 노드는 들렀으므로 삭제
        for (int child : tree.get(curNode)) {
            next.add(child);
        }

        // 다음 노드로 재귀
        for (int targetNode : next) {
            collectSheep(info, tree, sheep, wolf, targetNode, next);
        }
    }
}
