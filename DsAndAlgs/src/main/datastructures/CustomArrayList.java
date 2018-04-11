package main.datastructures;



import java.util.Arrays;

public class CustomArrayList<T> {
    private int capacity = 8;
    private int currentSize = 0;
    private T[] innerArray = (T[]) new Object[capacity];

    public void run() {

    }

    public void checkCapacity() {
        if (currentSize >= capacity) {
            // Copy array to bigger array.
            capacity *= 2;
            innerArray = Arrays.copyOf(innerArray, capacity);
        }
    }

    public void add(T thing) {
        innerArray[currentSize] = thing;
        currentSize++;
        checkCapacity();
    }

//    public void remove(T thing) {
//        int indexToRemove = -1;
//        for (int i = 0; i < currentSize; i++) {
//            if (innerArray[i] == thing) {
//                indexToRemove = i;
//                break;
//            }
//        }
//
//        if (indexToRemove == -1)
//            return;
//
//        // src − This is the source array.
//        // srcPos − This is the starting position in the source array.
//        // dest − This is the destination array.
//        // destPos − This is the starting position in the destination data.
//        // length − This is the number of array elements to be copied.
//
//        T[] temp = System.arraycopy(innerArray, 0, );
//        Arrays.copyOfRange(innerArray, 0, 3);
//
//    }
}
