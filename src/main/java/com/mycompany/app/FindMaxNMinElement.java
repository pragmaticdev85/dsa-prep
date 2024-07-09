package com.mycompany.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

public class FindMaxNMinElement {
    public static MaxMinEl get(int[] arr) {
        int minEl = Integer.MAX_VALUE;
        int maxEl = Integer.MIN_VALUE;
        for (int ix = 0; ix < arr.length; ix++) {
            if (arr[ix] > maxEl) maxEl = arr[ix];
            if (arr[ix] < minEl) minEl = arr[ix];
        }
        return MaxMinEl.builder().maxEl(maxEl).minEl(minEl).build();
    }
    public static void main(String[] args) {
        int[] a = {2, 1, -2, 4, 5, 0, 3};
        System.out.println(get(a));
    }
}
@Builder
@AllArgsConstructor
@ToString
class MaxMinEl{
    private int minEl;
    private int maxEl;
}
