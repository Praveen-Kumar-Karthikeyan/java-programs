package arrays.twopointers.easy;

public class RemoveDuplicateFromSortedArr {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println("No of unique elements " + removeDuplicate(numbers));
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