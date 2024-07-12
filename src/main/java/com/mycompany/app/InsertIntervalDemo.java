package com.mycompany.app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervalDemo {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        for (int ix = 0; ix < intervals.length; ix++) {
            newIntervals[ix] = intervals[ix];
        }
        newIntervals[newIntervals.length - 1] = newInterval;
        Arrays.sort(newIntervals, (a, b) -> Integer.compare(a[0], b[0]));
        int arrIx = 0;
        int nextIx = 1;
        int[] cur = newIntervals[0];
        List<int[]> res = new LinkedList<>();
        for (int ix = 0; ix < newIntervals.length; ix++) {
            if (cur[1] >= newIntervals[ix][0]) {
                cur[1] = Math.max(cur[1], newIntervals[ix][1]);
            } else {
                res.add(cur);
                cur = newIntervals[ix];
            }
        }
        res.add(cur);
        int[][] resArr = new int[res.size()][2];
        for (int ix = 0; ix < res.size(); ix++) {
            resArr[ix][0] = res.get(ix)[0];
            resArr[ix][1] = res.get(ix)[1];
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3}, {6, 9}};
        int[] insertEl = {2, 5};
        InsertIntervalDemo demo = new InsertIntervalDemo();
        int[][] output = demo.insert(input, insertEl);
        demo.printArr(output);
    }

    public void printArr(int[][] arr) {
        for (int ix = 0; ix < arr.length; ix++) {
            System.out.print("[" + arr[ix][0] + ", " + arr[ix][1] + "],");
        }
        System.out.println();
    }
}
