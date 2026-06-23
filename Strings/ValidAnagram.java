package Strings;

import java.util.Arrays;

public class ValidAnagram {
    //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    //Example 1:
    //Input: s = "anagram", t = "nagaram" -> <a-3>,<n-1>,<g-1>,<r-1>,<m-1>
    //Output: true
    //Example 2:
    //Input: s = "rat", t = "car"
    //Output: false
    // s and t consist of lowercase English letters. lower case letters from a - z its ACII values starts from 97-122

    public static void main(String[] args) {
        System.out.println(bestOptimizedApproach("madam", "adamm"));
//        System.out.println((int) 'z');
//        System.out.println((int) 'a');
//        System.out.println('a' - 'z');
//        int[] freq = new int[25];
//        System.out.println(freq.length);
    }

    public static boolean bestOptimizedApproach(String one, String two) {
        if (one.length() != two.length())
            return false;
        int[] freq = new int[25];
        for (int i = 0; i < one.length(); i++) {
            freq[one.charAt(i) - 'a']++;
            freq[two.charAt(i) - 'a']--;
        }
        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }

    public static boolean isAnagram(String one, String two) {
        if (one.length() == two.length()) {
            char[] firstArr = one.toCharArray();
            char[] secondArr = two.toCharArray();
            sortStringArrAsc(firstArr);
            sortStringArrAsc(secondArr);
            return new String(firstArr).equals(new String(secondArr));
        }
        return false;
    }

    public static void sortStringArrAsc(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] > chars[j]) {
                    int temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = (char) temp;
                }
            }
        }
        System.out.println("Sorted Arr " + Arrays.toString(chars));
    }

    public static void sortCharArr(char[] charArray) {
        // {a,n,a,g,r,a,m}  // len -7
        int left = 0;
        int right = charArray.length - 1;

        while (true) {
            if (charArray[left] > charArray[right]) {
                charArray[right] = charArray[left];
            } else if (charArray[left] < charArray[right]) {
                left++;
            }
        }
    }

    public static boolean deletionApproach(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(t); // n a g a r a m
        for (char element : s.toCharArray()) { // a n a g r a m
            int index = sb.indexOf(String.valueOf(element)); // 1, 0, 3, 2, 4 5
            if (index == -1)
                return false;
            sb.deleteCharAt(index); // a n a g r a m
        }
        return true;
    }

    public static boolean isAnagramOptimized(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length() - 1; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(freq));

        for (int count : freq) {
            if (count != 0)
                return false;

        }
        return true;
    }


}
