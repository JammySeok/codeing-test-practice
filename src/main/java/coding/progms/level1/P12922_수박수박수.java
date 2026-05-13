package main.java.coding.progms.level1;

public class P12922_수박수박수 {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        int i = 0;
        while(i < n) {
            if(i%2 == 0) answer.append('수');
            if(i%2 == 1) answer.append('박');

            i++;
        }

        return answer.toString();
    }
}
