package main.hackerrank.dynamicprogramming;

public class MaximumSubarrayModuloSum {
    public void run() {
//        long test = maximumSum(new long[]{3, 3, 9, 9, 5}, 7);
        long test = maximumSum(new long[]{3, 2, 7, 4}, 7);
    }

    static long maximumSum(long[] a, long m) {
        // Complete this function

        int newStartIndex = 0;
        long newMax = a[0];
        long[] maxSums = new long[a.length];
        maxSums[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            maxSums[i] = Math.max((maxSums[i - 1] + a[i]) % 7, a[i] % 7);
            if (newMax < maxSums[i]) {
                newMax = maxSums[i];
            }
        }

        return newMax;
    }
}
