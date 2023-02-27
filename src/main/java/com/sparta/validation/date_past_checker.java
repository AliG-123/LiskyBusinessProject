package com.sparta.validation;

import com.sparta.entities.Employee;

import java.sql.Date;

public class date_past_checker {

    public boolean check(Employee employee){
        boolean isPast = false;
        Date currentDate = new Date(System.currentTimeMillis());
        if(employee.getBirth_date().before(currentDate) && employee.getHire_date().before(currentDate)){
            isPast = true;
        }

        return isPast;

    }
}
