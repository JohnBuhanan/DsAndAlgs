package main.hackerrank.dynamicprogramming;

public class StockMax2 {
    public void run() {
        long test1 = getMaxProfit(new int[]{5, 3, 2});
        long test2 = getMaxProfit(new int[]{1, 2, 100});
        long test3 = getMaxProfit(new int[]{1, 3, 1, 2});
    }

    public static long getMaxProfit(int[] prices) {
        long profit = 0L;
        int maxSoFar = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] >= maxSoFar) {
                maxSoFar = prices[i];
            }
            profit += maxSoFar - prices[i];
        }
        return profit;
    }
}
