package main.java.coding.progms.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P176963_추억_점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();

        // 추억 점수표 map으로 관리
        HashMap<String, Integer> memoryScore = new HashMap<>();

        // map에 데이터 넣기
        for(int i = 0; i < name.length; i++) {
            // key(이름):value(점수)
            memoryScore.put(name[i], yearning[i]);
        }

        // 사진 사람 조회
        for(String[] people : photo) {
            int sum = 0;
            for (String person : people) {
                // key(이름)로 value(점수) 조회해서 더하기
                sum += memoryScore.getOrDefault(person, 0);  // 못찾으면(default) 0
            }

            answer.add(sum);  // 더한 값 넣기
        }

        // Array -> 배열 변환
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
