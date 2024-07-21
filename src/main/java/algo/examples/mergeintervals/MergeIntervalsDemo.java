package algo.examples.mergeintervals;

import algo.examples.utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsDemo {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            arr[i][0] = res.get(i)[0];
            arr[i][1] = res.get(i)[1];
        }
        return arr;
    }

    public static void main(String[] args) {
        MergeIntervalsDemo demo = new MergeIntervalsDemo();
        int[][] input = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println("Before merge");
        Util.printArr(input);
        int[][] mergedOutput = demo.merge(input);
        System.out.println("After merge");
        Util.printArr(mergedOutput);
    }
}