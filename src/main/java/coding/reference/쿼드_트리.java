package main.java.coding.reference;

/**
 * 쿼드 트리 (Quad Tree)
 * - 2차원 공간(배열, 이미지 등)을 4개의 구역으로 재귀적으로 분할하여 데이터를 압축하거나 탐색을 최적화하는 분할 정복 알고리즘
 * ex) 2차원 배열/이미지 압축, 특정 영역 내 데이터 탐색, 대규모 맵의 충돌 감지 최적화, 화면 렌더링(LOD)
 */
public class 쿼드_트리 {

    // 정답을 저장할 배열
    int[] answer;

    public int[] quadTree (int[][] board) {
        // size = 2 (0의 개수, 1의 개수)
        answer = new int[2];

        // 분할 정복
        divideAndConquer(board, 0, 0, board.length);

        return answer;
    }

    /**
     * 분할 정복 로직 (주어진 영역을 탐색하고, 압축하지 못하면 4등분해서 재귀 호출)
     * @param board: 원본 데이터가 담긴 2차원 배열
     * @param x: 현재 탐색 중인 영역의 가장 왼쪽 위 행(세로) 인덱스
     * @param y: 현재 탐색 중인 영역의 가장 왼쪽 위 열(가로) 인덱스
     * @param size: 현재 탐색 중인 정사각형 사이즈
     */
    private void divideAndConquer(int[][] board, int x, int y, int size) {
        // 현재 영역이 모두 같은 숫자로 이루어져 있는지(압축 가능한지) 검사
        if (check(board, x, y, size)) {
            // 모두 같은 숫자라면 해당 숫자 1 증가
            answer[board[x][y]]++;
            return;
        }

        // 숫자가 섞여 있으면(압축 못하면) 4등분하기 위해 절반으로 줄이기
        int newSize = size / 2;

        // 4등분 한 각 영역에 대해 재귀 호출
        divideAndConquer(board, x, y, newSize);  // 좌상단
        divideAndConquer(board, x, y + newSize, newSize);  // 우상단
        divideAndConquer(board, x + newSize, y, newSize);  // 좌하단
        divideAndConquer(board, x + newSize, y + newSize, newSize);  // 우하단
    }

    // 검사 로직 (지정된 영역 안의 모든 숫자가 같은지 확인)
    private boolean check(int[][] board, int x, int y, int size) {
        // 현재 탐색 영역의 가장 왼쪽 위 좌표의 값
        int firstValue = board[x][y];

        // 현재 영역의 시작점(x, y)부터 끝점(x+size, y+size)까지 순회
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 기준값과 숫자가 다르면
                if (board[i][j] != firstValue) {
                    return false;
                }
            }
        }

        // 순회를 다 돌았는데도 다른 값이 발견되지 않았다면 (모두 같은 값이라면)
        return true;
    }
}