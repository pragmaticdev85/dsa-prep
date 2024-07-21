package algo.examples.utils;

public class Util {
    public static void printArr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] nestedArr : arr) {
            sb.append("[").append(nestedArr[0]).append(", ").append(nestedArr[1]).append("], ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }
}
