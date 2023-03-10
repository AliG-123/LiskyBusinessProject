package com.sparta.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.app.ConnectionFactory;
import com.sparta.entities.Department;
import com.sparta.entities.Employee;
import com.sparta.interfaces.DAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            preparedStatement = connection.prepareStatement("Select distinct Employees.employees.emp_no,\n" +
                    "\tEmployees.departments.dept_no,\n" +
                    "    Employees.employees.birth_date,\n" +
                    "\tEmployees.employees.first_name,\n" +
                    "    Employees.employees.gender,\n" +
                    "    Employees.employees.last_name,\n" +
                    "    Employees.employees.hire_date,\n" +
                    "    Employees.departments.dept_name, \n" +
                    "    Employees.dept_emp.from_date, \n" +
                    "    Employees.dept_emp.to_date\n" +
                    "    from Employees.employees, Employees.dept_emp, Employees.departments\n" +
                    "where Employees.employees.emp_no = Employees.dept_emp.emp_no\n" +
                    "and Employees.departments.dept_no = Employees.dept_emp.dept_no" +
                    " and Employees.employees.emp_no = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                if (employeeFoundById == null) {
                    employeeFoundById = new Employee(
                            resultSet.getDate(3),
                            resultSet.getInt(1),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDate(7),
                            resultSet.getString(6),
                            new Department(resultSet.getString(2), resultSet.getString(8)));
//               System.out.println(resultSet.getInt(1) + " " + resultSet.getString(3));
                } else {
                    employeeFoundById.getDepartmentList().add(new Department(resultSet.getString(2), resultSet.getString(8)));
                }
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
            preparedStatement = connection.prepareStatement("Select distinct Employees.employees.emp_no,\n" +
                    "\tEmployees.departments.dept_no,\n" +
                    "    Employees.employees.birth_date,\n" +
                    "\tEmployees.employees.first_name,\n" +
                    "    Employees.employees.gender,\n" +
                    "    Employees.employees.last_name,\n" +
                    "    Employees.employees.hire_date,\n" +
                    "    Employees.departments.dept_name, \n" +
                    "    Employees.dept_emp.from_date, \n" +
                    "    Employees.dept_emp.to_date\n" +
                    "    from Employees.employees, Employees.dept_emp, Employees.departments\n" +
                    "where Employees.employees.emp_no = Employees.dept_emp.emp_no\n" +
                    "and Employees.departments.dept_no = Employees.dept_emp.dept_no");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employeeToAdd = new Employee(
                        resultSet.getDate(3),
                        resultSet.getInt(1),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(7),
                        resultSet.getString(6),
                        new Department(resultSet.getString(2), resultSet.getString(8)));

                if (!employeesList.contains(employeeToAdd)) {
                    employeesList.add(employeeToAdd);
                } else {
                    int indexOfEmployee = employeesList.indexOf(employeeToAdd);
                    employeesList.get(indexOfEmployee).getDepartmentList().add(new Department(resultSet.getString(2), resultSet.getString(8)));
                }
                //System.out.println(resultSet.getString(3));
                System.out.println(employeeToAdd.getFirst_name() + " " + employeeToAdd.getLast_name());
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


    public static void convertToJacksonFormat(List<Employee> employeeList, Scanner scanner) {
        System.out.print("Enter desired file type (json/xml): ");
        String fileType = scanner.nextLine().toLowerCase();

        switch (fileType) {
            case "json":
                convertToJson(employeeList);
                break;
            case "xml":
                convertToXml(employeeList);
                break;
            default:
                System.out.println("Invalid file type entered.");
        }
    }
    private static void convertToJson(List<Employee> employeeList) {
        // implementation for converting to JSON
    }
    private static void convertToXml(List<Employee> employeeList) {
        // implementation for converting to XML
    }

    public List findEmployeesByDeptAndDate(String dept, String fromDate, String toDate) {
        List<Employee> listOfEmployees = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (dept.matches("^[a-zA-Z ]+$")) {
            if (fromDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                if (toDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    try {
                        Connection connection = ConnectionFactory.getConnection();
                        preparedStatement = connection.prepareStatement("Select distinct Employees.employees.emp_no,\n" +
                                "\tEmployees.departments.dept_no,\n" +
                                "    Employees.employees.birth_date,\n" +
                                "\tEmployees.employees.first_name,\n" +
                                "    Employees.employees.gender,\n" +
                                "    Employees.employees.last_name,\n" +
                                "    Employees.employees.hire_date,\n" +
                                "    Employees.departments.dept_name, \n" +
                                "    Employees.dept_emp.from_date, \n" +
                                "    Employees.dept_emp.to_date\n" +
                                "    from Employees.employees, Employees.dept_emp, Employees.departments\n" +
                                "where Employees.employees.emp_no = Employees.dept_emp.emp_no\n" +
                                "and Employees.departments.dept_no = Employees.dept_emp.dept_no\n" +
                                "and ((Employees.dept_emp.from_date < ?\n" +
                                "and Employees.dept_emp.to_date >= ?)\n" +
                                "or (Employees.dept_emp.from_date >= ? \n" +
                                "and Employees.dept_emp.from_date <= ?))\n" +
                                "and employees.departments.dept_name = ?;");
                        preparedStatement.setString(1, fromDate.toString());
                        preparedStatement.setString(2, fromDate.toString());
                        preparedStatement.setString(3, fromDate.toString());
                        preparedStatement.setString(4, fromDate.toString());
                        preparedStatement.setString(5, dept);

                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            Employee employeeToAdd = new Employee(
                                    resultSet.getDate(3),
                                    resultSet.getInt(1),
                                    resultSet.getString(4),
                                    resultSet.getString(5),
                                    resultSet.getDate(7),
                                    resultSet.getString(6),
                                    new Department(resultSet.getString(2), resultSet.getString(8)));
                            if (!listOfEmployees.contains(employeeToAdd)) {
                                listOfEmployees.add(employeeToAdd);
                            } else {
                                int indexOfEmployee = listOfEmployees.indexOf(employeeToAdd);
                                listOfEmployees.get(indexOfEmployee).getDepartmentList().add(new Department(resultSet.getString(2), resultSet.getString(8)));
                            }
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
                } else {
                    System.out.println("Please enter to date in the following format: YYYY-MM-DD");
                }
            } else {
                System.out.println("Please enter from date in the following format: YYYY-MM-DD");
            }
        } else {
            System.out.println("Please enter only letters and spaces");
        }

        return listOfEmployees;


    }
}