package main.java.coding.progms.level2;

import java.util.*;

public class P42888_오픈채팅방 {

    public String[] solution(String[] record) {

        List<String> answer = new ArrayList<>();

        // 채팅 메세지 담을 변수
        List<String[]> msg = new ArrayList<>();
        // 현재 유저의 닉네임
        Map<String, String> nickname = new HashMap<>();

        for (String r : record) {
            String[] str = r.split(" ");

            // 입장 했을 때
            if(str[0].equals("Enter")) {

                String[] status = new String[2];
                status[0] = str[1];
                status[1] = "님이 들어왔습니다.";
                // [ {userId}, "님이 들어왔습니다." ]
                msg.add(status);

                // 닉네임 userId 기준으로 map으로 저장
                nickname.put(str[1], str[2]);
            }
            // 나갔을 때
            else if (str[0].equals("Leave")) {

                String[] status = new String[2];
                status[0] = str[1];
                status[1] = "님이 나갔습니다.";

                msg.add(status);
            }
            // 채팅창 내부에서 바꿨을 때
            else if (str[0].equals("Change")){
                // 닉네임 변경
                nickname.put(str[1], str[2]);
            }
        }

        // 닉네임과 채팅기록 조합
        for (String[] str : msg) {
            // 현재 닉네임 가져오기
            String currentNickname = nickname.get(str[0]);

            // "{닉네임} + 님이 나갔습니다/들어왔습니다"
            answer.add(currentNickname + str[1]);
        }

        // List<String> -> String[]
        return answer.toArray(String[]::new);
    }
}
