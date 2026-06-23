package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainsDuplicate {

//    Given an integer array nums, return true if any value appears at least twice in the array,
//    and return false if every element is distinct.
//    Example 1:
//    Input: nums = [1,2,3,1]
//    Output: true
//    Explanation:
//    The element 1 occurs at the indices 0 and 3.
//    Example 2:
//    Input: nums = [1,2,3,4]
//    Output: false
//    Explanation:
//    All elements are distinct.


    public static void main(String[] args) {

        int[] numberArr = {1, 2, 3, 4};
//        System.out.println(isContainsDuplicate(numberArr));
//        System.out.println(isContainsOptimizedApproach(numberArr));
        Set<String> strings = new HashSet<>();
        System.out.println(strings.add("Hello Shae I'm Tyrion Lannister, how you doing where are you ?"));
        System.out.println(strings.add("Hello Shae I'm Tyrion Lannister, how you doing where are you ?"));
    }

    // Brute Force Approach - Time complexity - o(n*n) - Space complexity - o(1)
    public static boolean isContainsDuplicate(int[] numArr) {

        for (int i = 0; i < numArr.length; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[i] == numArr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // optimized Approach -
    public static boolean isContainsOptimizedApproach(int[] numbers) {
        List<Integer> numberList = new ArrayList<>();
        for (int num : numbers) {
            if (numberList.contains(num)) {
                return true;
            }
            numberList.add(num);
        }
        return false;
    }
}
