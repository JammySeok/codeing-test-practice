package main.java.coding.reference;

public class 멘헤튼_거리 {

    /**
     * 맨해튼 거리 (Manhattan Distance)
     * - 두 점 사이의 거리를 격자(가로, 세로) 이동 거리의 합으로 구하는 공식
     * - 공식: |x1 - x2| + |y1 - y2|
     * ex) 두 지점 사이의 최단 경로 비용 계산, A* 탐색 알고리즘의 휴리스틱 함수
     */
    public int solution(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
