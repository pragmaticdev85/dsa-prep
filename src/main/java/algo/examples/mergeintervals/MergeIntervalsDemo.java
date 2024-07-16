package algo.examples.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsDemo {
    /*
    public int[][] removeElementAt(int[][] arr, int ix) {
        int[][] secArr = new int[arr.length - 1][2];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != ix) {
                secArr[j] = arr[i];
                j++;
            }
        }
        return secArr;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        printArr(intervals);
        int arrIx = 0;
        int nextIx = 1;
        while (nextIx < intervals.length && arrIx < nextIx) {
            if (intervals[arrIx][1] >= intervals[nextIx][0]) {
                intervals[arrIx] = new int[]{intervals[arrIx][0], Math.max(intervals[arrIx][1], intervals[nextIx][1])};
                intervals = removeElementAt(intervals, nextIx);
                printArr(intervals);
                arrIx = 0;
                nextIx = 1;
                continue;
            }
            ++arrIx;
            ++nextIx;
        }
        return intervals;
    }*/

    /*
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }

        if (max == 0) {
            return new int[][] { intervals[0] };
        }

        int[] timeTable = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
        }

        int resultSize = 0;
        int currEnd = -1;
        int currStart = -1;

        for (int i = 0; i < timeTable.length; i++) {
            if (timeTable[i] != 0) {
                if (currStart == -1) {
                    currStart = i;
                }
                currEnd = Math.max(timeTable[i] - 1, currEnd);
            }
            if (currEnd == i) {
                intervals[resultSize++] = new int[] { currStart, currEnd };
                currEnd = -1;
                currStart = -1;
            }
        }

        if (currStart != -1) {
            intervals[resultSize++] = new int[] { currStart, currEnd };
        }

        if (intervals.length == resultSize) {
            return intervals;
        }

        int[][] res = new int[resultSize][];
        for (int i = 0; i < resultSize; i++) {
            res[i] = intervals[i];
        }

        return res;
    }
    */

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }

        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return 0;
                }
                return a[0] < b[0]? -1 : 1;
            }
        });

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
    public void printArr(int[][] arr) {
        for (int ix = 0; ix < arr.length; ix++) {
            System.out.print("[" + arr[ix][0] + ", " + arr[ix][1] + "],");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeIntervalsDemo demo = new MergeIntervalsDemo();

        int[][] input = new int[][] {
                    {1, 3}, {2, 6}, {8, 10}, {15, 18}
                };

         /*
        int[][] input = new int[][] {
                {1,4},{0,2},{3,5}
        };*/
        int[][] mergedOutput = demo.merge(input);
        for (int ix = 0; ix < mergedOutput.length; ix++) {
            System.out.print("[" + mergedOutput[ix][0] + ", " + mergedOutput[ix][1] + "],");
        }
    }
}