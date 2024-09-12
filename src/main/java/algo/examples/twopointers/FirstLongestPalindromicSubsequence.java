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
        final String input = "abcdeabbbbbafkjada";
        int ptr1 = 0;
        int ptr2 = input.length() - 1;
        String largestSubSeq = "";
        String iterStr = "";
        while (ptr1 < ptr2) {
            if ((iterStr = isPalindrome(input, ptr1, ptr2)) != null) {
                if (largestSubSeq.length() <= iterStr.length()){
                    largestSubSeq = iterStr;
                }
            }
            if (--ptr2 == ptr1) {
                ++ptr1;
                ptr2 = input.length() - 1;
            } else if (ptr1 == input.length() - 1) {
                break;
            }
        }
        System.out.format("Result: [%s]", largestSubSeq);
    }
}
