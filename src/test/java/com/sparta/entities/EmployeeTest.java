package com.sparta.entities;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    @DisplayName("Testing set and get first name")
    public void setEmployeeFirstName_GetReturnsSameFirstName() {
        Employee employee = new Employee();
        employee.setFirstName("Tom");
        assertEquals("Tom", employee.getFirstName());
    }

    @ParameterizedTest
    @Disabled("Currently not implemented")
    @CsvSource("John, Mike, Thomas, Genius, King")
    @DisplayName("Testing set and get name")
    public void setLast_ReturnSameName() {
        Employee employee = new Employee();
        employee.setName("Tom");
        assertEquals("Tom", employee.getName());
    }

    @Test
    @DisplayName("Testing set  and get last name")
    public void setEmployeeLastName_GetReturnsSameLastName() {
        Employee employee = new Employee();
        employee.setLastName("Jones");
        assertEquals("Jones", employee.getLastName());
    }

    @Test
    @DisplayName("Testing set and get emp id")
    public void setEmployeeEmpId_GetReturnsSameEmpId() {
        Employee employee = new Employee();
        employee.setEmpId("1234");
        assertEquals("1234", employee.getEmpId());
    }

    @Test
    @DisplayName("Testing set and get name")
    public void setEmployeeGender_GetReturnsSameGender() {
        Employee employee = new Employee();
        employee.setGender('M');
        assertEquals('M', employee.getGender());
    }

    @Test
    @DisplayName("Testing set and get name")
    public void setEmployeeGender_GetReturnsSameGender() {
        Employee employee = new Employee();
        employee.setGender('M');
        assertEquals('M', employee.getGender());
    }

    @Test
    @DisplayName("Testing set and get hire date")
    public void setEmployeeHireDate_GetReturnsSameHireDate() {
        Employee employee = new Employee();
        employee.setDate(new Date());
        assertEquals(new Date(), employee.getDate());
    }

}