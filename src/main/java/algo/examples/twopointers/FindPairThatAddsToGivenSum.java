package algo.examples.twopointers;

import java.util.Arrays;
import java.util.List;

public class FindPairThatAddsToGivenSum {
    private static boolean check(int[] arr, int a, int b, int target) {
        return (arr[a] + arr[b]) == target;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,2,8,11};
        int target = 10;
        int first = 0;
        int second = arr.length - 1;
        Arrays.sort(arr);
        while (first < second) {
            if (arr[first] + arr[second] == target) {
                System.out.println(List.of(arr[first], arr[second]));
                break;
            } else if (arr[first] + arr[second] > target) {
                second--;
            } else {
                first++;
            }
        }
    }
}
// Output: [2, 8]