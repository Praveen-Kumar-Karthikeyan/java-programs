package arrays.twopointers.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedArr {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println("No of unique elements " + bruteForceApproach(numbers));
    }

    public static int bruteForceApproach(int[] numbers) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : numbers) {
            uniqueElements.add(num);
        }
        return uniqueElements.size();
    }

    // TN2605280002301
    public static int removeDuplicate(int[] numbers) {
        int leftpointer = 0;
        for (int rightPointer = leftpointer + 1; rightPointer < numbers.length;
             rightPointer++) {
            if (numbers[leftpointer] != numbers[rightPointer]) {
                leftpointer++;
                numbers[leftpointer] = numbers[rightPointer];
            }
        }
        return leftpointer + 1;
    }
}