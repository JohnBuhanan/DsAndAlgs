package main.hackerrank.dynamicprogramming;

import java.util.Arrays;

public class EqualChocolates {
    public void run() {
        long test = find_min_actions(new int[]{0, 4, 4});
    }

    public static long find_min_actions(int[] cookies) {

        Arrays.sort(cookies);

        long sum = Long.MAX_VALUE;

        for (int base = 0; base < 3; base++) {
            int current_sum = 0;
            for (int i = 0; i < cookies.length; i++) {
                int delta = cookies[i] - cookies[0] + base;
                current_sum += (int) delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;
            }
            sum = Math.min(current_sum, sum);
        }

        return sum;
    }

//    static int equal(int[] arr) {
//        Arrays.sort(arr);
//
//        // Complete this function
//        int numOperationsRequired = 0;
//
//        return 0;
//    }
}
