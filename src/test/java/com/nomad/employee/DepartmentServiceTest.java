package com.nomad.employee;

import com.nomad.employee.model.Employee;
import com.nomad.employee.service.DepartmentService;
import com.nomad.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    Employee emp1;
    Employee emp2;
    Employee emp3;
    Employee emp4;
    Employee emp5;

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;


    @BeforeEach
    public void setUp() {
        emp1 = new Employee("TestOne", "TestOne", 1, 5000);
        emp2 = new Employee("TestTwo", "TestTwo", 2, 7000);
        emp3 = new Employee("TestThree", "TestThree", 2, 9000);
        emp4 = new Employee("TestFour", "TestFour", 1, 8500);
        emp5 = new Employee("TestFive", "TestFive", 3, 6800);
        when(employeeService.getAllEmployees()).thenReturn(Set.of(emp1, emp2, emp3, emp4, emp5));
    }
    @Test
    void getDepartment() {
        List <Employee> actual = departmentService.getDepartment(1);
        assertEquals(2, actual.size());
        assertTrue(actual.containsAll(List.of(emp1, emp4)));
    }

    @Test
    void getSalarySumOneDepartment() {
        assertEquals(13500, departmentService.getSalarySumByDepartment(1));
    }

    @Test
    void getMaxSalaryInDepartment() {
        assertEquals(9000, departmentService.getMaximumSalaryByDepartment(2));
    }

    @Test
    void getMinSalaryInDepartment() {
        assertEquals(6800, departmentService.getMinimumSalaryByDepartment(3));
    }

    @Test
    void getEmployeesSortedByDepartment() {
        Map<Integer, List<Employee>> departments = departmentService
                        .listOfEmployeesSortedByDepartment();

        assertTrue(departments.get(1)
                .containsAll(List.of(emp1,emp4)));
        assertTrue(departments.get(2)
                .containsAll(List.of(emp2,emp3)));
        assertTrue(departments.get(3)
                .contains(emp5));

    }

}