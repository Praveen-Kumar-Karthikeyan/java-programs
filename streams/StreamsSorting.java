package streams;

import streams.dto.Employee;

import java.util.Comparator;
import java.util.List;

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


    }
}
