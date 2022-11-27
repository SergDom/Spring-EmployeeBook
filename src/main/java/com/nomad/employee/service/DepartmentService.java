package com.nomad.employee.service;

import com.nomad.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getDepartment(int id) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
    }

    public int getSalarySumByDepartment(int id) {
        return getDepartment(id).stream()
                .mapToInt(Employee::getSalary).sum();
    }

    public int getMaximumSalaryByDepartment(int id) {
        return getDepartment(id).stream()
                .map(Employee::getSalary)
                .max(Integer::compareTo)
                .orElseThrow(NullPointerException::new);
    }

    public int getMinimumSalaryByDepartment(int id) {
        return getDepartment(id).stream()
                .map(Employee::getSalary)
                .min(Integer::compareTo)
                .orElseThrow(NullPointerException::new);
    }



    public Map<Integer, List<Employee>> listOfEmployeesSortedByDepartment() {
        Map<Integer, List<Employee>> departments = employeeService.getAllEmployees()
                .stream().collect(Collectors.groupingBy(Employee::getDepartment));

        return departments;
    }


}
