package com.sparta.dao;

import com.sparta.app.ConnectionFactory;
import com.sparta.entities.Employee;
import com.sparta.interfaces.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements DAO {

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void updated(Object update) {

    }

    @Override
    public int insert(Object newRow) {
        return 0;
    }

    @Override
    public Object findByID(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employeeFoundById = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employees.employees WHERE employees.emp_no = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
//               employeeFoundById = new Employee(
//                       resultSet.getInt(1),
//                       resultSet.getDate(2),
//                       resultSet.getString(3),
//                       resultSet.getString(4),
//                       resultSet.getString(5),
//                       resultSet.getDate(6));
               System.out.println(resultSet.getInt(1) + " " + resultSet.getString(3));
           }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionFactory.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return employeeFoundById;
    }

    @Override
    public List findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employeesList = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employees");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
//                employeesList.add(new Employee(
//                        resultSet.getInt(1),
//                        resultSet.getDate(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5),
//                        resultSet.getDate(6)));
                System.out.println(resultSet.getString(3));
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionFactory.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ;
        }

        return employeesList;
    }
}
