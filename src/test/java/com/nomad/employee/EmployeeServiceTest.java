package com.nomad.employee;

import com.nomad.employee.model.Employee;
import com.nomad.employee.record.EmployeeRequest;
import com.nomad.employee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class EmployeeServiceTest {

    private EmployeeService employeeService;
    Employee emp1;
    Employee emp2;
    Employee emp3;
    Employee emp4;
    Employee emp5;


    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
        emp1 = employeeService.addEmployee(new EmployeeRequest("TestOne", "TestOne", 1, 5000));
        emp2 = employeeService.addEmployee(new EmployeeRequest("TestTwo", "TestTwo", 2, 7000));
        emp3 = employeeService.addEmployee(new EmployeeRequest("TestThree", "TestThree", 2, 9000));
        emp4 = employeeService.addEmployee(new EmployeeRequest("TestFour", "TestFour", 1, 8500));
        emp5 = employeeService.addEmployee(new EmployeeRequest("TestFive", "TestFive", 3, 6800));

    }

    @Test
    public void addEmployee() {
        EmployeeRequest request = new EmployeeRequest("Valid", "Valid", 3, 5700);
        Employee result = employeeService.addEmployee(request);
        assertEquals(request.getFirstName(), result.getFirstname());
        assertEquals(request.getLastName(), result.getLastname());
        assertEquals(request.getDepartment(), result.getDepartment());
        assertEquals(request.getSalary(), result.getSalary());

    }

    @Test
    public void GetAllEmployee() {
        Collection<Employee> actual = employeeService.getAllEmployees();
        assertEquals(5, actual.size());
        Assertions.assertTrue(actual.containsAll(List.of(emp1, emp2, emp3, emp4, emp5)));
    }

    @Test
    void getSalarySum() {
        assertEquals(36300, employeeService.salarySum());
    }

    @Test
    void getSalaryMin() {
        assertEquals(emp1, employeeService.salaryMin());
    }
    @Test
    void getSalaryMax() {
        assertEquals(emp3, employeeService.salaryMax());
    }

    @Test
    void getSalaryAvrg() {
        assertEquals(7260, employeeService.salaryAverage());
    }

    @Test
    void getSalaryHigherAvrg() {
        assertIterableEquals(List.of(emp3, emp4), employeeService.salaryHigherAverage());
    }
}
