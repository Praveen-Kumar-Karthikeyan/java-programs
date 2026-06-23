import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

//    Given an array of integers nums and an integer target, return indices of the two numbers such that
//    they add up to target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//    You can return the answer in any order.
//            Example 1:
//    Input: numbers = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0,1]

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 18;
//        System.out.println(Arrays.toString(twoSumBruteForce(numbers, target)));
        System.out.println(Arrays.toString(twoSumOptimized(numbers, target)));
    }

    // Brute Force Approach
    public static int[] twoSumBruteForce(int[] array, int target) {
        for (int left = 0; left < array.length; left++) {
            for (int right = left + 1; right < array.length; right++) {
                if (target == (array[left] + array[right])) {
                    return new int[]{left, right};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumOptimized(int[] numbers, int target) {

        Map<Integer, Integer> elementVisited = new HashMap<>(); // element and index
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            // a + b = target =>  a =  target - b;
            if (elementVisited.containsKey(complement)) {
                return new int[]{elementVisited.get(complement), i};
            }
            elementVisited.put(numbers[i], i);
        }
        return new int[]{};
    }

}
