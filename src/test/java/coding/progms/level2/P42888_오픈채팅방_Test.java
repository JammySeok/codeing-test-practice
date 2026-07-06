package test.java.coding.progms.level2;

import main.java.coding.progms.level2.P42888_오픈채팅방;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class P42888_오픈채팅방_Test {

    P42888_오픈채팅방 p42888 = new P42888_오픈채팅방();

    @Test
    void 테스트() {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        String[] result = {
                "Prodo님이 들어왔습니다.",
                "Ryan님이 들어왔습니다.",
                "Prodo님이 나갔습니다.",
                "Prodo님이 들어왔습니다."
        };

        String[] answer = p42888.solution(record);

        Assertions.assertArrayEquals(result, answer);
        System.out.println("result = " + Arrays.toString(result));
    }

}