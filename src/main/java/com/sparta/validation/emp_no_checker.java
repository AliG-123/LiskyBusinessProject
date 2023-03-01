package com.sparta.validation;

import com.sparta.entities.Employee;

public class emp_no_checker {
    public static boolean check(Employee e) {
        if (String.valueOf(e.getEmp_no()).length() <= 8) {
            return true;
        } else {
            return false;
        }
    }
}
