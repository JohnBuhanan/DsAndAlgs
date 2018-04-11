package main.hackerrank.dynamicprogramming;

import java.util.Arrays;

public class MaximumSubarray {
    public void run() {
        int[] test1 = maxSubarray(new int[]{1, 2, 3, 4});
        int[] test2 = maxSubarray(new int[]{2, -1, 2, 3, 4, -5});
        int[] test3 = maxSubarray(new int[]{-1, -2, -3, -4, -5, -6});


    }

    static int[] maxSubarray(int[] a) {
        // Kadane's algorithm to get largest subarray?
        int kadanesAlgorithmSum = getKadanesAlgorithmSum(a);

        // order doesn't matter for sum of largest subsequence.
        // Just sort the array and pluck all the non-negative values out of it to sum them.
        int greatestSubsequenceSum = getGreatestSubsequenceSum(a);

        return new int[]{kadanesAlgorithmSum, greatestSubsequenceSum};
    }

    static int getKadanesAlgorithmSum(int[] a) {
        int maxCurrent, maxGlobal;
        maxCurrent = maxGlobal = a[0];

        for (int i = 1; i < a.length; i++) {
            maxCurrent = Math.max(a[i], maxCurrent + a[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    static int getGreatestSubsequenceSum(int[] a) {
        Arrays.sort(a);

        int greatestSubsequenceSum = a[a.length - 1]; // Set to value in last index.

        // iterate over the rest
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > 0) {
                greatestSubsequenceSum += a[i];
            } else {
                break;
            }
        }

        return greatestSubsequenceSum;
    }
}
