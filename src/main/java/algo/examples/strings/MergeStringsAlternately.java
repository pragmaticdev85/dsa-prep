package algo.examples.strings;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pqrstu"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        char[] mergedArr = new char[word1Arr.length + word2Arr.length];
        int w1Ptr = 0;
        int w2Ptr = 0;
        while (w1Ptr < word1Arr.length || w2Ptr < word2Arr.length){
            if (w1Ptr < word1Arr.length){
                mergedArr[i++] = word1Arr[w1Ptr++];
            }
            
            if (w2Ptr < word2Arr.length){
                mergedArr[i++] = word2Arr[w2Ptr++];
            }            
        }        
        return String.valueOf(mergedArr);
    }
  
}
