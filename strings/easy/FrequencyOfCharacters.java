package strings.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyOfCharacters {

    public static void main(String[] args) {
        String msg = "HelloWorld";
        System.out.println(frequencyOfCharacters(msg));
    }

    public static Map<Character, Integer> frequencyOfCharacters(String msg) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char element : msg.toCharArray()) {
            freq.put(element, freq.getOrDefault(element, 0) + 1);
        }
        return freq;
    }
}
