package main.java.coding.reference;

import java.util.Arrays;

public class 에라토스테네스의_체 {

    // 1 ~ N 까지 소수 판별
    public boolean[] solution1(int N) {

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수인 숫자를 추출해야 된다면 아래 주석 해제
//        List<Integer> primeList = new ArrayList<>();
//        for (int i = 2; i <= N; i++) {
//            if (isPrime[i]) {
//                primeList.add(i);
//            }
//        }

        return isPrime;
    }
}
