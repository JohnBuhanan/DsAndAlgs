package main.hackerrank.dynamicprogramming;

public class StockMax {
    public void run() {
        long test1 = stockmax(new int[]{5, 3, 2}, 0);
        long test2 = stockmax(new int[]{1, 2, 100}, 0);
        long test3 = stockmax(new int[]{1, 3, 1, 2}, 0);
    }

    static long stockmax(int[] prices, int index) {
        if (prices.length - 1 <= index)
            return 0;

        // Start by finding the all time high?
        int maxIndex = index;
        long maxValue = 0;

        // This can be a recursive call so we need to grab the next subarray.
//        int subarrayLength = prices.length - index;
        long[] buyPrices = new long[prices.length];

        for (int i = index; i < prices.length; i++) {
            int price = prices[i];
            if (i > 0) {
                buyPrices[i] = buyPrices[i - 1] + price;
            } else {
                buyPrices[i] = price;
            }

            if (maxValue <= price) {
                maxValue = price;
                maxIndex = i;
            }
        }

        // We now have the maxIndex to split on.
        int numSharesBought = maxIndex - index;
        long paid = 0;

        if (maxIndex > 0) {
            paid = buyPrices[maxIndex - 1];
        }

        long profit = (numSharesBought * maxValue) - paid;

        return profit + stockmax(prices, maxIndex + 1);
    }
}
