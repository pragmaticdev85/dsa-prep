package com.mycompany.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class FindMaxNMinElement {
    public static MaxMinEl get(int[] arr) {

        return null;
    }
    public static void main(String[] args) {
        int[] a = {2, 1, -2, 4, 5, 0, 3};
        System.out.println(get(a));
    }
}
@Data
@AllArgsConstructor
@ToString
class MaxMinEl{
    private int minEl;
    private int maxEl;
}
