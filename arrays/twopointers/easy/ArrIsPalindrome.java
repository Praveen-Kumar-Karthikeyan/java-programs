package arrays.twopointers.easy;

public class ArrIsPalindrome {

    //    Check if an Array is a Palindrome

    public static void main(String[] args) {
        int[] numbers = {4, 2, 5, 2, 4};
        System.out.println(isArrPalindrome(numbers));
    }

    public static boolean isArrPalindrome(int[] numbers) {
        for (int leftElement = 0,
             rightElement = numbers.length - 1; leftElement < rightElement; leftElement++, rightElement--) {
            if (numbers[leftElement] != numbers[rightElement])
                return false;
        }
        return true;
    }
}
