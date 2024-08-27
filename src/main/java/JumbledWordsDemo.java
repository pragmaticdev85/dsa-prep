import java.util.*;

public class JumbledWordsDemo {

    private static int indexOf(List<String> list, final String s) {
        for (int ix = 0; ix < list.size(); ix++){
            if (sortedStr(s).equals(sortedStr(list.get(ix)))){
                return ix;
            }
        }
        return -1;
    }
    private static String sortedStr(final String inputStr) {
        List<String> fragments = new ArrayList<>(List.of(inputStr.split("")));
        Collections.sort(fragments);
        return String.join("", fragments);
    }
    public static void main(String[] args) {
        final String[] inputArr = new String[]{"pame","aepm","xyz","mape", "java","ajav"};
        List<String> inputList  = new ArrayList<>();
        Arrays.stream(inputArr).forEach(e -> inputList.add(e));
        for (int ix = 0; ix < inputList.size(); ix++){
            String s = inputList.get(ix);
            int matchedIx = indexOf(inputList, s);
            if (matchedIx > -1) {
                inputList.remove(s);
                inputList.add(matchedIx, s);
            }
        }
        System.out.println(inputList);
    }
}
