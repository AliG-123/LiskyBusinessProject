package com.sparta.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    @DisplayName("Testing set and get department name")
    public void setDeptName_GetReturnsSameDeptName() {
        Department department = new Department();
        department.setDept_Name("Marketing");
        assertEquals("Marketing", department.getDept_Name());
    }

    @ParameterizedTest
    @CsvSource({"Marketing", "Customer Service", "Finance", "Research"})
    @DisplayName("Multiple Testing set and get department name")
    public void setLast_ReturnSameDeptName(String value) {
        Department department = new Department();
        department.setDept_Name(value);
        assertEquals(value, department.getDept_Name());
    }

    @Test
    @DisplayName("Testing set and get department number")
    public void setDeptNo_GetReturnsSameDeptNo() {
        Department department = new Department();
        department.setDept_No(d003);
        assertEquals(d003, department.getDept_No());
    }

    @ParameterizedTest
    @ValueSource(strings = {"d003","d004","d005","d006"})
    @DisplayName("Multiple Testing set and get department name")
    public void setMultipleDeptNo_ReturnSameDeptNo(String deptID) {
        Department department = new Department();
        department.setDept_No(deptID);
        assertEquals(deptID, department.getDept_No());
    }

}