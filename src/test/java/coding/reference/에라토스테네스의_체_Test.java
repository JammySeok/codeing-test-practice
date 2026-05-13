package test.java.coding.reference;

import main.java.coding.reference.에라토스테네스의_체;
import org.junit.jupiter.api.Test;

class 에라토스테네스의_체_Test {

    에라토스테네스의_체 ref = new 에라토스테네스의_체();

    @Test
    void 테스트1_bool() {
        int N = 10;

        boolean[] answer = ref.solution1(N);

        for(int i = 0; i < answer.length; i++) {
            System.out.println(i + " = " + answer[i]);
        }
    }
}