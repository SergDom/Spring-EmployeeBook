package com.nomad.employee.model;

import org.apache.commons.lang3.StringUtils;

import javax.management.BadAttributeValueExpException;

public class Employee {

    private  static  int counter;
    private final  int id;
    private  String firstname;

    private String lastname;

    private final int department;

    private final  int salary;




    public Employee(String firstname, String lastname, int department, int salary) throws BadAttributeValueExpException {
        setFirstname(firstname);
        setLastname(lastname);
        this.department = department;
        this.salary = salary;

        this.id=counter++;
    }

    public void setFirstname(String firstname) throws BadAttributeValueExpException {
        if (!StringUtils.isAlpha(firstname)) {
            throw new BadAttributeValueExpException("400 Bad Request");
        } else {
            this.firstname = StringUtils.capitalize(firstname);
        }
    }

    public void setLastname(String lastname) throws BadAttributeValueExpException {
        if (!StringUtils.isAlpha(lastname)) {
            throw new BadAttributeValueExpException("400 Bad Request");
        } else {
            this.lastname = StringUtils.capitalize(lastname);
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
