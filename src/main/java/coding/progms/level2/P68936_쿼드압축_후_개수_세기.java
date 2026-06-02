package main.java.coding.progms.level2;

public class P68936_쿼드압축_후_개수_세기 {

    int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];

        dc(arr, 0, 0, arr.length);

        return answer;
    }

    void dc(int[][] arr, int x, int y, int size) {

        if (isValid(arr, x, y , size)) {
            answer[arr[x][y]]++;
            return;
        }

        size /= 2;

        dc(arr, x, y, size);
        dc(arr, x + size, y, size);
        dc(arr, x, y + size, size);
        dc(arr, x + size, y + size, size);
    }

    boolean isValid(int[][] arr, int x, int y, int size) {
        int cur = arr[x][y];

        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(cur != arr[j][i]) return false;
            }
        }

        return true;
    }
}
