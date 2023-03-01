package com.sparta.validation;

import com.sparta.entities.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class emp_no_checkerTest {
    Employee e = new Employee();

    @Test
    @DisplayName("checking emp_no_checker returns true if employee's emp_no is 8 digits or less")
    public void checkEmp_No_True() {
        e.setEmp_no(12345678);
        assertEquals(true, emp_no_checker.check(e));
    }

    @Test
    @DisplayName("checking emp_no_checker returns false if employee's emp_no is more then 8 digits")
    public void checkEmp_No_False() {
        e.setEmp_no(123456789);
        assertEquals(false, emp_no_checker.check(e));
    }

}