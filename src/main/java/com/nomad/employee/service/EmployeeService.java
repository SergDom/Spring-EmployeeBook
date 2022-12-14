package com.nomad.employee.service;

import com.nomad.employee.model.Employee;
import com.nomad.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {

        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }

        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int salarySum() {
        return employees.values()
                .stream().mapToInt(Employee::getSalary).sum();
    }

    public Employee salaryMin() {

        Employee lowestSalary = employees.values().
                stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(NullPointerException::new);


        return lowestSalary;
    }

    public Employee salaryMax() {

        Employee highestSalary = employees.values().
                stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(NullPointerException::new);

        return highestSalary;
    }

    public double salaryAverage() {

        return employees.values().
                stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

    }

    public List<Employee> salaryHigherAverage() {
        double salaryAvr = salaryAverage();
        List<Employee> salaryHigherAverage = employees.values()
                .stream()
                .filter(e -> e.getSalary() > salaryAvr).toList();

        return salaryHigherAverage;
    }

}

