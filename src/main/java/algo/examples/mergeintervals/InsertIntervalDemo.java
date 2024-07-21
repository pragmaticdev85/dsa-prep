package algo.examples.mergeintervals;

import algo.examples.utils.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervalDemo {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);
        newIntervals[newIntervals.length - 1] = newInterval;
        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));
        int[] cur = newIntervals[0];
        List<int[]> res = new LinkedList<>();
        for (int[] interval : newIntervals) {
            if (cur[1] >= interval[0]) {
                cur[1] = Math.max(cur[1], interval[1]);
            } else {
                res.add(cur);
                cur = interval;
            }
        }
        res.add(cur);
        return Util.convertListToArr(res);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3}, {6, 9}};
        Util.printArr(input);
        int[] insertEl = {2, 5};
        InsertIntervalDemo demo = new InsertIntervalDemo();
        int[][] output = demo.insert(input, insertEl);
        Util.printArr(output);
    }
}
