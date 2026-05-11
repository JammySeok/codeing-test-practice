package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P42889_실패율;
import org.junit.jupiter.api.Test;

class P42889_실패율_Test {

    P42889_실패율 p42889 = new P42889_실패율();

    @Test
    void 테스트1() {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] solution = p42889.solution(N, stages);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    @Test
    void 테스트2() {
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};

        int[] solution = p42889.solution(N, stages);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}