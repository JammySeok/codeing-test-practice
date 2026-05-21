package main.java.coding.progms.level1;

import java.util.ArrayList;
import java.util.List;

public class P468371_노란불_신호등 {

    public int solution(int[][] signals) {

        // 모든 신호등의 총 주기
        List<Integer> cycles = new ArrayList<>();
        for (int[] signal : signals) {
            cycles.add(signal[0] + signal[1] + signal[2]);
        }

        // 모든 주기의 최소공배수(최대 탐색 시간) 구하기
        int maxLimit = cycles.get(0);
        for (int i = 1; i < cycles.size(); i++) {
            maxLimit = lcm(maxLimit, cycles.get(i));
        }

        // 최대 탐색 시간까지 반복문
        for(int time = 1; time <= maxLimit; time++) {
            boolean isYellow = true;  // 노랑이 겹치는지

            // 신호등 개수만큼
            for(int i = 0; i <signals.length; i++) {
                int[] signal = signals[i];  // 신호
                int cycle = cycles.get(i);  // 주기

                // 현재 시간이 신호등의 현재 주기에서 몇 초째인지 구하기 (남은시간)
                // 예) 주기가 7초이고 현재 11초라면, 이번 주기에서는 4초 진행 중임
                int remain = (time - 1) % cycle;

                int green = signal[0];  // 초록불
                int yellow = signal[1];  // 노란불

                // remain이 노란불 구간을 벗어났다면
                // 아직 초록불이 안 끝났거나(green보다 작음), 이미 노란불이 끝났다면(green+yellow보다 크거나 같음)
                if(!(remain >= green && remain < (green + yellow))) {
                    isYellow = false;  // 노란불이 아니므로 이 시간대는 false
                    break;
                }
            }

            // isYellow 확인해서 true이면 시간 return
            if (isYellow) {
                return time;
            }
        }

        // 다 돌았는데도 isYellow false이면 -1 return
        return -1;
    }

    // 최소공배수
    int lcm(int a, int b) {
        int num1 = a;
        int num2 = b;

        while(num2 != 0) {
            int temp = num1%num2;
            num1 = num2;
            num2 = temp;
        }

        return (a*b)/num1;
    }
}
