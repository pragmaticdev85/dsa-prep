package algo.examples.twopointers;

public class CheckIfSubstringIsPartOfGivenString {
    public static void main(String[] args) {
        final String[] inputs = new String[]{"LKJLKJLKJLKJLJLKJSTREPSILSLKJ:LKJ:J:LJKLJL","abcdabcdabcabcdf"};
        final String[] textToMatches = new String[]{"STREPSILS","abcdf"};
        int noOfInputs = 2;

        for (int ix = 0; ix < noOfInputs; ix++) {
            final String input = inputs[ix];
            final String textToMatch = textToMatches[ix];

            char[] inputChArr = input.toCharArray();
            char[] textToMatchChArr = textToMatch.toCharArray();
            int fixedPtr = 0;
            int iPtr = 0;
            int tPtr = 0;
            boolean prevCharMatched = false;
            boolean matchingFinished = false;
            while (iPtr < inputChArr.length) {
                System.out.format("Comparing [%s] with [%s]", textToMatchChArr[tPtr], inputChArr[iPtr]);
                System.out.println();
                if (textToMatchChArr[tPtr] == inputChArr[iPtr]) {
                    if (!prevCharMatched) prevCharMatched = true;
                    if (tPtr == textToMatchChArr.length - 1) {
                        System.out.format("Input: [%s], Searched for: [%s]; Matched", input, textToMatch);
                        System.out.println();
                        matchingFinished = true;
                        break;
                    }
                    ++tPtr;
                    ++iPtr;
                } else {
                    if (prevCharMatched) {
                        System.out.format("Resetting the j pointer to zero and iPtr to [%d]", (fixedPtr + 1));
                        System.out.println();
                        iPtr = ++fixedPtr;
                        tPtr = 0;
                    }
                    ++iPtr;
                }
            }
            if (matchingFinished) continue;
            System.out.format("Input: [%s], Searched for: [%s]; No match", input, textToMatch);
            System.out.println();
        }
    }
}
