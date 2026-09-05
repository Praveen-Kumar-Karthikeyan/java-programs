package streams;

import streams.dto.Employee;
import streams.utils.EmployeeDataSupplier;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBasedStreamsPrograms {

    public static void main(String[] args) {
        List<Employee> employeeList =
                EmployeeDataSupplier.getEmployees();

        // Find employees whose salary > 100000
        List<Employee> employeeSalGreaterThan90k =
                employeeList.stream().filter(employee -> employee.getSalary() > 90000).toList();
        System.out.println(employeeSalGreaterThan90k);

        // Get employee names
        List<String> employeeNames =
                employeeList.stream().map(Employee::getEmpName).toList();
        System.out.println("employeeNames" + employeeNames);

        // Find highest-paid employee
        Employee highestPaidEmployee =
                employeeList.stream().max(Comparator.comparingLong(Employee::getSalary)).orElse(null);
        System.out.println("highestPaidEmployee " + highestPaidEmployee);

        // Find lowest-paid employee
        Employee lowestPaidEmployee =
                employeeList.stream().min(Comparator.comparingLong(Employee::getSalary)).orElse(null);
        System.out.println("lowestPaidEmployee " + lowestPaidEmployee);

        //Find average salary
        OptionalDouble averageSalary =
                employeeList.stream().mapToLong(Employee::getSalary).average();
        System.out.println("averageSalary " + averageSalary);

        // Group employees by department
        Map<String, List<Employee>> employeesGroupByDept =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeesGroupByDept);

        // 27. Count employees in each department
        Map<String, Long> employeeCountInEachDept =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(employeeCountInEachDept);

        // Find Highest salary employee from each department
        Map<String, Optional<Employee>> highestSalEmpByEachDept =
                employeeList.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))
                ));
        System.out.println(highestSalEmpByEachDept);
        //Find average salary by department
        Map<String, Double> averageSalByDept =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)));
        System.out.println("averageSalByDept " + averageSalByDept);

        // Find department having highest average salary
        OptionalDouble highestAvgSalByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)))
                .values()
                .stream().mapToDouble(v -> v)
                .max();

        System.out.println("highestAvgSalByDept" + highestAvgSalByDept);


    }
}
