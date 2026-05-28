package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P169199_리코쳇_로봇;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P169199_리코쳇_로봇_Test {

    P169199_리코쳇_로봇 p169199 = new P169199_리코쳇_로봇();

    @Test
    void 테스트1() {
        String[] board = {
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."
        };
        int result = 7;

        int answer = p169199.solution(board);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        String[] board = {
                ".D.R",
                "....",
                ".G..",
                "...D"
        };
        int result = -1;

        int answer = p169199.solution(board);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}