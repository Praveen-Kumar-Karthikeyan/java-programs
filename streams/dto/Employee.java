package streams.dto;

import java.time.LocalDate;

public class Employee {

    private String empName;
    private Integer empId;
    private Long salary;
    private String department;
    private Integer age;
    private LocalDate joiningDate;

    public Employee() {
    }

    public Employee(String empName, Integer empId, Long salary, String department, Integer age, LocalDate joiningDate) {
        this.empName = empName;
        this.empId = empId;
        this.salary = salary;
        this.department = department;
        this.age = age;
        this.joiningDate = joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getAge() {
        return age;
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
                ", department='" + department + '\'' +
                ", age=" + age +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
