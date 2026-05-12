package main.java.coding.progms.level1;

public class P12928_약수의_합 {

    // 일반적인 방법
    public int solution1(int n) {
        int answer = 0;
        int num = n;

        while(num > 0) {
            if(n%num == 0) {
                answer += num;
            }

            num--;
        }

        return answer;
    }

    // 최적화
    public int solution2(int n) {

        int answer = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {

            if (i*i == n) {
                answer+= i;
            }
            else if(n%i == 0) {
                answer += i;
                answer += n/i;
            }
        }

        return answer;
    }
}
