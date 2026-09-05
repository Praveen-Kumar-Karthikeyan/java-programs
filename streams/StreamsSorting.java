package streams;

import streams.dto.Employee;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static streams.utils.EmployeeDataSupplier.getEmployees;

public class StreamsSorting {

    public static void main(String[] args) {
        List<Employee> employeeList = getEmployees();
        // Employee Sorting Using Streams
        // will sort asc based on empName
        List<Employee> sortedEmployeeList =
                employeeList.stream()
                        .sorted(Comparator.comparing(Employee::getEmpName))
                        .toList();
        System.out.println(sortedEmployeeList);

        // sort employee name with desc order
        List<Employee> sortedEmpNamesInDesc = employeeList
                .stream()
                .sorted(Comparator.comparing(Employee::getEmpName).reversed())
                .toList();
        System.out.println(sortedEmpNamesInDesc);

        // sort based on Emp Id desc order

        List<Employee> sortedEmpIdsInDesc = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getEmpId).reversed())
                .toList();
        System.out.println(sortedEmpIdsInDesc);

        // sort employee based on joiningDate desc

        List<Employee> sortedBasedOnJoiningDateDesc = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getJoiningDate).reversed())
                .toList();

        System.out.println(sortedBasedOnJoiningDateDesc);

        int summation = employeeList.stream().map(Employee::getEmpId).mapToInt(Integer::intValue).sum();
        System.out.println("summation " + summation);

        OptionalDouble maxNum = DoubleStream.of(1, 2, 3, 4, 5).max();
        System.out.println("count " + maxNum.orElse(0));

        Stream.of(1, 2, 3, 4, 5).mapToInt(Integer::intValue).sum();

        Stream.of(10, 20, 30, 40, 50).mapToInt(Integer::intValue).average();
        Arrays.asList(10, 20, 30, 40, 50).stream().mapToInt(Integer::intValue).average();

        OptionalDouble average = IntStream.of(10, 20, 30, 40, 50).average();
        System.out.println(average.orElse(0));

        int secondLargestNo =
                Stream.of(10, 20, 30, 40, 50).sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(1).findFirst().orElse(0);
        System.out.println(secondLargestNo);
        IntFunction<Integer> intFn = Integer::valueOf;
        secondLargestNo = IntStream.of(10, 20, 30, 40, 50)
                .distinct()
                .mapToObj(intFn)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(1).findFirst().orElse(0);
        System.out.println("secondLargestNo" + secondLargestNo);

        int secondLowest =
                IntStream.of(10, 20, 30, 40, 50).sorted().skip(1).findFirst().orElse(0);
        System.out.println("secondLowest " + secondLowest);

        secondLowest = Stream.of(90, 89, 12, 9, 9, 781, 23, null, null).sorted(Comparator.nullsLast(Comparator.comparingInt(Integer::intValue)))
                .distinct()
                .skip(1).findFirst().orElse(0);
        System.out.println("secondLowest " + secondLowest);

        List<Integer> max3No = IntStream.of(90, 89, 12, 9, 9, 781, 23)
                .boxed()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .limit(3)
                .toList();
        System.out.println("max3No" + max3No);

        List<Integer> freqCountGreaterThan1 = Stream.of(1, 2, 3, 2, 4, 3, 5)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(element -> element.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("freqCountGreaterThan1 " + freqCountGreaterThan1);

    }

}
