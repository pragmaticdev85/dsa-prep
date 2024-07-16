package algo.examples.twopointers;

public class FindMaximumSumSubArray {
    private static int sum(int[] arr, int a, int b) {
        int sum = 0;
        for (int ix = a; ix <= b; ix++) {
            sum += arr[ix];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = Integer.MIN_VALUE;
        int maxSumLPtr = -1;
        int maxSumRPtr = -1;
        int leftPtr = 0;
        int rightPtr = input.length - 1;
        while (leftPtr < rightPtr) {
            int curSum = sum(input, leftPtr, rightPtr);
            if (maxSum <= curSum) {
                maxSum = curSum;
                maxSumLPtr = leftPtr;
                maxSumRPtr = rightPtr;
            }
            if (--rightPtr == leftPtr) {
                rightPtr = input.length - 1;
                ++leftPtr;
            } else if (leftPtr == (input.length - 1)) {
                break;
            }
        }
        for (int ix = maxSumLPtr; ix <= maxSumRPtr; ix++){
            System.out.print(input[ix] + " ");
        }
    }
}
