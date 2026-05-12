package main.java.coding.progms.level1;

public class P12926_시저_암호 {

    public String solution1(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for ( int i = 0; i < s.length(); i++) {
            // 공백일 땐 그대로
            if(s.charAt(i) == ' ') {
                answer.append(' ');
            }
            // a~z 이면서 z보다 커질 때
            else if(s.charAt(i)+n > 'z' && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                char ch = (char)(s.charAt(i) + n - 26);
                answer.append(ch);
            }
            // A~Z 이면서 Z보다 커질 때
            else if(s.charAt(i)+n > 'Z' && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char ch = (char)(s.charAt(i) + n - 26);
                answer.append(ch);
            }
            // 그 외
            else {
                char ch = (char)(s.charAt(i) + n);
                answer.append(ch);
            }
        }

        return answer.toString();
    }

    // 최적화
    public String solution2(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for ( int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 공백일 땐 그대로
            if(ch == ' ') {
                answer.append(ch);
            }
            // a~z 이면서 z보다 커질 때
            else if(ch >= 'a' && ch <= 'z') {
                ch = (char)((ch - 'a' + n) % 26 + 'a');
                answer.append(ch);
            }
            // A~Z 이면서 Z보다 커질 때
            else if(ch >= 'A' && ch <= 'Z') {
                ch = (char)((ch - 'A' + n) % 26 + 'A');
                answer.append(ch);
            }
            // 그 외
            else {
                ch = (char)(ch + n);
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}
