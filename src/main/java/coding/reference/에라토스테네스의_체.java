package main.java.coding.reference;

import java.util.Arrays;

/**
 * 에라토스테네스의 체 (Sieve of Eratosthenes)
 * - 1부터 N까지 특정 범위 내의 모든 소수(Prime Number)를 대량으로 가장 빠르게 찾아내는 알고리즘
 * - 2부터 시작하여 각 소수의 '배수'들을 체로 거르듯 지워나가면서 소수만 남기는 방식 (시간복잡도 대폭 감소)
 * ex) N 이하의 소수 개수 구하기, 여러 숫자가 주어졌을 때 소수인지 대량으로 판별할 때, 빠른 소인수분해
 */
public class 에라토스테네스의_체 {

    // 1 ~ N 까지 소수 판별
    public boolean[] eratosthenes(int N) {

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