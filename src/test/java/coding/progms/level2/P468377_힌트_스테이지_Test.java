package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P468377_힌트_스테이지;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P468377_힌트_스테이지_Test {

    P468377_힌트_스테이지 p468377 = new P468377_힌트_스테이지();

    @Test
    void 테스트1() {
        int[][] cost = {
                {160, 140, 120, 110, 60},
                {290, 270, 260, 120, 10},
                {160, 130, 120, 60, 20},
                {160, 120, 80, 70, 20},
                {110, 70, 60, 30, 20}
        };
        int[][] hint = {
                {40, 2, 3},
                {40, 5, 3},
                {20, 5, 4},
                {50, 5, 5}
        };
        int result = 810;

        int answer = p468377.solution(cost, hint);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트2() {
        int[][] cost = {
                {110, 100, 90, 80, 70, 50, 10},
                {170, 160, 150, 140, 130, 110, 30},
                {260, 250, 190, 180, 170, 130, 100},
                {170, 150, 120, 90, 60, 40, 30},
                {220, 140, 110, 100, 70, 60, 50},
                {290, 180, 150, 130, 100, 20, 10},
                {110, 100, 90, 70, 50, 40, 30}
        };
        int[][] hint = {
                {40, 3, 4, 3},
                {80, 3, 7, 4},
                {40, 7, 6, 5},
                {40, 7, 5, 5},
                {50, 6, 7, 6},
                {30, 7, 7, 7}
        };
        int result = 1080;

        int answer = p468377.solution(cost, hint);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트3() {
        int[][] cost = {
                {290, 270, 170, 100, 60, 20},
                {210, 190, 180, 170, 120, 80},
                {200, 180, 170, 80, 40, 20},
                {100, 90, 70, 60, 40, 10},
                {230, 200, 170, 150, 90, 80},
                {150, 100, 80, 60, 40, 10}
        };
        int[][] hint = {
                {230, 2, 2, 2, 2},
                {330, 5, 3, 4, 3},
                {180, 5, 4, 4, 6},
                {280, 5, 5, 6, 6},
                {260, 6, 6, 6, 6}
        };
        int result = 1180;

        int answer = p468377.solution(cost, hint);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트4() {
        int[][] cost = {
                {49250, 42271, 40724, 36310, 32560, 30670, 24100, 10378},
                {58510, 56101, 54078, 32864, 31443, 19451, 18098, 7187},
                {68812, 66112, 65024, 60529, 53992, 39865, 31325, 17700},
                {13768, 12866, 11379, 10425, 6853, 6176, 5655, 2556},
                {51748, 48647, 41478, 39756, 25302, 18081, 16504, 811},
                {52690, 34113, 32370, 29555, 19343, 11763, 7566, 5962},
                {9306, 9190, 8196, 7573, 6275, 4723, 1316, 212},
                {40713, 40158, 31449, 22349, 20956, 20377, 19489, 14450}
        };
        int[][] hint = {
                {0, 2, 4, 6, 2},
                {0, 6, 3, 3, 4},
                {0, 6, 4, 5, 5},
                {0, 7, 5, 8, 7},
                {0, 7, 7, 7, 7},
                {0, 7, 7, 7, 8},
                {0, 8, 8, 8, 8}
        };
        int result = 267789;

        int answer = p468377.solution(cost, hint);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트5() {
        int[][] cost = {
                {330, 300, 277, 162, 126},
                {640, 392, 358, 345, 231},
                {960, 872, 678, 392, 113},
                {210, 195, 176, 42, 37},
                {980, 964, 623, 327, 154}
        };
        int[][] hint = {
                {976, 2, 2, 3, 5, 3, 3},
                {746, 3, 3, 3, 3, 4, 3},
                {319, 5, 4, 4, 4, 4, 4},
                {966, 5, 5, 5, 5, 5, 5}
        };
        int result = 3004;

        int answer = p468377.solution(cost, hint);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }

    @Test
    void 테스트6() {
        int[][] cost = {
                {230, 223, 192, 93, 59, 33},
                {290, 240, 193, 117, 113, 42},
                {950, 908, 796, 598, 574, 328},
                {720, 692, 588, 237, 102, 61},
                {780, 569, 522, 450, 337, 293},
                {850, 837, 768, 568, 382, 124}
        };
        int[][] hint = {
                {158, 2, 2, 3},
                {260, 5, 4, 3},
                {268, 4, 4, 4},
                {426, 5, 5, 6},
                {330, 6, 6, 6}
        };
        int result = 3426;

        int answer = p468377.solution(cost, hint);

        Assertions.assertEquals(result, answer);
        System.out.println("answer = " + answer);
    }
}