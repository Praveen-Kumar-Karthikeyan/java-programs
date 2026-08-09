package arrays.twopointers.easy;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12};
        moveZeros(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void moveZeros(int[] numbers) {
        int leftPoint = 0;
        for (int rightPoint = 0; rightPoint < numbers.length; rightPoint++) {
            if (numbers[rightPoint] != 0) {
                int temp = numbers[rightPoint];
                numbers[rightPoint] = numbers[leftPoint];
                numbers[leftPoint] = temp;
                leftPoint++;
            }
        }
    }
}
