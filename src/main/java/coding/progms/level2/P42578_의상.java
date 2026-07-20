package main.java.coding.progms.level2;

import java.util.HashMap;
import java.util.Map;

// 문제 포기 (도저히 혼자 정답 도출 X)
public class P42578_의상 {

    /**
     * 경우의수 계산 (수학적 방식)
     * 공식: Total = (N1 + 1) * (N2 + 1) * ... * (Nk + 1) - 1
     * 의상중 아무것도 입지 않는 경우 +1
     * 문제 조건에 '최소 한 개의 의상은 입는다'라고 명시했으므로 -1
     *
     * 예를들어 예를들어 모자2개, 안경 1개 라면
     * 모자 선택지: 2 + 1 = 3
     * 안경 선택지: 1 + 1 = 2
     * 총 2 * 3 - 1 = 5
     */
    public int solution(String[][] clothes) {

        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];

            map.put(type, map.getOrDefault(type, 0) + 1);
/*
            // 동일한 동작
            if (map.containsKey(type)) {
                // 이미 맵에 존재하는 종류라면 기존 값에 1을 더해서 덮어씀
                int currentCount = map.get(type);
                map.put(type, currentCount + 1);
            }
            else {
                // 맵에 처음 들어오는 종류라면 개수를 1로 저장함
                map.put(type, 1);
            }
*/
        }

        for (int count : map.values()) {
            answer *= (count + 1);
        }

        return answer -1;
    }
}
