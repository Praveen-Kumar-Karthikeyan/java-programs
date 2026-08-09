package arrays.twopointers.easy;

import java.util.Arrays;

public class ArrReversal {

//    Focus: Understand how left/right pointers move
//    Reverse an Array ⭐

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        arrReversal(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    public static void arrReversal(int[] numArr) {
        for (int leftElement = 0,
             rightElement = numArr.length - 1; leftElement < rightElement; leftElement++, rightElement--) {
            int temp = numArr[leftElement];
            numArr[leftElement] = numArr[rightElement];
            numArr[rightElement] = temp;
        }
    }


}
