package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P155652_둘만의_암호;
import org.junit.jupiter.api.Test;

class P155652_둘만의_암호_Test {

    P155652_둘만의_암호 p155652 = new P155652_둘만의_암호();

    @Test
    void 테스트1() {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String answer1 = p155652.solution1(s, skip, index);
        String answer2 = p155652.solution2(s, skip, index);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }
}