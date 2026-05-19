package main.java.coding.progms.level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P155652_둘만의_암호 {

    // 알파벳을 1씩 더하면서 skip을 일일이 확인하는 방법
    public String solution1(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        // skip 할 문자 헤시셋으로 저장
        HashSet<Character> check = new HashSet<>();
        for (int i = 0; i < skip.length(); i++) {
            check.add(skip.charAt(i));
        }

        // 문자열(s) 길이 만큼 순회
        for (int i = 0; i < s.length(); i++) {
            // 문자 빼기
            char c = s.charAt(i);
            // index 만큼 반복
            for (int j = 0; j < index; j++) {
                // c에 1 더하기
                c = (char) ((c - 'a' + 1) % 26 + 'a');

                // check 확인하고 없을 때까지 c에 1더하기
                while (check.contains(c)) {
                    // c를 한번 더하기 (알파벳 넘어가면 a로)
                    c = (char) ((c - 'a' + 1) % 26 + 'a');
                }
            }
            // index 만큼 더한 문자(skip 패스 포함) answer에 추가
            answer.append(c);
        }

        return answer.toString();
    }

    // (정공법) 허용된 문자 사전을 만들고, 알파벳이 사전에 있으면 통과하는 방식으로
    public String solution2(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        // 허용되는 문자 사전 리스트
        List<Character> check = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++) {
            if(skip.indexOf(c) == -1) {
                check.add(c);
            }
        }

        // 문자열(s) 순회
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int cur = check.indexOf(c);  // 포함되는 문자 index 위치 찾기
            int next = (cur + index) % check.size();  // index 만큼 뒤로 이동 (오버플로우 방지)

            answer.append(check.get(next));  // index 번호로 가져오기
        }

        return answer.toString();
    }
}