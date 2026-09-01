package streams.utils;

import streams.dto.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataSupplier {

    private EmployeeDataSupplier() {
    }

    public static List<Employee> getEmployees() {
        Employee employeeOne = new Employee("Jimmy", 101, 98000L, LocalDate.of(1998, 9, 8));
        Employee employeeTwo = new Employee("Mike", 102, 68000L, LocalDate.of(1998, 12, 23));
        Employee employeeThree = new Employee("Kim Wexler", 103, 88000L, LocalDate.of(1999, 10, 2));
        Employee employeeFour = new Employee("Gustavo", 104, 987651L, LocalDate.of(1996, 1, 1));
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(employeeOne);
        listOfEmployees.add(employeeTwo);
        listOfEmployees.add(employeeThree);
        listOfEmployees.add(employeeFour);
        return listOfEmployees;
    }

}
