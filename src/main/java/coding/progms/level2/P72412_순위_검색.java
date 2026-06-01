package main.java.coding.progms.level2;

import java.util.*;

public class P72412_순위_검색 {

    // 조건과 점수를 map으로 관리 - map(조건:점수 리스트)
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        map = new HashMap<>();  // map(조건:점수 리스트)

        // 주어진 조건
        for (String i : info) {
            // 빈 값 기준으로 split
            String[] split = i.split(" ");  // 조건들
            int score = Integer.parseInt(split[4]);  // 점수

            // map에 값 넣기
            makeCondition(split, "", 0, score);
        }

        // map의 value(점수 리스트) 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        // 검색 쿼리
        for (String q : query) {
            int count = 0;  // return 할 조건에 맞는 개수

            // "java and backend and junior and pizza 100" -> "java_backend_junior_pizza 100"
            String str = q.replace(" and ", "_");
            // 점수 앞에 공백자리 인덱스
            int lastSpace = str.lastIndexOf(" ");

            // 조건 및 점수 추출
            String condition = str.substring(0, lastSpace) + "_";
            int targetScore = Integer.parseInt(str.substring(lastSpace + 1));

            // 이진 탐색(Lower Bound) 사용
            // map의 키와 query의 조건이 맞을 때
            if (map.containsKey(condition)) {
                // 조건에 맞는 점수 가져오기
                List<Integer> values = map.get(condition);

                int start = 0;  // 시작 값
                int end = values.size();  // 끝 값

                // 시작 - 끝 목표 값(targetScore) 비교하면서 절반 씩 줄이기
                while (start < end) {
                    // mid가 targetScore보다 작으면 절반 줄이기
                    int mid = (start + end) / 2;

                    // mid가 targetScore보다 작으면 시작값(start) 중간으로 설정
                    if (values.get(mid) < targetScore) start = mid + 1;
                    // mid가 targetScore보다 크거나 같으면 끝값(end)을 중간으로 설정
                    else end = mid;
                }

                // count = 값 전체 사이즈 - 찾은 값의 첫 인덱스
                // ex. values = {50, 80, 150, 200}, targetScore = 150 일 때
                // 이진 탐색 start = 2, 4(전체 사이즈) - 2(인덱스) = 2명 (150, 200)
                count = values.size() - start;
            }

/*
            // 전부 순회하는 코드
            if (map.containsKey(condition)) {
                List<Integer> values = map.get(condition);

                for (int i = 0; i < values.size(); i++) {
                    int curScore = values.get(i);
                    if(curScore >= targetScore) {
                        count = values.size() - i;
                        break;
                    }
                }
            }
*/

            // 답에 count 추가
            answer.add(count);
        }

        // ArrayList -> 배열
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * 4가지 조건으로 만들어질 수 있는 모든 조합을 Map에 점수를 저장하는 메서드 (재귀함수)
     * 예시 데이터: "java backend junior pizza 150" 입력 시
     * 1) java_backend_junior_pizza_
     * 2) -_backend_junior_pizza_
     * 3) java_-_junior_pizza_
     * ...
     * 16) -_-_-_-_
     * 이런식으로 2^4 (16가지) 조합 전부 등록
     *
     * @param split: 원본 조건 배열
     * @param str:   현재 만들어진 조건 문자열
     * @param depth: 재귀 깊이
     * @param score: 코딩테스트 점수
     */
    private void makeCondition(String[] split, String str, int depth, int score) {
        // 4개 조건이 다 합쳐졌다면 (종료 조건)
        if (depth == 4) {
            // key에 값 없으면 새로운 리스트 만들기
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            // key에 해당하는 리스트에 점수 추가
            map.get(str).add(score);

            return;
        }

        // 재귀 함수
        makeCondition(split, str + split[depth] + "_", depth + 1, score);  // 원래 조건 넣기
        makeCondition(split, str + "-" + "_", depth + 1, score);  // 원래 조건대신 하이픈(-) 조건 넣기
    }
}