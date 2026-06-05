package main.java.coding.reference;

/**
 * 동적 계획법 (Dynamic Programming, DP) 접근법
 * * [1단계] 상태(State) 정의하기: dp 배열의 인덱스와 값이 의미하는 바를 명확히 정하기
 * 생각해야 할 부분: "내가 구해야 하는 답을 배열로 어떻게 표현할까?"
 * ex) dp[i] = i번째 계단까지 오르는 최소 비용
 * ex) dp[i][j] = i행 j열까지 도달하는 경우의 수
 *
 * * [2단계] 초기값 설정하기: 가장 작은 단위의 정답을 미리 배열에 넣기
 * 생각해야 할 부분: "점화식을 돌리기 위해 필요한 가장 첫 번째, 두 번째 정답은 뭘까?"
 * 점화식이 i-2를 참조한다면, dp[0]과 dp[1]은 하드코딩으로 채워두어야 에러가 발생하지 않음
 *
 * * [3단계] 점화식 세우기: 과거의 기록을 결합하여 현재의 정답을 만드는 규칙 찾기
 * 생각해야 할 부분: "현재 단계(i)의 답을 구하기 위해, 이전 단계들(i-1, i-2 등)의 값을 어떻게 조합해야 할까?"
 * 코드: 보통 1중 또는 2중 for문을 돌며 dp 배열을 순차적으로 채워 나감 (Bottom-up)
 */
public class 동적계획법_DP {

    /**
     * [템플릿 1] 1차원 기본형 (피보나치 수열 상향식)
     * 예시: N번째 피보나치 수 구하기
     */
    public int fibonacci(int n) {
        if (n <= 1) return n;

        // [1단계] 상태 정의: dp[i]는 i번째 피보나치 수
        int[] dp = new int[n + 1];

        // [2단계] 초기값 설정: 0번째와 1번째 값은 고정
        dp[0] = 0;
        dp[1] = 1;

        // [3단계] 점화식: 앞의 두 값을 더하여 현재 값을 만듦
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * [템플릿 2] 1차원 최적화형 (선택과 최솟값/최댓값)
     * 예시: 한 번에 1칸 또는 2칸씩 뛸 수 있을 때, N번째 칸에 도달하는 최소 비용 구하기
     */
    public int minCostStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];

        // [1단계] 상태 정의: dp[i]는 i번째 칸까지 도달하는데 드는 최소 누적 비용
        int[] dp = new int[n];

        // [2단계] 초기값 설정
        // 시작점이 0 또는 1이 될 수 있다고 가정할 때
        dp[0] = cost[0];
        dp[1] = cost[1];

        // [3단계] 점화식: 1칸 전에서 온 비용과 2칸 전에서 온 비용 중 더 작은 것을 선택 후 현재 칸 비용 추가
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        // 목적지에 도달하기 위해 마지막 두 번째 칸 중 최소 비용 선택
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    /**
     * [템플릿 3] 2차원 격자 탐색형 (경로의 수 또는 맵 최적화)
     * 예시: m x n 격자에서 오른쪽 또는 아래로만 이동할 때, (m-1, n-1)까지 가는 모든 경로의 수
     */
    public int gridPath(int m, int n) {
        // [1단계] 상태 정의: dp[i][j]는 (i, j) 좌표까지 도달할 수 있는 경우의 수
        int[][] dp = new int[m][n];

        // [2단계] 초기값 설정: 맨 위쪽 행(가로)과 맨 왼쪽 열(세로)은 무조건 직진만 가능하므로 경로가 1개뿐임
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // [3단계] 점화식: (i, j)에 도달하려면 위쪽 칸(i-1, j)에서 내려오거나 왼쪽 칸(i, j-1)에서 와야 함
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * [템플릿 4] 목표 값을 만드는 최소/최대 경우의 수
     * 예시: 주어진 동전들(coins)로 특정 금액을 만드는 최소 동전 개수
     */
    public int coinChange(int[] coins, int amount) {
        // [1단계] 상태 정의: dp[i]는 금액 i를 만들기 위해 필요한 최소 동전 개수
        int[] dp = new int[amount + 1];

        // [2단계] 초기값 설정: 최소값을 구해야 하므로 큰 값(amount + 1)으로 채우기
        java.util.Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // 0원을 만드는 데 필요한 동전 개수는 0개

        // [3단계] 점화식: 각 동전을 하나씩 써보면서 배열을 갱신
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 현재 구하려는 금액(i)이 동전 단위(coin)보다 크거나 같을 때만 사용 가능
                if (i >= coin) {
                    // 현재 기록된 최소 개수와 동전을 하나 썼을 때의 남은 금액(i - coin)의 최소 개수 + 1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 결과값(dp[amount]) 반환
        // 결과가 초기값(큰 값)이라면 해당 금액을 만들 수 없으므로 -1 반환
        return dp[amount] > amount ? -1 : dp[amount];
    }
}