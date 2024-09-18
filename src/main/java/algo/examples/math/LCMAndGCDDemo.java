package algo.examples.math;

public class LCMAndGCDDemo {
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd (a, b);
    }
    public static void main(String[] args) {
        int[][] inputs = new int[2][2];
        inputs[0] = new int[]{25,15};
        inputs[1] = new int[]{15,45};
        for (int[] input: inputs) {
            System.out.println("=======================");
            System.out.printf("LCM of numbers: %d and %d is: %d%n", input[0], input[1], lcm(input[0], input[1]));
            System.out.printf("GCD of numbers: %d and %d is: %d%n", input[0], input[1], gcd(input[0], input[1]));
        }
    }
}
