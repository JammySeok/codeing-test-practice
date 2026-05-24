package main.java.coding.reference;

/**
 * 유클리드 호제법 (gcd/lcm)
 * - 두 수의 최대공약수와 최소공배수를 빠르게 구하는 공식
 * ex) 주기 구하기, 동시에 출발해 다시 만나는 시점, 톱니바퀴, 분수 통분
 */
public class 유클리드_호제법 {

    public int[] euclidean(int a, int b) {
        int num1 = a;
        int num2 = b;

        while (num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        int gcd = num1;  // 최대공약수(gcd)
        int lcm = (a*b) / gcd;  // 최소공배수(lcm)

        return new int[] {gcd, lcm};
    }
}