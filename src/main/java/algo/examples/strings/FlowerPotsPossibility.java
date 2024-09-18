package algo.examples.strings;

public class FlowerPotsPossibility {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int ix = 0; ix < flowerbed.length; ix = ix + 2) {
            if (flowerbed[ix] == 0) {
                if (ix == (flowerbed.length - 1) || (flowerbed[ix] == flowerbed[ix + 1])) {
                    --n;
                } else {
                    ++ix;
                }
            }
        }
        return n <= 0;
    }
    public static void main(String[] args) {
        // System.out.println(canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 0}, 3));
        // System.out.println(canPlaceFlowers(new int[]{1, 1, 1, 1, 0, 0}, 3));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 1, 0, 0, 0}, 1));

    }
}
