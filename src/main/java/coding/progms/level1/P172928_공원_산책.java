package main.java.coding.progms.level1;

public class P172928_공원_산책 {

    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int curX = 0;
        int curY = 0;

        // 시작 좌표 지정
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(park[i].charAt(j) == 'S') {
                    curY = i;
                    curX = j;
                    break;
                }
            }
        }

        // 이동 방향 설정
        for (String route : routes) {
            String[] parts = route.split(" ");  // 빈값 없애기
            String direction = parts[0];
            int distance = Integer.parseInt(parts[1]);  // 숫자로 거리 변환

            // x, y 좌표
            int x = 0;
            int y = 0;

            // N: 위(-1, 0), S: 아래(1, 0), W: 왼쪽(0, -1), E: 오른쪽(0, 1)
            if (direction.equals("E")) x = 1;
            else if (direction.equals("W")) x = -1;
            else if (direction.equals("S")) y = 1;
            else if (direction.equals("N")) y = -1;

            // 움직일 x, y 좌표 설정
            int nextX = curX;
            int nextY = curY;
            boolean canMove = true;

            // 시뮬레이션
            for(int i = 0; i < distance; i++) {
                nextX += x;
                nextY += y;

                // 범위 넘어가는지, 장애물 있는지 확인
                if(nextX < 0 || nextX >= w || nextY < 0 || nextY >= h || park[nextY].charAt(nextX) == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 움직일 수 있으면 x, y 좌표 이동
            if (canMove) {
                curX = nextX;
                curY = nextY;
            }
        }

        return new int[]{curY, curX};
    }
}
