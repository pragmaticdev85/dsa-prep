package algo.examples.miscelaneous;

import java.util.Arrays;

public class TwoSumDemo {
    private static int[] findTwoSum(int[] arr, int targetSum) {
        for (int ix = 1; ix < arr.length; ix++) {
            for (int jx = (ix + 1); jx < arr.length; jx++) {
                if (arr[jx] + arr[jx - ix] == targetSum) {
                    return new int[]{arr[jx], arr[jx - ix]};
                }
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6, 3, 8, 34, 12, 45, 6997};
        int targetSum = 7000;
        System.out.println(Arrays.toString(findTwoSum(arr, targetSum)));
    }
}