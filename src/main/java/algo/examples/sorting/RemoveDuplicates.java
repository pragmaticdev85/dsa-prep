// Java Program to Remove Duplicates
// From an Array without Using Set
package algo.examples.sorting;
import java.util.Arrays;

/**
 * Given an array of numbers mixed with duplicates
 * <br/>Implement an algorithm to merge the duplicates
 */
public class RemoveDuplicates {
    public static int[] deduplicate(int[] arr) {
        // Sort the array
        Arrays.sort(arr);
        // Initialize the j pointer
        int j = 0;
        // Start iterating the array from the 1st index
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                // Move unique element to the next position
                arr[++j] = arr[i];
            }
        }
        // Return copy of array upto index j without duplicates
        return Arrays.copyOf(arr, j + 1);
    }

      // Main Function
    public static void main(String[] args) {
        // Initialize an array
        int[] arr = {1,5,2,6,2,3,3,3,4,5,5,6};
        long st = System.currentTimeMillis();
        int[] result = deduplicate(arr);
        System.out.println("Array without Duplicates: " +Arrays.toString(result));
        System.out.printf("Elapsed Time: %d ms", (System.currentTimeMillis() - st));
    }
}
