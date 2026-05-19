package main.java.coding.progms.level2;

public class P12951_JadenCase_문자열_만들기 {

    /**
     * 내가 짠 쓰레기 코드 (trim 써서 문자 가져오고 JadenCase로 바꾸기)
     * [엣지 케이스 고려]
     * - 연속된 공백
     * - 문자열의 맨 앞과 맨 뒤에 공백이 있는 경우
     * - 이미 대문자로만 이루어진 단어 또는 무작위 대소문자
     */
    public String solution1(String s) {
        StringBuilder answer = new StringBuilder();
        // 문자열 공백 기준으로 배열에 담기 (마지막 공백 고려)
        String[] words = s.split(" ", -1);

        // 문자가 하나밖에 없을 경우
        if(words.length == 1) {
            // 단어 소문자로 변환해서 StringBuilder에 저장
            StringBuilder w = new StringBuilder(words[0].toLowerCase());

//            if (w.length() > 0) {  <- 프로그래머스에서 동작 안되는 코드

            // 빈 문자열 아닐때만 동작
            if (w.length() > 0) {
                // 단어의 첫문장 가져온 후 대문자로 변경
                char c = w.charAt(0);
                c = Character.toUpperCase(c);
                w.setCharAt(0, c);
            }

            // answer에 단어 추가
            answer.append(w);

            return answer.toString();
        }

        for (int i = 0; i < words.length; i++) {

            // 공백일 때
            if(words[i].isBlank() || words[i].isEmpty()) {
                // 아무것도 안 함
            }
            // 그 외
            else {
                // 단어 소문자로 변환해서 StringBuilder에 저장
                StringBuilder w = new StringBuilder(words[i].toLowerCase());

                // 단어의 첫문장 가져온 후 대문자로 변경
                char c = w.charAt(0);
                c = Character.toUpperCase(c);
                w.setCharAt(0, c);

                // answer에 단어 추가
                answer.append(w);
            }

            // 띄어쓰기 (마지막 실행 안함)
            if(i < words.length-1) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }

    // (정공법) 전 문자가 공백인지 확인하면서 JadenCase로 바꾸기
    public String solution2(String s) {
        StringBuilder answer = new StringBuilder(s);

        char pre;  // 이전값
        // 처음이 공백이면
        if(s.charAt(0) == ' ') {
            // pre에 공백 설정
            pre = ' ';
        }
        // 공백이 아니면
        else {
            // 첫 글자 대문자로 설정 후 pre에 첫 값 설정
            answer.setCharAt(0, Character.toUpperCase(s.charAt(0)));
            pre = s.charAt(0);
        }

        for(int i = 1; i < s.length(); i++) {
            // 이전 값이 공백이면
            if(pre == ' ') {
                // 문자 대문자로 변환
                answer.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
            // 공백이 아니면
            else {
                // 문자 소문자로 변환
                answer.setCharAt(i, Character.toLowerCase(s.charAt(i)));
            }

            pre = s.charAt(i);
        }

        return answer.toString();
    }
}
