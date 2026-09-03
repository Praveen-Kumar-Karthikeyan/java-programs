package streams.easy;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicInterviewProblemsUsingStreams {

    public static void main(String[] args) {
        // Find sum of all numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int summation = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Summation of array " + summation);

        // Find average of all numbers
        double average =
                numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average " + average);

        // Find second-highest number
        OptionalInt secondLargestNo = numbers.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).mapToInt(Integer::intValue)
                .skip(1)
                .findFirst();
        System.out.println("Second Largest No " + secondLargestNo.orElse(0));

        // Find second-lowest No
        OptionalInt secondLowest = numbers.stream().mapToInt(Integer::intValue).sorted().skip(1).findFirst();
        System.out.println("Second Lowest No " + secondLowest.orElse(0));

        // Find top 3 highest numbers
        List<Integer> top3Nos
                = Stream.of(10, 50, 20, 80, 30, 70).sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("Top 3 Nos " + top3Nos);

        // Find numbers whose frequency is greater than 1 or Find duplicate elements
        List<Integer> numbersFreqGreaterThan1 =
                Stream.of(1, 2, 3, 2, 4, 3, 5)
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet().stream()
                        .filter(element -> element.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .toList();
        System.out.println("numbersFreqGreaterThan1 " + numbersFreqGreaterThan1);

        // Find unique elements
        List<Integer> uniqueElements = Stream.of(1, 2, 3, 2, 4, 3, 5)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(element -> element.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("uniqueElements " + uniqueElements);

        // Join strings using coma
        List<String> stringList = Arrays.asList("Java", "Spring", "Kafka");
        String combinedString = stringList.stream().collect(Collectors.joining(","));
        System.out.println("combinedString " + combinedString);

        // Find longest string
        List<String> technologies = Arrays.asList("Java", "Spring Boot", "Kafka", "Microservices");
        Optional<String> longestString = technologies.stream()
                .max(Comparator.comparing(String::length));
        System.out.println("longestString " + longestString.orElse(null));
    }
}
