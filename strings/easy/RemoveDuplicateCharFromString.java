package strings.easy;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharFromString {

    public static void main(String[] args) {
        String msg = "HelloWorld"; // HeloWrd
        System.out.println(removeDuplicateCharacters(msg));
    }

    public static String removeDuplicateCharacters(String msg) {
        Set<Character> isExist = new LinkedHashSet<>();
        StringBuilder builder = new StringBuilder();
        for (char element : msg.toCharArray()) {
            if (isExist.add(element)) {
                builder.append(element);
            }
        }
        return builder.toString();
    }


}
