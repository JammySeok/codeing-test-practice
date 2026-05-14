package main.java.coding.progms.level1;

public class P42862_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] hasItem = new int[n+2];

        for (int i : lost)  hasItem[i]--;  // 도둑맞은 학생 체육복 개수 빼기
        for (int i : reserve)  hasItem[i]++;  // 여분 가져온 학생 체육복 개수 추가

        // 학생들 체육복 있는지 순회
        for(int i = 1 ; i <= n; i++) {
            // 자신이 체육복 여분이 있을때
            if(hasItem[i] == 1) {
                // 앞 번호 체육복 없을때
                if(hasItem[i-1] == -1) {
                    hasItem[i]--;
                    hasItem[i-1]++;
                }
                // 뒷 번호 체육복 없을때
                else if(hasItem[i+1] == -1) {
                    hasItem[i]--;
                    hasItem[i+1]++;
                }
            }
        }

        // 체육복 있는 학생 조회
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(hasItem[i] > -1) answer++;
        }

        return answer;
    }
}
