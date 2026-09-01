package strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(usingStreams(str));
    }

    public static Character firstNonRepeatingChar(String string) {
        char[] charArr = string.toLowerCase().toCharArray();
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char element : charArr) {
            freq.put(element, freq.getOrDefault(element, 0) + 1);
        }
        for (Map.Entry<Character, Integer> element : freq.entrySet()) {
            if (element.getValue() == 1)
                return element.getKey();
        }
        return 0;
    }

    public static String usingStreams(String nonRepeatingChar) { // MADAM
        return Arrays.stream(nonRepeatingChar.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(element -> element.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse("Not Found");
    }
}
