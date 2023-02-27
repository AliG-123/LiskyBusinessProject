package com.sparta.validation;

import static org.junit.jupiter.api.Assertions.*;

import com.sparta.entities.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.sql.Date;

class date_past_checkerTest {

    Date currentDate = new Date(System.currentTimeMillis());


    @Test
    @DisplayName("Given birth date is before, return true")
    public void checkBirthIsBefore(){
        Employee e1 = new Employee(Date.valueOf("2000-01-01"), 1234567,  "Bob", "Vance", Date.valueOf("2018-01-01"), "M");
        assertTrue(e1.getBirth_date().before(currentDate));
    }

    @Test
    @DisplayName("Given hire date is before, return true")
    public void checkHireIsBefore(){
        Employee e1 = new Employee(Date.valueOf("2000-01-01"), 1234567,  "Bob", "Vance", Date.valueOf("2018-01-01"), "M");
        assertTrue(e1.getHire_date().before(currentDate));
    }

    @Test
    @DisplayName("Given birth date is after, return false")
    public void checkBirthIsAfter(){
        Employee e1 = new Employee(Date.valueOf("2000-01-01"), 1234567,  "Bob", "Vance", Date.valueOf("2018-01-01"), "M");
        assertFalse(e1.getBirth_date().before(currentDate));
    }

    @Test
    @DisplayName("Given hire date is after, return false")
    public void checkHireIsAfter(){
        Employee e1 = new Employee(Date.valueOf("2000-01-01"), 1234567,  "Bob", "Vance", Date.valueOf("2018-01-01"), "M");
        assertFalse(e1.getHire_date().before(currentDate));
    }

    @ParameterizedTest
    @DisplayName("Check dates before current date return True")
    @CsvSource({"2023-02-25", "2023-02-24", "2022-02-25", "2021-02-25", "2020-02-25", "2019-02-25", "1960-02-25"})
    public void checkPastDatesReturnTrue(Date date){
        assertTrue(date.before(currentDate));
    }

    @ParameterizedTest
    @DisplayName("Check dates after current date return False")
    @CsvSource({"2024-12-25", "2025-02-24", "2026-02-25", "2027-02-25", "2028-02-25", "2029-02-25", "2030-02-25"})
    public void checkFutureDatesReturnFalse(Date date){
        assertFalse(date.before(currentDate));

    }
}