package com.sparta.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Employee {

    private Date birth_date;
    private int emp_no;
    private String first_name;
    private String gender;
    private Date hire_date;
    private String last_name;
    private List<Department> departmentList;


    public Employee() {
        super();
    }



    public Employee(Date birth_date, int emp_no, String first_name, String gender, Date hire_date, String last_name, List<Department> departmentList) {
        this.birth_date = birth_date;
        this.emp_no = emp_no;
        this.first_name = first_name;
        this.gender = gender;
        this.hire_date = hire_date;
        this.last_name = last_name;
        this.departmentList = departmentList;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "birth_date=" + birth_date +
                ", emp_no=" + emp_no +
                ", first_name='" + first_name + '\'' +
                ", gender='" + gender + '\'' +
                ", hire_date=" + hire_date +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return emp_no == employee.emp_no && Objects.equals(birth_date, employee.birth_date) && Objects.equals(first_name, employee.first_name) && Objects.equals(gender, employee.gender) && Objects.equals(hire_date, employee.hire_date) && Objects.equals(last_name, employee.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birth_date, emp_no, first_name, gender, hire_date, last_name);
    }
}
