package main.hackerrank.dynamicprogramming;

public class StringReduction {
    public void run() {
        int test = stringReduction("cab");
    }

    static int stringReduction(String s) {
        // Complete this function
        // Count the number of occurences of each letter in the input string [numA, numB, numC]
        int aCount = s.length() - s.replace("a", "").length();
        int bCount = s.length() - s.replace("b", "").length();
        int cCount = s.length() - s.replace("c", "").length();

        int zeroCounter = 0;
        // If two of these counts are 0, then return string.length
        if (aCount == 0)
            zeroCounter++;

        if (bCount == 0)
            zeroCounter++;

        if (cCount == 0)
            zeroCounter++;

        int moduloTotal = (aCount % 2) + (bCount % 2) + (cCount % 2);

        if (zeroCounter == 2)
            return s.length();
        else if (moduloTotal == 0 || moduloTotal == 3) { // Else if (all counts are even) or (all counts are odd), then return 2
            return 2;
        } else // Else, then return 1
            return 1;
    }
}
