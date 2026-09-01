package streams.dto;

import java.time.LocalDate;

public class Employee {

    private String empName;
    private Integer empId;
    private Long salary;
    private LocalDate joiningDate;

    public Employee() {
    }

    public Employee(String empName, Integer empId, Long salary, LocalDate joiningDate) {
        this.empName = empName;
        this.empId = empId;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public String getEmpName() {
        return empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public Long getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                '}';
    }


}
