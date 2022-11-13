package com.nomad.employee.model;

public class Employee {

    private  static  int counter;
    private final  int id;
    private final String firstname;

    private final String lastname;

    private final int department;

    private final  int salary;


    public Employee(String firstname, String lastname, int department, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;

        this.id=counter++;
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
