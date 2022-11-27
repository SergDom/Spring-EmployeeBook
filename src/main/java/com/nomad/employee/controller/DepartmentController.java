package com.nomad.employee.controller;

import com.nomad.employee.model.Employee;
import com.nomad.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @GetMapping("/department/{id}/employees")
    public List<Employee> getDepartment(@PathVariable("id") int id) {
        return this.departmentService.getDepartment(id);
    }

    @GetMapping("/department/{id}/salary/sum")
    public int getSalarySumByDepartment(@PathVariable("id") int id) {
        return this.departmentService.getSalarySumByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/max")
    public int getMaximumSalaryByDepartment(@PathVariable("id") int id) {
        return this.departmentService.getMaximumSalaryByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/min")
    public int getMinimumSalaryByDepartment (@PathVariable("id") int id) {
        return this.departmentService.getMinimumSalaryByDepartment(id);
    }

    @GetMapping("/department/employees")
    public Map<Integer, List<Employee>> listOfEmployeesSortedByDepartment() {
        return this.departmentService.listOfEmployeesSortedByDepartment();
    }
}
