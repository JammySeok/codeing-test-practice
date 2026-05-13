package main.java.coding.progms.level1;

public class P67256_키패드_누르기 {

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int left = 10;  // *
        int right = 12;  // #
        for(int num : numbers) {

            // 0은 11
            int target = (num == 0) ? 11 : num;

            // 왼쪽
            if(num == 1 || num == 4 || num == 7) {
                answer.append('L');
                left = target;
            }
            // 오른족
            else if(num == 3 || num == 6 || num == 9) {
                answer.append('R');
                right = target;
            }
            // 가운데
            else if(num == 2 || num == 5 || num == 8 || num == 0) {
                // 현재 손가락과 목표 번호의 거리
                int leftDistance = manhattan(left, target);
                int rightDistance = manhattan(right, target);

                // 오른쪽이 더 가까우면
                if(leftDistance > rightDistance) {
                    answer.append('R');
                    right = target;
                }
                // 왼쪽이 더 가까우면
                else if(leftDistance < rightDistance) {
                    answer.append('L');
                    left = target;
                }
                // 왼쪽과 오른쪽 거리가 같을때
                else {
                    if(hand.equals("left")) {
                        answer.append('L');
                        left = target;
                    }
                    else {
                        answer.append('R');
                        right = target;
                    }
                }
            }
        }

        return answer.toString();
    }

    /**
     * 맨헤튼 거리 구하기 공식 ( |x1 - x2| + |y1 - y2| )
     * @param current: 손가락 위치
     * @param target: 목표 번호
     */
    int manhattan(int current, int target) {
        int x1 = (current - 1) / 3;
        int y1 = (current - 1) % 3;
        int x2 = (target - 1) / 3;
        int y2 = (target - 1) % 3;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
