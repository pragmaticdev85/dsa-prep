package algo.examples.strings;

public class RenderDenomination {
    private static final int[] HIGHER_DENOMINATIONS = {1_000_000, 1_000, 1 };
    private static final String[] DENOMINATION_STRINGS = { "Million", "Thousand", "" };
    private static final String[] TENS_DENOMINATION_STRINGS = {"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred"};
    private static final String[] NUMBERS_FROM_ONE_TO_TWENTY = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};

    private static String renderLessThanThousandText(int lessThanThousandNum) {
        final StringBuilder sb = new StringBuilder();
        int hundreds = lessThanThousandNum / 100;
        if (hundreds > 0) sb.append(String.format("%s Hundred ", NUMBERS_FROM_ONE_TO_TWENTY[hundreds - 1]));
        lessThanThousandNum %= 100;
        int tens = 0;
        if (lessThanThousandNum > 19) {
            tens = lessThanThousandNum / 10;
            lessThanThousandNum %= 10;
        }
        if (tens > 0) {
            sb.append(String.format("%s %s", TENS_DENOMINATION_STRINGS[tens - 1], lessThanThousandNum > 0 ? NUMBERS_FROM_ONE_TO_TWENTY[lessThanThousandNum - 1] : ""));
        } else {
            sb.append(String.format("%s", lessThanThousandNum > 0 ? NUMBERS_FROM_ONE_TO_TWENTY[lessThanThousandNum - 1] : ""));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int inputNumber = 7_890_811;

        final StringBuilder sb = new StringBuilder();
        for (int ix = 0; ix < HIGHER_DENOMINATIONS.length; ix++) {
            int denomination = HIGHER_DENOMINATIONS[ix];
            int countOfGivenDenomination = inputNumber / denomination;
            inputNumber %= denomination;
            sb.append(String.format("%s %s ", countOfGivenDenomination < 1000 ?
                    renderLessThanThousandText(countOfGivenDenomination) : countOfGivenDenomination, DENOMINATION_STRINGS[ix]));
        }
        System.out.println(sb);
    }
}
