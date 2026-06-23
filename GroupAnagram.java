import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {

        String[] arrayOfStrings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Set<String> set = new HashSet<>();
        Collections.addAll(set, arrayOfStrings);

        System.out.println(set);
//        System.out.println(groupAnagram(arrayOfStrings));

    }

    public static List<List<String>> optimizedApproach(String[] strings) {
        Map<String, List<String>> frequency = new HashMap<>();
        for (String string : strings) { // eat, tea, tan, ate, nat, bat
            Set<String> anagramCheck = new HashSet<>();
            List<String> anagram = new ArrayList<>();
            if (anagramCheck.contains(string)) { // tea
                anagram.add(string);
            } else {
                anagramCheck.add(string); // eat
                anagram.add(string); // eat
            }
        }

        return null;
    }

    public static List<List<String>> groupAnagram(String[] strings) {
        List<List<String>> groupedAnagram = new ArrayList<>();
        List<String> anagrams;
        for (int i = 0; i < strings.length; i++) { // eat
            for (int j = i + 1; j < strings.length; j++) { // tea
                if (isAnagramOfEachOther(strings[i], strings[j])) {
                    anagrams = new ArrayList<>();
                    anagrams.add(strings[i]); // both anangram List<Strings> = eat, tea
                    anagrams.add(strings[j]);
                    groupedAnagram.add(anagrams);
                }
            }
        }
        return groupedAnagram;
    }

    public static boolean isAnagramOfEachOther(String one, String two) {
        System.out.println("String one " + one + " String two " + two);
        if (one.length() != two.length())
            return false;

        Map<Character, Integer> frequency = new HashMap<>();
        for (char elements : one.toCharArray()) {
            if (frequency.containsKey(elements))// tan
                frequency.put(elements, frequency.get(elements) + 1);
            else
                frequency.put(elements, frequency.getOrDefault(elements, 0) + 1);
        }
        System.out.println(frequency);

        for (char character : two.toCharArray()) { // nat
            if (frequency.containsKey(character))
                frequency.put(character, frequency.get(character) - 1);
            else
                return false;

            if (0 == frequency.get(character))
                frequency.remove(character);
        }
        System.out.println(frequency.isEmpty());

        return frequency.isEmpty();
    }
}
