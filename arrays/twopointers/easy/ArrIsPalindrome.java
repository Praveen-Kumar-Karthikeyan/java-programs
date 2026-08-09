package arrays.twopointers.easy;

public class ArrIsPalindrome {

    //    Check if an Array is a Palindrome

    public static void main(String[] args) {
        int[] numbers = {5, 2, 1, 3, 5};
        System.out.println(isArrPalindrome(numbers));
    }

    public static boolean isArrPalindrome(int[] numbers) {

        for (int leftElement = 0,
             rightElement = numbers.length - 1; leftElement <= rightElement; leftElement++, rightElement--) {
            if (numbers[leftElement] == numbers[rightElement]) {
                if (leftElement == rightElement)
                    return true;
            } else
                return false;
        }
        return false;
    }
}
