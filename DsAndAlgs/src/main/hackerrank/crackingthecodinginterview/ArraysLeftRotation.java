package main.hackerrank.crackingthecodinginterview;

public class ArraysLeftRotation {
    public void run() {
        int[] test1 = arrayLeftRotation(new int[]{1, 2, 3, 4, 5}, 4);
    }

    public static int[] arrayLeftRotation(int[] a, int d) {
        int actualD = d % a.length;
        int[] newA = new int[a.length];
        // a = [1, 2, 3, 4, 5], d = 4
        // 4 -> 0
        // 3 -> 4
        // 2 -> 3
        // 1 -> 2
        // 0 -> 1
        for (int i = 0; i < a.length; i++) {
            int indexToUse = i - actualD;
            if (indexToUse < 0)
                indexToUse += a.length; // Can't have negative. Must wrap.
            newA[indexToUse] = a[i];
        }

        return newA;
    }
}
