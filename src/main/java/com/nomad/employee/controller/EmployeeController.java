package com.nomad.employee.controller;


import com.nomad.employee.model.Employee;
import com.nomad.employee.record.EmployeeRequest;
import com.nomad.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping  ("/employees/salary/sum")
    public int salarySum () {
        return this.employeeService.salarySum();
    }

    @GetMapping  ("/employees/salary/avr")
    public double salaryAverage () {
        return this.employeeService.salaryAverage();
    }

    @GetMapping  ("/employees/salary/min")
    public Employee salaryMin () {
        return this.employeeService.salaryMin();
    }

    @GetMapping  ("/employees/salary/max")
    public Employee salaryMax () {
        return this.employeeService.salaryMax();
    }

    @GetMapping  ("/employees/salary/avr-high")
    public List<Employee> salaryHigherAverage () {
        return this.employeeService.salaryHigherAverage();
    }
}


