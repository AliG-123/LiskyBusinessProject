package com.sparta.dao;

import com.sparta.entities.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Test
   // @DisplayName("")
    public void testFindById() {
        EmployeeDao employeeDao = new EmployeeDao();
      //  Employee expected = new Employee(1, "", "M", new Date(), "Doe");
        Employee actual =  employeeDao.findByID(10001);
        assertEquals(10001, actual.getEmp_no());
    }

    @ParameterizedTest
    @CsvSource({"10001, 10001", "10002, 10002"})
    public void testMultipleIds(int input, int expected) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee actual =  employeeDao.findByID(input);
        assertEquals(expected, actual.getEmp_no());
    }


    @Test
    public void testFindAll() {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> actual = employeeDao.findAll();
        employeeDao.insert(new Employee(new Date(12, 12, 22), 300024, "Bob", "M", new Date(), "Smith"));
        List<Employee> expected = employeeDao.findAll();
        assertEquals(expected.size(), actual.size() + 1);
    }

    @ParameterizedTest
    @CsvSource({"10001, 2"})
    public void testFindAll(int expectedId, int expectedSize) {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> actual = employeeDao.findAll();
        assertEquals(expectedSize, actual.size());
        assertTrue(actual.stream().anyMatch(e -> e.getEmp_no() == expectedId));
    }


    @Test
    public void testUpdateEmployee() {
        // Create a new Employee object
        Employee newEmployee = new Employee(new Date(), 10001, "John", "Doe", new Date(), "M");

        // Insert the new employee into the database
        EmployeeDao employeeDao = new EmployeeDao();
        int id = employeeDao.insert(newEmployee);

        // Update the employee's first name and last name
        newEmployee.setFirst_name("Jane");
        newEmployee.setLast_name("Doe");
        employeeDao.updated(newEmployee);

        // Retrieve the updated employee from the database
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE emp_no = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            // Check that the employee's first name and last name have been updated in the database
            assertEquals("Jane", firstName);
            assertEquals("Doe", lastName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}



