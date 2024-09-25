package algo.examples.sorting;

import java.util.*;
import java.io.*;

/**
 * <b>Problem Statement:</b>
 * <p>
 * Given array of 0s, 1s and 2s randomly placed,
 * <br/>implement an algorithm to sort them
 */
public class Sort012Two {
    private static void sort(int[] arr) {
        int zerosCnt = 0;
        int onesCnt = 0;
        int twosCnt = 0;
        for (int ix = 0; ix < arr.length; ix++) {
            switch (arr[ix]) {
                case 0:
                    zerosCnt++;
                    break;
                case 1:
                    onesCnt++;
                    break;
                case 2:
                    twosCnt++;
                    break;
            }
        }
        int curIx = 0;
        for (int ix = 0; ix < zerosCnt; ix++) arr[curIx++] = 0;
        for (int ix = 0; ix < onesCnt; ix++) arr[curIx++] = 1;
        for (int ix = 0; ix < twosCnt; ix++) arr[curIx++] = 2;
        final StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append(arr[0]);
        for (int ix = 1; ix < arr.length; ix++) {
            sb.append(" ").append(arr[ix]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        sort(new int[]{1, 2, 0, 1, 2, 0, 0, 1, 1, 1, 2, 2, 0});
        System.out.printf("Elapsed Time: %d ms", (System.currentTimeMillis() - st));
    }
}
