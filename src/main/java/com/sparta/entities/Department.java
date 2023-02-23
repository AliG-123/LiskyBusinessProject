package com.sparta.entities;

import java.util.List;

public class Department {

    private String departmentName;
    private String departmentNumber;
    private List<Employee> employeeList;
    public Department (String departmentNumber, String departmentName ){
        this.departmentName = departmentName;
        this.departmentNumber = departmentNumber;
    }

}
