package main.hackerrank.crackingthecodinginterview;//package johnbuhanan.com.lib.hackerrank.crackingthecodinginterview;
//
//import java.io.*;
//import java.util.*;
//
//public class BubbleSort {
//
//    public static int[] bubbleSort(int[] array, int length) {
//        int numSwaps = 0;
//        boolean isSorted = false;
//        int lastUnsorted = array.length - 1;
//        while(!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < array.length - 1; i++) { // need length - 1 here because last swap will go out of bounds.
//                if (array[i] > array[i + 1]) {
//                    swap(array, i, i + 1);
//                    numSwaps++;
//                    isSorted = false;
//                }
//            }
//            lastUnsorted--;
//        }
//
//        return new int[]{numSwaps, array[0], array[array.length - 1]};
//    }
//
//    public static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN.
//        //Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
//        int array[] = new int[length];
//        int i =0;
//        while(scanner.hasNextInt()) {
//            int element = scanner.nextInt();
//            array[i] = element;
//            i++;
//        }
//        Solution solution = new Solution();
//        int[] bubbleSortResults = solution.bubbleSort(array,length);
//        if(bubbleSortResults!=null && bubbleSortResults.length>=3) {
//            System.out.println("Array is sorted in "+bubbleSortResults[0]+" swaps.");
//            System.out.println("First Element: "+bubbleSortResults[1]);
//            System.out.println("Last Element: "+bubbleSortResults[2]);
//        }
//    }
//}