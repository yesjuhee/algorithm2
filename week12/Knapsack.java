import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public static void main(String[] args) {
        int[] weight = { 5, 10, 8, 7, 4, 6, 3, 9 };
        int[] value = { 20, 40, 35, 25, 15, 30, 10, 50 };
        int capacity = 50;

        Result result = knapsack(weight, value, capacity);

        System.out.println("최대 가치: " + result.maxValue);
        System.out.println("선택된 아이템: " + result.selectedItems);
    }

    public static Result knapsack(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 최대 가치
        int maxValue = dp[n][capacity];

        // 선택된 아이템 추적
        List<Integer> selectedItems = new ArrayList<>();
        int w = capacity;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(i - 1); // 아이템 인덱스 추가
                w -= weight[i - 1];
            }
        }

        return new Result(maxValue, selectedItems);
    }

    // 결과를 저장할 클래스
    static class Result {
        int maxValue;
        List<Integer> selectedItems;

        public Result(int maxValue, List<Integer> selectedItems) {
            this.maxValue = maxValue;
            this.selectedItems = selectedItems;
        }
    }
}