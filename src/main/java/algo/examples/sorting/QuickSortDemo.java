package algo.examples.sorting;

import java.util.Arrays;

public class QuickSortDemo {

    private static void swap(int[] arr, int ix, int jx) {
        if (ix < arr.length && jx < arr.length) {
            int temp = arr[ix];
            arr[ix] = arr[jx];
            arr[jx] = temp;
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pix = low - 1;
        for (int ix = low; ix < high; ix++) {
            if (arr[ix] <= pivot) {
                pix++;
                swap(arr, ix, pix);
            }
        }
        swap(arr, pix + 1, high);
        return pix + 1;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pix = partition(arr, low, high);
            quickSort(arr, low, pix - 1);
            quickSort(arr, pix + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, -11, -100, 24, 3, 10, 9, 2};
        long startInMillis = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis() - startInMillis + " ms");
    }
}
