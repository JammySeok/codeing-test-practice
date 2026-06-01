package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P72412_순위_검색;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P72412_순위_검색_Test {

    P72412_순위_검색 p72412 = new P72412_순위_검색();

    @Test
    void 테스트1() {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        int[] result = {1, 1, 1, 1, 2, 4};

        int[] answer = p72412.solution(info, query);

        Assertions.assertArrayEquals(result, answer);
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }

}