package algo.examples.miscelaneous;

import java.util.Arrays;

public class MoveZerosArrDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 12, 13, 0, 14};
        int ptr = 0;
        for (int num: arr) {
            if (num != 0) arr[ptr++] = num;
        }
        while (ptr < arr.length) {
            arr[ptr++] = 0;
        }
        System.out.println(Arrays.toString(arr));

    }
}
