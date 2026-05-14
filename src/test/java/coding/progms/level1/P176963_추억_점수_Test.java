package test.java.coding.progms.level1;

import main.java.coding.progms.level1.P176963_추억_점수;
import org.junit.jupiter.api.Test;

class P176963_추억_점수_Test {

    P176963_추억_점수 p176963 = new P176963_추억_점수();

    @Test
    void 테스트1() {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };

        int[] answer =  p176963.solution(name, yearning, photo);

        for (int score : answer) {
            System.out.print(score + " ");
        }
    }

    @Test
    void 테스트2() {
        String[] name = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photo = {
                {"kali", "mari", "don"},
                {"pony", "tom", "teddy"},
                {"con", "mona", "don"}
        };

        int[] answer =  p176963.solution(name, yearning, photo);

        for (int score : answer) {
            System.out.print(score + " ");
        }
    }

    @Test
    void 테스트3() {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may"},
                {"kein", "deny", "may"},
                {"kon", "coni"}
        };

        int[] answer =  p176963.solution(name, yearning, photo);

        for (int score : answer) {
            System.out.print(score + " ");
        }
    }
}