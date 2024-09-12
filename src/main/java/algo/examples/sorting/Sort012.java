package algo.examples.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// } Driver Code Ends
//User function template for Java

class Solution {

    public void printArr(int arr[]) {
        for (int ix = 0; ix < arr.length; ix++) {
            System.out.print(arr[ix] + " ");
        }
    }
    public void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        System.out.println(String.format("Swapping from %d to %d", x, y));
        printArr(arr);
        System.out.println();
    }

    // Function to segragate 0s, 1s and 2s
    public void sort012(int arr[], int n) {
        int zeroOcc = 0;
        int oneOcc = 0;
        int twoOcc = 0;
        for (int ix = 0; ix < n; ix++) {
            if (arr[ix] == 0) zeroOcc++;
            else if (arr[ix] == 1) oneOcc++;
            else twoOcc++;
        }
        int curIx = 0;
        while (zeroOcc > 0) {
            arr[curIx++] = 0;
            --zeroOcc;
        }
        while (oneOcc > 0) {
            arr[curIx++] = 1;
            --oneOcc;
        }
        while (twoOcc > 0) {
            arr[curIx++] = 2;
            --twoOcc;
        }
    }
}

//{ Driver Code Starts.

public class Sort012 {

    public static void main(String[] args) throws IOException {
        String inputLine[] = null;
        int[] arr;
        if (args.length > 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
            while (t-- > 0) {
                inputLine = br.readLine().trim().split(" ");
            }
            arr = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
        } else {
            arr = new int[]{2, 1, 2, 2, 1, 0, 2, 1, 2, 2, 0, 1, 2, 1, 2, 0, 2, 1, 2, 0};
        }

        Solution ob = new Solution();
        ob.sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}


// } Driver Code Ends