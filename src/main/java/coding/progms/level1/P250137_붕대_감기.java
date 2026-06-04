package main.java.coding.progms.level1;

public class P250137_붕대_감기 {

    public int solution(int[] bandage, int health, int[][] attacks) {

        int time = 0;  // 현재 시각
        int attackCount = 0;  // 공격 횟수
        int curHealth = health;  // 현재 피 상황
        int continueSuccess = 0;  // 연속 힐 성공 시간

        // 공격을 다 맞을때까지
        while(attackCount < attacks.length) {

            // 공격 받았다면
            if(attacks[attackCount][0] == time) {
                // 현재 피에서 공격력만큼 빼기
                curHealth -= attacks[attackCount][1];
                continueSuccess = 0;  // 연속 힐 성공 초기화
                attackCount++;  // 공격 횟수

                // 캐릭터 피 0 이하면 -1 반환
                if (curHealth < 1) return -1;
            }
            // 공격 받지 않았다면
            else {
                continueSuccess++;  // 연속 힐 성공 증가
                curHealth = Math.min(curHealth + bandage[1], health);  // 현재피 + 붕대스킬 회복

                // 연속 힐 횟수를 채웠다면
                if(continueSuccess == bandage[0]) {
                    curHealth = Math.min(curHealth + bandage[2], health);  // 추가 힐 (최대 피통을 넘지 않게)
                    continueSuccess = 0;  // 힐 횟수 초기화
                }
            }

            time++;  // 시간 증가
        }

        // 남은 피 반환
        return curHealth;
    }
}
