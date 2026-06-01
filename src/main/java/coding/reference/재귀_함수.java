package main.java.coding.reference;


import java.util.List;

/**
 * 재귀 함수 접근법
 * [1단계] 종료 조건(Base Case) 정하기: 언제 멈출 것인가?
 * 멈추는 조건을 명시하지 않으면 StackOverflowError가 발생
 * 생각해야 할 부분: "몇 번의 선택을 마치면(또는 어떤 상태가 되면) 탐색을 멈추고 결과를 반환해야 하지?"
 * 코드: 보통 함수의 맨 윗부분에 if (depth == 목표치) { ... return; } 형태로 작성
 *
 * [2단계] 현재 단계에서의 선택지" 나열하기: 지금 내가 할 수 있는 행동은?
 * 목표 지점까지 가기 위해, 현재 깊이(depth)에서 내가 고를 수 있는 선택지가 몇 개인지 파악
 * 생각해야 할 부분: "이번 턴에서 내가 할 수 있는 경우의 수는 뭐지?"
 * ex) O/X 고르기(2개), 1~9 숫자 중 하나 고르기(9개), 상하좌우 이동하기(4개) 등
 *
 * [3단계] 선택지 실행 후, 다음 단계(depth + 1) 호출하기
 * 2단계에서 파악한 선택지들을 하나씩 실행해 보면서, 상태를 업데이트(depth + 1)하여 자기 자신 호출
 * 생각해야 할 부분: "이 선택을 한 상태로 다음 깊이(depth)로 넘어가기"
 * 코드: 선택지가 정해져 있다면 코드 여러 줄로 나열하고(순위 검색 문제 방식), 선택지가 많거나 유동적이라면 for문을 사용하여 재귀 함수를 호출
 */
public class 재귀_함수 {

    /**
     * [템플릿 1] 이진 선택형 (O/X, 포함/미포함 문제)
     * 예시: 3번의 선택 동안 'O' 또는 'X'를 고르는 모든 경우의 수 구하기
     */
    public void recursiveFunction1(String result, int depth, int targetDepth, List<String> answerList) {
        // [1단계] 종료 조건: 목표 깊이에 도달하면 결과 저장 후 멈춤
        if (depth == targetDepth) {
            answerList.add(result);
            return;
        }

        // [2단계 & 3단계] 현재 단계에서의 선택지 실행 후 다음 단계 호출
        // 선택지 A: 'O'를 선택하고 다음 깊이로 이동
        recursiveFunction1(result + "O", depth + 1, targetDepth, answerList);
        // 선택지 B: 'X'를 선택하고 다음 깊이로 이동
        recursiveFunction1(result + "X", depth + 1, targetDepth, answerList);
    }

    /**
     * [템플릿 2] 다중 선택형 (for문 사용, 비밀번호/순열 문제)
     * 예시: 주어진 문자 배열(알파벳)을 조합하여 만들 수 있는 N자리 비밀번호 구하기
     */
    public void recursiveFunction2(String password, int depth, int targetDepth, char[] options, List<String> answerList) {
        // [1단계] 종료 조건: 목표 글자 수에 도달하면 결과 저장 후 멈춤
        if (depth == targetDepth) {
            answerList.add(password);
            return;
        }

        // [2단계] 현재 단계에서의 선택지 나열: 주어진 options 배열을 순회
        for (int i = 0; i < options.length; i++) {
            char currentChoice = options[i];

            // [3단계] 선택지 실행 후 다음 단계 호출
            recursiveFunction2(password + currentChoice, depth + 1, targetDepth, options, answerList);
        }
    }

    /**
     * [템플릿 3] 중복 없는 선택 (방문 배열 사용 - 백트래킹)
     * 예시: 주어진 알파벳 중 중복 없이 N개를 뽑아 일렬로 나열하기
     */
    public void recursiveFunction3(String result, int depth, int targetDepth, char[] options, boolean[] visited, List<String> answerList) {

        // [1단계] 종료 조건: 목표 깊이에 도달하면 결과 저장 후 멈춤
        if (depth == targetDepth) {
            answerList.add(result);
            return;
        }

        // [2단계] 현재 단계에서의 선택지 나열하기 (반복문 활용)
        for (int i = 0; i < options.length; i++) {

            // 이미 이전 depth에서 사용한 아이템(방문한 곳)이라면 건너뛰기
            if (visited[i]) continue;

            // [3단계] 선택지 실행 후, 다음 단계(depth + 1) 호출하기
            visited[i] = true;  // 현재 선택지를 '사용함'으로 마킹
            recursiveFunction3(result + options[i], depth + 1, targetDepth, options, visited, answerList);
            visited[i] = false;  // (복구) 다음 경우의 수를 위해 다시 '사용 안 함'으로 원상태 복귀
        }
    }

    /**
     * [템플릿 4] 값을 반환하는 재귀 (분할 정복형)
     * 예시: 피보나치 수열 (N번째 항 구하기)
     */
    public int recursiveFunction4(int n) {
        // [1단계] 종료 조건 (더 이상 쪼갤 수 없는 가장 작은 단위)
        if (n <= 1) {
            return n;
        }

        // [2단계 & 3단계] 하위 문제를 호출하고, 그 복귀작들을 결합(합산)하여 반환
        int leftResult = recursiveFunction4(n - 1);
        int rightResult = recursiveFunction4(n - 2);

        return leftResult + rightResult;
    }
}