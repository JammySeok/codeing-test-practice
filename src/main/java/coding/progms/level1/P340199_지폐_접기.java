package main.java.coding.progms.level1;

public class P340199_지폐_접기 {

    public int solution(int[] wallet, int[] bill) {

        int answer = 0;

        // max, min 값
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);

        // 지갑에 안들어가면 while 동작
        while(walletMax < billMax || walletMin < billMin) {
            // 일단 max/2 (반 접기)
            billMax /= 2;

            // min이 max 보다 크면 위치 변경 (돌리기)
            if(billMax < billMin) {
                int temp = billMax;
                billMax = billMin;
                billMin = temp;
            }

            answer++;
        }

        return answer;
    }
}