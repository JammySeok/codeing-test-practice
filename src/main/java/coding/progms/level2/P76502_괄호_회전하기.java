package main.java.coding.progms.level2;

import java.util.ArrayDeque;

public class P76502_괄호_회전하기 {

    // (실패) 변수 카운팅으로는 해결 안됨
    public int fail(String s) {
        int answer = 0;
        StringBuilder str = new StringBuilder(s);

        for(int i = 0; i < s.length()-1; i++) {

            // 괄호가 열리면 +, 닫히면 -
            int braA = 0;  // 소괄호 '()'
            int braB = 0;  // 중괄호 '{}'
            int braC = 0;  // 대괄호 '[]'

            // 괄호 계산
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (c == '(') braA++;
                else if (c == ')')  {
                    braA--;
                    // 음수가 되었다면 열리지도 않았는데 닫힌 경우
                    if (braA < 0) break;
                }
                else if (c == '{') braB++;
                else if (c == '}') {
                    braB--;
                    if (braB < 0) break;
                }
                else if (c == '[') braC++;
                else if (c == ']') {
                    braC--;
                    if (braC < 0) break;
                }
            }

            // 전부 0인지 확인 (괄호 정상적으로 열리고 닫힘)
            if (braA == 0 && braB == 0 && braC == 0) {
                answer++;
            }

            // 돌리기
            char temp = str.charAt(0);
            for(int j = 0; j < str.length()-1; j++) {
                str.setCharAt(j, str.charAt(j+1));
            }
            str.setCharAt(str.length()-1, temp);
        }

        return answer;
    }

    // (정공법) 스택 사용
    public int solution(String s) {
        int answer = 0;
        StringBuilder str = new StringBuilder(s);

        for(int i = 0; i < s.length(); i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();  // 스택
            boolean isAllow = true;

            // 올바른 괄호인지 검증
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                // 괄호가 열리면 일단 push
                if (c == '(' || c == '{' || c == '[') stack.push(str.charAt(j));
                // ')'로 닫았을 때 가장 마지막이 '(' 인지 확인
                else if (c == ')') {
                    // 맞으면 pop
                    if (!stack.isEmpty() &&  stack.peek() == '(') stack.pop();
                    // 아니면 isAllow는 false, 반복문 탈출
                    else {
                        isAllow = false;
                        break;
                    }
                }
                // '}'로 닫았을 때 가장 마지막이 '{' 인지 확인
                else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else {
                        isAllow = false;
                        break;
                    }
                }
                // ']'로 닫았을 때 가장 마지막이 '[' 인지 확인
                else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        isAllow = false;
                        break;
                    }
                }
            }

            // isAllow 가 true 이면서 스택이 비어있으면 올바른 괄호
            if (isAllow && stack.isEmpty()) answer++;

            // 돌리기
            char temp = str.charAt(0);
            for (int j = 0; j < str.length() - 1; j++) {
                str.setCharAt(j, str.charAt(j + 1));
            }
            str.setCharAt(str.length() - 1, temp);
        }

        return answer;
    }
}
