package streams;

import streams.dto.Employee;
import streams.utils.EmployeeDataSupplier;

import javax.naming.Name;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvancedEmployeeStreamsProblems {

    public static void main(String[] args) {

        // Partition employees based on salary
        List<Employee> employeeList = EmployeeDataSupplier.getEmployees();
        Map<Boolean, List<String>> partitionedEmployeeDetails =
                employeeList.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 88000,
                        Collectors.mapping(Employee::getEmpName, Collectors.toList())));
        System.out.println(partitionedEmployeeDetails);

        // Group employees by department and then by age
        Map<String, Map<Integer, List<Employee>>> groupEmpByDeptAndAge =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getAge)));
        System.out.println(groupEmpByDeptAndAge);
        // Group employees by department and calculate total salary
        Map<String, Long> groupByDeptAndTotalSal =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)));
        System.out.println("groupByDeptAndTotalSal " + groupByDeptAndTotalSal);
        // Find the oldest employee in each department
        Map<String, Optional<Employee>> oldestEmp =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getJoiningDate))));
        System.out.println("oldestEmp " + oldestEmp);

        // Sort employees by salary Asc and Desc
        List<Employee> sortedAscAndDesc =
                employeeList.stream().sorted(Comparator.comparingLong(Employee::getSalary).thenComparingLong(Employee::getSalary).reversed()).toList();
        System.out.println("sortedAscAndDesc " + sortedAscAndDesc);
        // Sort employees by department and then salary

        List<Employee> sortedEmpUsingDeptAndSalary =
                employeeList.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparingLong(Employee::getSalary)).toList();
        System.out.println("sortedEmpUsingDeptAndSalary " + sortedEmpUsingDeptAndSalary);

        //Find the second-highest salary employee
        Optional<Long> secondHighestSalariedEmp =
                employeeList.stream().map(Employee::getSalary)
                        .distinct()
                        .sorted(Comparator.comparingLong(Long::longValue).reversed())
                        .skip(1)
                        .findFirst();
        System.out.println("secondHighestSalariedEmp " + secondHighestSalariedEmp);
        List<String> duplicateEmpNames = employeeList
                .stream()
                .map(Employee::getEmpName)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("duplicateEmpNames " + duplicateEmpNames);

        List<String> names = List.of("Salamanca", "John", "David", "John", "Mike", "David");
        Optional<String> firstUniqueEmp = names.stream().collect(
                        Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(element -> element.getValue() == 1)
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("First Unique Name " + firstUniqueEmp.orElse("Not Found"));
//        Find the department with maximum employees
        Optional<String> deptWithMaxEmp = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .stream()
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println("deptWithMaxEmp " + deptWithMaxEmp.orElse(null));
    }
}
