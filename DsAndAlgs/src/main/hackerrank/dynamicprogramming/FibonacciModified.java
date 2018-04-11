package main.hackerrank.dynamicprogramming;

import java.math.BigInteger;

public class FibonacciModified {
    public void run() {
        BigInteger test = fibonacciModified(0, 1, 5);
    }

    static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger[] fibNums = new BigInteger[n + 1];

        fibNums[1] = new BigInteger(String.valueOf(t1));
        fibNums[2] = new BigInteger(String.valueOf(t2));
        // Complete this function
        for (int i = 3; i <= n; i++) {
            fibNums[i] = fibNums[i - 1].multiply(fibNums[i - 1]).add(fibNums[i - 2]);
        }

        return fibNums[n];
    }
}
