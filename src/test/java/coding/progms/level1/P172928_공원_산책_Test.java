package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P172928_공원_산책;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P172928_공원_산책_Test {

    P172928_공원_산책 p172928 = new P172928_공원_산책();

    @Test
    void 테스트1() {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        int[] result = {2, 1};

        int[] answer = p172928.solution(park, routes);

        Assertions.assertEquals(answer[0], result[0]);
        Assertions.assertEquals(answer[1], result[1]);
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }

    @Test
    void 테스트2() {
        String[] park = {"SOO", "OXX", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        int[] result = {0, 1};

        int[] answer = p172928.solution(park, routes);

        Assertions.assertEquals(answer[0], result[0]);
        Assertions.assertEquals(answer[1], result[1]);
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }

    @Test
    void 테스트3() {
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};
        int[] result = {0, 0};

        int[] answer = p172928.solution(park, routes);

        Assertions.assertEquals(answer[0], result[0]);
        Assertions.assertEquals(answer[1], result[1]);
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}