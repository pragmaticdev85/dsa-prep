package algo.examples.miscelaneous;

import java.util.Arrays;

public class ThreeSumDemo {
    private static int[] findThreeSum(int[] arr, int targetSum) {
        for (int ix = 0; ix < arr.length; ix++) {
            for (int jx = ix + 1; jx < arr.length; jx++) {
                for (int kx = jx + 1; kx < arr.length; kx++) {
                    if (arr[ix] + arr[kx] + arr[kx - jx] == targetSum) {
                        return new int[]{arr[ix], arr[kx], arr[kx - jx]};
                    }
                }
            }
        }
        return new int[]{-1,-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6, 3, 8, 34, 12, 45, 6997};
        int targetSum = 7001;
        long st = System.currentTimeMillis();
        System.out.println(Arrays.toString(findThreeSum(arr, targetSum)));
        System.out.printf("Elapsed Time: %d ms%n", (System.currentTimeMillis() - st));
    }
}
