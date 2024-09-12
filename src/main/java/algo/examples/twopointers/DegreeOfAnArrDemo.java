package algo.examples.twopointers;
import java.util.*;
public class DegreeOfAnArrDemo {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}
class Solution {
    public int findShortestSubArray(int[] nums) {
        int max= -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max) max = nums[i];
        }
        System.out.println("Max: " + max);

        MinMax [] minmax = new MinMax[max+1];
        int maxfreq = 0;
        for(int i=0; i<nums.length; i++){
            if(minmax[nums[i]]==null) minmax[nums[i]] = new MinMax(i);
            minmax[nums[i]].max = i;
            minmax[nums[i]].count++;

            if(minmax[nums[i]].count>maxfreq) maxfreq = minmax[nums[i]].count;
        }
        System.out.println("Input: " + Arrays.toString(nums) + "; minmax: " + Arrays.toString(minmax));

        int minarray = Integer.MAX_VALUE;
        for(int i=0; i<minmax.length; i++){
            if(minmax[i] != null && minmax[i].count == maxfreq)
                minarray = Math.min(minarray, minmax[i].max-minmax[i].min+1);
        }
        return minarray;
    }

    private class MinMax{
        int count = 0;
        int min = -1;
        int max = -1;

        public MinMax(int i){
            min =i;
            max =i;
        }

        public String toString() {
            return "Count: " + count + "; min: " + min + "; max: " + max;
        }
    }
}