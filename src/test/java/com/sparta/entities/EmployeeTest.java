package com.sparta.entities;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    @Nested
    class testFirstName {
        @Test
        @DisplayName("Testing set and get first name")
        public void setEmployeeFirstName_GetReturnsSameFirstName() {
            Employee employee = new Employee();
            employee.setFirstName("Tom");
            assertEquals("Tom", employee.getFirstName());
        }

        @ParameterizedTest
        @CsvSource({"John", "Mike", "Thomas", "Genius", "King"})
        @DisplayName("Multiple Testing set and get first name")
        public void setLast_ReturnSameName(String value) {
            Employee employee = new Employee();
            employee.setFirstName(value);
            assertEquals(value, employee.getFirstName());
        }
    }


    class testLastName {
        @Test
        @DisplayName("Testing set  and get last name")
        public void setEmployeeLastName_GetReturnsSameLastName() {
            Employee employee = new Employee();
            employee.setLastName("Jones");
            assertEquals("Jones", employee.getLastName());
        }

        @ParameterizedTest
        @CsvSource({"Jones", "Johnson", "Smith", "Sunak", "King"})
        @DisplayName("Multiple Testing set and get last name")
        public void setLast_ReturnSameName(String value) {
            Employee employee = new Employee();
            employee.setLastName(value);
            assertEquals(value, employee.getLastName());
        }

    }

    @Nested
    class testEmpId {

        @Test
        @DisplayName("Testing set and get emp id")
        public void setEmployeeEmpId_GetReturnsSameEmpId() {
            Employee employee = new Employee();
            employee.setEmpId("1234");
            assertEquals("1234", employee.getEmpId());
        }

        @ParameterizedTest
        @CsvSource({"1322", "2315", "2356", "9421", "8976"})
        @DisplayName("Multiple Testing set and get last name")
        public void setLast_ReturnSameName(String value) {
            Employee employee = new Employee();
            employee.setEmpId(value);
            assertEquals(value, employee.getEmpId());
        }

    }



    @Nested
    class testEmployeeGender {
        @Test
        @DisplayName("Testing set and get gender")
        public void setEmployeeGender_GetReturnsSameGender() {
            Employee employee = new Employee();
            employee.setGender('M');
            assertEquals('M', employee.getGender());
        }

        @ParameterizedTest
        @ValueSource(chars = {'M', 'F'})
        @DisplayName("Multiple Testing set and get gender")
        public void setLast_ReturnSameName(char value) {
            Employee employee = new Employee();
            employee.setEmpId(value);
            assertEquals(value, employee.getEmpId());
        }
    }


    @Nested
    class testEmployeeHireDate {
        @Test
        @DisplayName("Testing set and get hire date")
        public void setEmployeeHireDate_GetReturnsSameHireDate() {
            Employee employee = new Employee();
            employee.setDate(new Date());
            assertEquals(new Date(), employee.getDate());
        }

    }

}