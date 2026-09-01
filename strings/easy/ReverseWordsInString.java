package strings.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String input = "Hello World From Java";
        System.out.println(reverseWordByWord(input));
        System.out.println(usingStreams(input));
    }

    public static String reverseWordByWord(String message) {
        String[] arrayOfLiterals = message.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (String arrayOfLiteral : arrayOfLiterals) {
            char[] charArray = arrayOfLiteral.toCharArray();
            StringBuilder constructReversedWord = new StringBuilder();
            for (int i = charArray.length - 1; i >= 0; i--) {
                constructReversedWord.append(charArray[i]);
            }
            reversedString.append(constructReversedWord).append(" ");
        }
        return reversedString.toString().trim();
    }

    public static String usingStreams(String message) {
        return Arrays.stream(message.split(" "))
                .map(element -> new StringBuilder(element).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}