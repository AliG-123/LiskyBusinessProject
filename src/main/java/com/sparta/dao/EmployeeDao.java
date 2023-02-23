package com.sparta.dao;

import com.sparta.app.ConnectionFactory;
import com.sparta.entities.Employee;
import com.sparta.interfaces.DAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements DAO {

    @Override
    public void deleteById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE * FROM employees.employees WHERE employees.emp_no = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                ConnectionFactory.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updated(Object update) {

        PreparedStatement preparedStatement = null;
        Employee employee = (Employee) update;
        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE employees SET first_name = ?, last_name = ?, hire_date = ?, birth_date = ?, gender = ? WHERE emp_no = ?");
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setDate(3, new java.sql.Date(employee.getHire_date().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(employee.getBirth_date().getTime()));
            preparedStatement.setString(5, employee.getGender());
            preparedStatement.setInt(6, employee.getEmp_no());
            preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                ConnectionFactory.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public int insert(Object newRow) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        Employee employee = (Employee) newRow;

        int answer = 0;

        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO employees (first_name, last_name, hire_date, birth_date, emp_no, gender) VALUES (?, ?, ?, ?, ?, ?)"
            );
            //"UPDATE employees SET first_name = ?, last_name = ?, hire_date = ?, birth_date = ?, gender = ? WHERE emp_no = ?"
            preparedStatement.setString(1, employee.getFirst_name());
            preparedStatement.setString(2, employee.getLast_name());
            preparedStatement.setDate(3, new java.sql.Date(employee.getHire_date().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(employee.getBirth_date().getTime()));
            preparedStatement.setInt(5, employee.getEmp_no());
            preparedStatement.setString(6, employee.getGender());
            preparedStatement.execute();

            Statement statement = connection.createStatement();
            rs = statement.executeQuery("SELECT LAST_INSERT_ID()");

            rs.next();
            answer = rs.getInt(1);

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionFactory.closeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return answer;
    }

  /*  @Override
    public Employee findByID(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employeeFoundById = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employees.employees WHERE employees.emp_no = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
               employeeFoundById = new Employee(
                       resultSet.getDate(2),
                       resultSet.getInt(1),
                       resultSet.getString(3),
                       resultSet.getString(4),
                       resultSet.getDate(6),
                       resultSet.getString(5));
//               System.out.println(resultSet.getInt(1) + " " + resultSet.getString(3));
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
    } */

    @Override
    public Employee findByID(int id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employeeFoundById = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employees.employees WHERE employees.emp_no = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                employeeFoundById = new Employee(
                        resultSet.getDate(2),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(6),
                        resultSet.getString(5));
//               System.out.println(resultSet.getInt(1) + " " + resultSet.getString(3));
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException("Error while closing resources", e);
            }
        }
        return employeeFoundById;
    }


   /* @Override
    public List findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employeesList = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employees");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employeesList.add(new Employee(
                        resultSet.getDate(2),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(6),
                        resultSet.getString(5)));
//                System.out.println(resultSet.getString(3));
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

        return employeesList;
    } */


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
                employeesList.add(new Employee(
                        resultSet.getDate(2),
                        resultSet.getInt(1),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(6),
                        resultSet.getString(5)));
//                System.out.println(resultSet.getString(3));
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException("Error while closing resources", e);
            }
        }

        return employeesList;
    }

}

