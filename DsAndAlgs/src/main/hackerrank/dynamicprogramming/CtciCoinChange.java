package main.hackerrank.dynamicprogramming;

import java.util.HashMap;

public class CtciCoinChange {
    public void run() {
        long test = makeChange(new int[]{2, 5, 3, 6}, 10);
    }

    public static long makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0, new HashMap<String, Long>());
    }

    public static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
        if (money == 0) { // Recursion has zeroed out, we found a way!
            return 1;
        }

        if (index >= coins.length) { // Index is past the length of the coins array. Return failed attempt.
            return 0;
        }

        String key = money + "_" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int amountWithCoin = 0;
        long ways = 0;

        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin; // .10 = .35 - .25 -> -.15 = .35 -.5
            ways += makeChange(coins, remaining, index + 1, memo);
            amountWithCoin += coins[index]; // amountWithCoin can overflow which triggers exit.
        }

        memo.put(key, ways);
        return ways;
    }
}
