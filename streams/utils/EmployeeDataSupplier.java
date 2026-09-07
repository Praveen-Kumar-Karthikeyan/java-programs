package streams.utils;

import streams.dto.Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDataSupplier {

    private EmployeeDataSupplier() {
    }

    public static List<Employee> getEmployees() {
        Employee employeeOne = new Employee("Jimmy", 101, 98000L, "Developer", 29, LocalDate.of(1998, 9, 8));
        Employee employeeTwo = new Employee("Mike", 102, 68000L, "Testing", 25, LocalDate.of(1998, 12, 23));
        Employee employeeThree = new Employee("Kim Wexler", 103, 88000L, "Developer", 34, LocalDate.of(1999, 10, 2));
        Employee employeeFour = new Employee("Gustavo", 104, 987651L, "Testing", 39, LocalDate.of(1996, 1, 1));
        Employee employeeFive = new Employee("Laloo Salamanca", 105, 987651L, "Developer", 38, LocalDate.of(1995, 12, 21));
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(employeeOne);
        listOfEmployees.add(employeeTwo);
        listOfEmployees.add(employeeThree);
        listOfEmployees.add(employeeFour);
        listOfEmployees.add(employeeFive);
        return listOfEmployees;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = getEmployees();
        //Find employees whose salary > No
        List<Employee> employeesWhoseSalGreaterThan68K =
                employeeList.stream().filter(emp -> emp.getSalary() > 68000).toList();
        System.out.println(employeesWhoseSalGreaterThan68K);
        // Get employee names
        List<String> empNames = employeeList.stream().map(Employee::getEmpName).toList();
        System.out.println(empNames);
        // Find highest-paid employee
        Optional<Employee> highestPaidEmp =
                employeeList.stream().max(Comparator.comparingLong(Employee::getSalary));
        System.out.println(highestPaidEmp.orElse(null));
        // min Paid employee
        Optional<Employee> minimumPaidEmployee = employeeList.stream().min(Comparator.comparingLong(Employee::getSalary));
        System.out.println(minimumPaidEmployee);
        // Find average salary
        OptionalDouble avgSal = employeeList.stream().mapToLong(Employee::getSalary).average();
        System.out.println("Average salary " + avgSal);
        // Group Emp by Dep
        Map<String, List<Employee>> employeeByDep =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("employeeByDep " + employeeByDep);

        Map<String, Long> empCountInEachDep =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("empCountInEachDep " + empCountInEachDep);

        Map<String, Double> highestSalEmpFromEachDept =
                employeeList.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingLong(Employee::getSalary)
                ));
        System.out.println("highestSalEmpFromEachDept " + highestSalEmpFromEachDept);


        Optional<Map.Entry<String, Double>> highestAvgSalByDep = employeeList.stream().collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingLong(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        System.out.println(highestAvgSalByDep.orElse(null));


    }

}
