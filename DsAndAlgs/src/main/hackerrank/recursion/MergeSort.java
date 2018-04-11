package main.hackerrank.recursion;

public class MergeSort {
    public void run() {
//        int[] test1 = new int[]{8, 7, 4, 3, 2, 1, 5, 6, 9, 10, 20, 15, 11, 13, 12, 14, 17, 16, 19, 18};
//        long countTest1 = mergeSort(test1);

        int[] test2 = new int[]{2, 1, 3, 1, 2};
        long countTest2 = mergeSort(test2);
    }

    public static long mergeSort(int[] array) {
        // Complete this function
        return mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    public static long mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return 0;
        }

        long count = 0;

        int middle = (leftStart + rightEnd) / 2;
        count += mergeSort(array, temp, leftStart, middle);
        count += mergeSort(array, temp, middle + 1, rightEnd);
        count += mergeHalves(array, temp, leftStart, rightEnd);

        return count;
    }

    public static long mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1; // Total # of elements to copy over.

        // Init counters
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        long count = 0;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
                count += leftEnd - left + 1;
            }
            index++;
        }


        // Once we are done merging, copy over any remaining elements.
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);

        return count;
    }
}
