package main.java.coding.progms.level2;

import java.util.ArrayDeque;

public class P12973_짝지어_제거하기 {

    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }
}
