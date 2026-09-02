package streams.basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Top10BasicStreamsQuestions {

    public static void main(String[] args) {
//        Filter even numbers using streams
        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers = numbers.stream().filter(no -> no % 2 == 0).toList();
        System.out.println("Even No's from numbers List " + numbers);

        // Find numbers greater than 50
        List<Integer> numberList = Arrays.asList(10, 25, 60, 75, 30);
        numberList = numberList.stream().filter(no -> no > 50).toList();
        System.out.println("numbers greater than 50  from numberList " + numberList);

        // Convert List of Strings to uppercase
        List<String> stringList = Arrays.asList("java", "spring", "kafka");
        stringList = stringList.stream().map(String::toUpperCase).toList();
        System.out.println("String List into converted into Uppercase " + stringList);

        // find length of all Strings
        numberList = stringList.stream().map(String::length).toList();
        System.out.println(numberList);

        // converted String and length into map key as String and value as length
        Map<String, Integer> stringsWithLength =
                stringList.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(stringsWithLength);

        // Remove duplicate numbers from list
        List<Integer> duplicateNos = Arrays.asList(1, 1, 3, 4, 5, 5, 6, 7, 8, 9, 8, 6, 7);
        duplicateNos = duplicateNos.stream().distinct().toList();
        System.out.println(duplicateNos);

        //Sort numbers in Asc and Desc
        List<Integer> numbersList = Arrays.asList(5, 2, 8, 1, 3);
        numbersList = numbersList.stream().sorted().toList();
        System.out.println("Sorted ascending " + numbersList);

        numbersList = numbersList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted Descending " + numbersList);
        // Find maximum number
        Integer maxNum = numbersList.stream().max(Comparator.comparingInt(Integer::intValue)).orElse(0);
        System.out.println("Maximum Number " + maxNum);

        Integer minNum = numbersList.stream().min(Comparator.comparingInt(Integer::intValue)).orElse(0);
        System.out.println("Min No " + minNum);
    }
}
