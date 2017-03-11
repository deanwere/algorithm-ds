package deven.alg;

/*
 * Pseudo code
 *
 * sort(array) {
 *     quickSort(array, 0, array.length - 1);
 * }
 *
 * int quicksort(array, left, right) {
 *     # !!! Ensure more than one elements in the array
 *     if (left < right) {
 *         pivotIndex = partition(array, left, right);
 *         quickSort(array, left, pivotIndex - 1);
 *         quickSort(array, pivotIndex + 1, right)
 *     }
 *
 * partition(array, left, right) {
 *     pivotIndex = left + (right - left) / 2;
 *     Utils.swap(array, pivotIndex, right);
 *
 *     store = left;
 *     for (int i = left, i <= right - 1; i++) {
 *         if (array[i] <= array[right]) {
 *            Utils.swap(array, store, i);
 *            store++;
 *         }
 *     }
 *     Utils.swap(array, store, right);
 *     return store;
 * }
 * }
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = Utils.createRandomArray(false);

        System.out.println("Befor sort:");
        System.out.println();
        Utils.displayArray(array);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        System.out.println();
        System.out.println("After sort:");
        Utils.displayArray(array);

    }

    private void sort(int[] array) {
        quickSort(array, 0, array.length - 1);

    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }

    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        Utils.swap(array, pivotIndex, right);

        int store = left;
        for (int i = left; i <= right - 1; i++) {
            if (array[i] <= array[right]) {
                Utils.swap(array, store, i);
                store++;
            }
        }
        Utils.swap(array, store, right);

        return store;

    }

}
