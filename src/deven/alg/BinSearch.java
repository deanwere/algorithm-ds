package deven.alg;

import java.io.IOException;

public class BinSearch {

    public static void main(String[] args) throws IOException {
        // Create a random int[] array less than 13 elements
        int[] array =Utils.createRandomArray(true);

        // Display array elements and ask user to choose one
        Utils.displayArray(array);

        // User input one number
        int value = Utils.userInput();

        int index = binSearch(array, value);
        System.out.println("the index of " + value + " is :" + index);
    }

    public static int binSearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        /*
         * !!! Remember low <= high
         */
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
