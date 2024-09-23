package algo.examples.miscelaneous;

import java.util.ArrayList;
import java.util.List;

public class FibonacciDemo {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        int ix = 2;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int prevVal = 0;
        while (ix < 30) {
            prevVal = list.get(ix - 1) + list.get(ix - 2);
            list.add(prevVal);
            ++ix;
        }
        System.out.println(list);
        System.out.printf("Time taken: %d ms%n", System.currentTimeMillis() - st);
    }
}
