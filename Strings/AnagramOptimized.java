package Strings;

import java.util.HashMap;
import java.util.Map;

public class AnagramOptimized {

    // This Approach will help us to tackle all kind of character and Unicode values
    // Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?


    public static void main(String[] args) {

        String s = "JavaÖ";
        String t = "ÖavaJ";

//        String s = "AnagraM";
//        String t = "nAgaraM";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String one, String two) {

        Map<Character, Integer> freq = new HashMap<>();
        for (char element : one.toCharArray()) {
            freq.put(element, freq.getOrDefault(element, 0) + 1);
        }
        for (char character : two.toCharArray()) {
            if (freq.containsKey(character))
                freq.put(character, freq.get(character) - 1);
            else
                return false;

            if (freq.get(character) == 0)
                freq.remove(character);
        }
        return freq.isEmpty();
    }


}
