package main.java.coding.progms.level1;

public class P12944_평균_구하기 {

    public double solution(int[] arr) {

        int sum = 0;

        for(int n : arr) {
            sum += n;
        }

        return (double) sum / (arr.length);
    }
}