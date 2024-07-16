package algo.examples.twopointers;

public class FirstLongestPalindromicSubsequence {
    private static String isPalindrome(String input, int firstPtr, int secondPtr) {
        int first = firstPtr;
        int second = secondPtr;
        char[] chArr = input.toCharArray();
        while (first < second) {
            if (chArr[first] != chArr[second]) return null;
            ++first;
            --second;
        }
        return input.substring(firstPtr, secondPtr + 1);
    }

    public static void main(String[] args) {
        final String input = "abcdefkjada";
        int fPtr = 0;
        int sPtr = input.length() - 1;
        String largestSubSeq = "";
        String iterStr = "";
        while (fPtr < sPtr) {
            if ((iterStr = isPalindrome(input, fPtr, sPtr)) != null) {
                if (largestSubSeq.length() <= iterStr.length()){
                    largestSubSeq = iterStr;
                }
            }
            if (--sPtr == fPtr) {
                ++fPtr;
                sPtr = input.length() - 1;
            } else if (fPtr == input.length() - 1) {
                break;
            }
        }
        System.out.format("Result: [%s]", largestSubSeq);
    }
}
