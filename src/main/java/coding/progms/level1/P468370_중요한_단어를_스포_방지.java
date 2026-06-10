package main.java.coding.progms.level1;

import java.util.HashMap;
import java.util.Map;

public class P468370_중요한_단어를_스포_방지 {

    // 내가 푼 코드
    public int solution1(String message, int[][] spoiler_ranges) {

        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();

        // 원래 단어 리스트
        String[] originWords = message.split(" ");
        for (String originWord : originWords) {
            // 단어 개수 map으로 관리 (key: 단어, value: 개수)
            map.put(originWord, map.getOrDefault(originWord, 0) + 1);
        }

        // 숨긴 문장 만들기
        StringBuilder hideMessage = new StringBuilder(message);
        for (int[] spoilerRange : spoiler_ranges) {
            for(int i = spoilerRange[0]; i < spoilerRange[1]+1; i++) {
                if(hideMessage.charAt(i) != ' ') {
                    hideMessage.setCharAt(i, '*');
                }
            }
        }

        // 숨긴 단어 리스트
        String[] spoiler = hideMessage.toString().split(" ");

        // 숨긴 단어 리스트 순회
        for (int i = 0; i < spoiler.length; i++) {
            // 숨긴 단어라면
            if(spoiler[i].contains("*")) {
                // map에 value -1
                map.put(originWords[i], map.getOrDefault(originWords[i], 0) -1);
            }
        }

        // map 순회
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // 만약 value가 0 이면 (중요한 단어이면) result + 1
            if (entry.getValue() == 0) result++;
        }

        return result;
    }

    // 정석 코드
    public int solution2(String message, int[][] spoiler_ranges) {

        int result = 0;
        // 스포일러 단어 배열에 저장
        boolean[] isSpoiledChar = new boolean[message.length()];
        for (int[] range : spoiler_ranges) {
            // 범위 정하기
            int start = range[0];  // 시작
            int end = range[1];  // 끝

            // 글자 개수만큼 배열 만들기
            for (int i = start; i <= end; i++) {
                isSpoiledChar[i] = true;  // 전부 true로 채우기
            }
        }

        // Key: 단어, Value: 한 번이라도 온전하게 등장했는지?
        Map<String, Boolean> wordCleanStatus = new HashMap<>();

        // 단어 뽑기
        String[] words = message.split(" ");
        int currentIndex = 0;

        for (String word : words) {
            // 연속된 공백일 경우 비어있는값 패스
            if (word.isEmpty()) {
                currentIndex++;
                continue;
            }

            // 현재 단어의 시작 인덱스부터 끝 인덱스까지 스포일러가 있는지 확인
            boolean isCurrentWordSpoiled = false;
            for (int i = 0; i < word.length(); i++) {
                if (isSpoiledChar[currentIndex + i]) {
                    isCurrentWordSpoiled = true;
                    break;  // 한 글자라도 스포되면 이 단어는 중요한 단어가 아님
                }
            }

            // 단어가 스포일러를 피했는지 여부
            boolean isClean = !isCurrentWordSpoiled;

            // 기존에 안전한 적이 있었거나(true 였거나), 이번에 안전하다면 true로 업데이트
            wordCleanStatus.put(word, wordCleanStatus.getOrDefault(word, false) || isClean);

            // 다음 단어의 시작 위치로 인덱스 이동 (단어 길이 + 공백 1칸)
            currentIndex += word.length() + 1;
        }

        // 중요한 단어 개수 카운트
        for (boolean isClean : wordCleanStatus.values()) {
            if (!isClean) {
                result++;
            }
        }

        return result;
    }
}