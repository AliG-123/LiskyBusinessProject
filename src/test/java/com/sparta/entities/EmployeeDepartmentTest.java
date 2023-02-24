package com.sparta.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDepartmentTest {

    @Test
    @DisplayName("Testing set and get from date")
    public void setFromDate_GetReturnsSameFromDate() {
        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        employeeDepartment.setFrom_Date(new Date());
        assertEquals(new Date(), employeeDepartment.getFrom_Date());
    }

//    @ParameterizedTest
//    @ValueSource(strings = {new Date(2001,1,1) })
//    @DisplayName("Testing multiple set and get hire dates")
//    public void setMultipleFromDates_GetReturnsSameFromDates() {
//        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
//        employeeDepartment.setFrom_Date(new Date());
//        assertEquals(new Date(), employeeDepartment.getFrom_Date());
//    }




    @Test
    @DisplayName("Testing set and get to date")
    public void setToDate_GetReturnsSameToDate() {
        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        employeeDepartment.setTo_Date(new Date());
        assertEquals(new Date(), employeeDepartment.getTo_Date());
    }


}