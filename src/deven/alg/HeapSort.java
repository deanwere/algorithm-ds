package deven.alg;

/*
 * Pseudo code
 *
 * sort(array) {
 *    buildMaxHeap(array);
 *
 *    for i = array.length -1; i <= 1; i-- {
 *        swap(array[0], array[i]);
 *        heapify(array, 0, i);
 *    }
 * }
 *
 * buildMaxHeap(int[] array) {
 *     for i = array.length / 2 -1; i >=0; i-- {
 *         heapify(array, i, arrary.length);
 *     }
 * }
 *
 * heapify(int array, int index, int max) {
 *     left = 2 * index + 1;
 *     right = 2 * index + 2;
 *     largest = index;
 *
 *     # !!! should use largest to compare left and right
 *     # !!! first compare index and left to get the larger one of two
 *     # !!! then  compare the larger one of index and left with right to get
 *     # !!! the largest
 *     if (array[largest] < array[left] && left < max) {
 *         largest = left;
 *     }
 *
 *     if (array[largest] < array[right] && right < max) {
 *         largest = right;
 *     }
 *
 *     if (largest != index) {
 *         swap(array[index], array[largest]);
 *         heapify(array, largest, max);
 *     }
 * }
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = Utils.createRandomArray(false);

        System.out.println("Befor sort:");
        System.out.println();
        Utils.displayArray(array);

        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);

        System.out.println();
        System.out.println("After sort:");
        Utils.displayArray(array);
    }

    public void sort(int[] array) {
        buildMaxHeap(array);

        /*
         * !!! Be careful of first the nth max value is array.length -1.
         * !!! The last one is 1
         *
         * !!! Be careful nthMax >= 1
         */
        for (int nthMax = array.length -1; nthMax >= 1; nthMax--) {
            Utils.swap(array, 0, nthMax);
            heapify(array, 0, nthMax);
        }
    }

    private void heapify(int[] array, int index, int max) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < max && array[largest] < array[left]) {
            largest = left;
        }
        if (right < max && array[largest] < array[right]) {
            largest = right;
        }

        if (largest != index) {
            Utils.swap(array, index, largest);
            heapify(array, largest, max);
        }

    }

    private void buildMaxHeap(int[] array) {
        /*
         * !!! Be careful i >= 0
         */
        for (int i = array.length /2 - 1; i >=0; i--) {
            heapify(array, i, array.length);
        }

    }

}
