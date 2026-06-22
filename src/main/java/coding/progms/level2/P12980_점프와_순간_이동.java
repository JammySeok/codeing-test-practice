package main.java.coding.progms.level2;

public class P12980_점프와_순간_이동 {

    // 내가 푼 방식
    public int solution1(int n) {
        // 역방향으로(목표 -> 출발) 가야지 그리디 조건 만족
        int answer = 0;
        while(n != 0) {
            // 짝수이면 순간이동(나누기 2)
            if (n %2 == 0) n /= 2;
                // 홀수라면 전진(-1) 후 배터리(answer) 사용
            else {
                n -= 1;
                answer++;
            }
        }

        return answer;
    }

    // 최적화
    public int solution2(int n) {
        int answer = 0;
        while (n > 0) {
            // 홀수이면 나머지가 1이 되므로 배터리 카운트 증가
            answer += (n % 2);

            // 자바 정수 나눗셈 특성 사용 (홀수를 2로 나누면 자동으로 1을 값 적용)
            n /= 2;
        }

        return answer;
    }

    // 정석 방식 (비트 연산)
    public int solution3(int n) {
        // N의 2진수 표현에서 1의 개수 반환
        return Integer.bitCount(n);
    }
}
