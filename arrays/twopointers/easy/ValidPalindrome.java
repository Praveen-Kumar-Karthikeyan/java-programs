package arrays.twopointers.easy;

public class ValidPalindrome {

    public static void main(String[] args) {
        String isValidPalindrome = "A man, a plan, a canal: Panama";
        if (bruteForce(isValidPalindrome))
            System.out.println(isValidPalindrome + " is a valid Palindrome");
        else
            System.out.println(isValidPalindrome + " is not a valid Palindrome");
    }


    public static boolean bruteForce(String str) {
        str = str.toLowerCase();
        char[] charArr = str.toCharArray();
        StringBuilder cleanedStr = new StringBuilder();
        for (char element : charArr) {
            if (Character.isLetterOrDigit(element))
                cleanedStr.append(Character.toLowerCase(element));
        }
        String originalString = cleanedStr.toString();
        char[] charArray = originalString.toCharArray();
        StringBuilder reverseBuilder = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            reverseBuilder.append(charArray[i]);
        }
        String reversedString = reverseBuilder.toString();
        return originalString.equals(reversedString);
    }

    public static boolean optimizedApproach(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray = str.toCharArray();
        int leftPointer = 0;
        int rightPointer = charArray.length - 1;
        for (; leftPointer <= rightPointer; rightPointer--, leftPointer++) {
            if (charArray[leftPointer] != charArray[rightPointer])
                return false;
        }
        return true;
    }
}
