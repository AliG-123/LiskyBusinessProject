package com.sparta.app;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private ConnectionFactory(){}



    private static Connection connection = null;
    public static Connection getConnection() throws IOException, SQLException {
        if(connection == null || connection.isClosed()){
            Properties props = new Properties();
            props.load(new FileReader("src/main/resources/dbconnect.properties"));
            connection = DriverManager.getConnection(props.getProperty("dburl"), props.getProperty("dbuser"), props.getProperty("dbpassword"));
        }
        return connection;
    }

    public static void closeConnection() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }
}
