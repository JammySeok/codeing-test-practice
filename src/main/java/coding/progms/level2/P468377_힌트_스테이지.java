package main.java.coding.progms.level2;

public class P468377_힌트_스테이지 {

    public int solution(int[][] cost, int[][] hint) {
        // 인벤토리 (힌트 저장)
        int[] inventory = new int[cost.length];
        // 재귀함수
        return payCost(cost, hint, inventory, 0);
    }

    int payCost(int[][] cost, int[][] hint, int[] inventory, int level) {
        // 모든 스테이지를 통과한 상태(종료 조건)로 비용 0 반환
        if (level == cost.length) return 0;

        // 최대 적용할 수 있는 힌트 개수
        int maxHint = cost[level].length - 1;
        // 현재 보유한 힌트 개수와 maxHint(최대 적용할 수 있는 힌트 개수) 중 작은값을 사용
        int useHint = Math.min(inventory[level], maxHint);
        // 현재 스테이지를 통과하는 데 지불해야 할 통과 비용
        int currentCost = cost[level][useHint];

        // 분기 - 힌트를 구매하지 않음
        // 현재 비용을 가지고 다음 스테이지로 재귀
        int costSkip = currentCost + payCost(cost, hint, inventory, level + 1);

        // 분기 - 힌트를 구매함
        int costBuy = Integer.MAX_VALUE;  // 초기값 무한 (min 비교를 위해)
        // 배열 인덱스 초과 및 Null 방지
        if (level < hint.length && hint[level] != null && hint[level].length > 0) {
            // 번들 구매 가격
            int bundlePrice = hint[level][0];
            // 다음 인벤토리 처리를 위한 복제
            int[] nextInventory = inventory.clone();

            // 힌트 전부 인벤토리에 집어넣기
            for (int i = 1; i < hint[level].length; i++) {
                int targetStage = hint[level][i] - 1;

                // 해당 스테이지의 힌트 보유 개수 하나 증가
                if (targetStage < nextInventory.length) {
                    nextInventory[targetStage]++;
                }
            }

            // 비용 합산 후 다음 스테이지로 재귀
            costBuy = currentCost + bundlePrice + payCost(cost, hint, nextInventory, level + 1);
        }

        // 최소값 반환
        return Math.min(costSkip, costBuy);
    }
}