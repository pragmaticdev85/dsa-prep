package algo.examples.twopointers;

public class FindUnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arrayOne = {1, 3, 4, 5, 7};
        int[] arrayTwo = {2, 3, 5, 7, 8};

        int arrOnePtr = 0;
        int arrTwoPtr = 0;
        while (arrOnePtr < arrayOne.length && arrTwoPtr < arrayTwo.length) {
            if (arrayOne[arrOnePtr] == arrayTwo[arrTwoPtr]) {
                System.out.print(arrayOne[arrOnePtr++] + " ");
                ++arrTwoPtr;
            } else if (arrayOne[arrOnePtr] > arrayTwo[arrTwoPtr]) {
                System.out.print(arrayTwo[arrTwoPtr++] + " ");
            } else if (arrayOne[arrOnePtr] < arrayTwo[arrTwoPtr]) {
                System.out.print(arrayOne[arrOnePtr++] + " ");
            }
        }
    }
}
