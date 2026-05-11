package main.java.coding.progms.level1;

import java.util.ArrayList;
import java.util.List;

public class P42889_실패율 {

    /**
     * @param N: 스테이지 수
     * @param stages: 유저가 멈춰있는 스테이지 번호
     */
    public int[] solution(int N, int[] stages) {

        // 해당 스테이지에 몇명이 머무르고 있는지
        int[] stayStageCount = new int[N+2];
        for (int stage : stages) {
            stayStageCount[stage]++;
        }

        // 실패율을 담을 List
        List<Stage> failRate = new ArrayList<>();

        // 스테이지에 도착한 플레이어 (한번이라도)
        int arrivePlayerCount = stages.length;

        // 실패율 계산
        for(int i = 1; i <= N; i++) {
            double rate = 0;

            if(arrivePlayerCount > 0) {
                // 실패율: 스테이지에 남은 플레이어 / 스테이지에 도착한 플레이어
                rate = (double) stayStageCount[i] / arrivePlayerCount;
                failRate.add(new Stage(i, rate));

                // 스테이지에 남은 플레이어를 차감(누적 차감)
                arrivePlayerCount = arrivePlayerCount - stayStageCount[i];
            }
            else {
                // 남은 사람이 0으면 rate도 0;
                rate = 0;
                failRate.add(new Stage(i, rate));
            }
        }

        // 실패율 기준 내림차순 정렬
        failRate.sort((a, b) -> {
            // [1순위] 실패율 같으면 작은 번호가 먼저
            if(a.rate == b.rate)
                return Integer.compare(a.id, b.id);

            // [2순위] 실패율 비교
            return Double.compare(b.rate, a.rate);
        });

        // 내림차순으로 정렬 된 스테이지 번호
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failRate.get(i).id;
        }

        return answer;
    }

    class Stage {
        int id;
        double rate;

        Stage(int i, double rate) {
            this.id = i;
            this.rate = rate;
        }
    }
}