package main.java.coding.progms.level2;

public class P12924_숫자의_표현 {

    // 처음 풀이
    public int solution1(int n) {
        int answer = 1;
        int maxNum = n/2+1;  // 절반+1 보다 커지면 무조선 false이기 때문에

        // n이 2이면 maxNum이 2가 되어 버리기 때문에 엣지케이스 처리
        if (n == 2) {
            return 1;
        }

        // maxNum이 0이 될때까지 반복
        while(maxNum > 1) {
            int add = maxNum;  // 더한값을 저장해줄 변수

            // maxNum을 1씩 감소하면서 더하기
            for(int i = maxNum-1; i >= 0; i--) {
                // 연속으로 더한 값이 n과 같으면 answer++
                if(add == n) {
                    answer++;
                    break;
                }
                // 연속으로 더한 값이 n보다 반복문 종료
                else if(add > n) {
                    break;
                }
                // 그 외 더하기
                else {
                    add += i;
                }
            }

            maxNum--;  // maxNum 1씩 감소
        }

        return answer;
    }

    //

    /**
     * (정공법) 수학적 풀이
     * - 2의 거듭제곱인 2, 4, 8은 전부 답이 1 (자기 자신뿐)
     * - 소수인 3, 5, 7은 전부 답이 2
     * - 홀수이면서 합성수인 건 답이 약수의 개수
     */
    public int solution2(int n) {
        int answer = 0;

        // 1부터 n까지의 숫자 중 '홀수'이면서 'n의 약수'인 것의 개수를 구함
        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0) {
                answer++;
            }
        }

        return answer;
    }
}
