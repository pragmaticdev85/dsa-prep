package algo.examples.utils;

import java.util.List;

public class Util {
    public static void printArr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] nestedArr : arr) {
            sb.append("[").append(nestedArr[0]).append(", ").append(nestedArr[1]).append("], ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }

    public static int[][] convertListToArr(final List<int[]> list) {
        int[][] result = new int[list.size()][list.get(0).length];
        for (int ix = 0; ix < list.size(); ix++) {
            result[ix][0] = list.get(ix)[0];
            result[ix][1] = list.get(ix)[1];
        }
        return result;
    }
}