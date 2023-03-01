package com.sparta.app;

import com.sparta.entities.Employee;

import java.util.ArrayList;

public class ValidationCheck {
    static ArrayList<Employee> validList = new ArrayList<>();
    static ArrayList<Employee> corruptList = new ArrayList<>();

    // Call this method to populate validList and corruptList.
    // Pass it the totalList
    public static void createLists(ArrayList<Employee> totalList) {
        for (Employee e : totalList) {
//            if (birth_date_checker.check(e) && date_format_checker.check(e) && date_past_checker.check(e)
//                    && emp_no_checker.check(e) && gender_checker.check(e) && hire_date_checker.check(e)
//                        && names_checker.check(e)) {
//                validList.add(e);
//            } else {
//                corruptList.add(e);
//            }
        }
    }
}
