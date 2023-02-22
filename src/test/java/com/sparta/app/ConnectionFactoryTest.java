package com.sparta.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionFactoryTest {
    @Test
    @DisplayName("Given no connection return not null when getConnection method is called")
    public void CallingGetConnection_ReturnNotNull(){
        Connection connection = ConnectionFactory.getConnection();
        assertNotNull(connection);
    }

    @Test
    @DisplayName("Given no connection return true if connection closes")
    public void CallingGetConnection_ReturnTrueIfConnectionCloses(){
        Connection connection = ConnectionFactory.getConnection();
        ConnectionFactory.closeConnection();
        assertTrue(connection.isClosed());
    }

    @Test
    @DisplayName("Check database name and return database name")
    public void CallingGetConnection_ReturnTrueIfValidDBname(){
        Connection connection = ConnectionFactory.getConnection();
        assertEquals("employees", connection.getCatalog());

    }

    @Test
    @DisplayName("Check dburl and return dburl if method is called")
    public void CallingGetConnection_ReturnTrueIfValidDbUrl(){
        Connection connection = ConnectionFactory.getConnection();
        assertEquals("jdbc:mysql://localhost:3306/employees", connection.getMetaData().getURL());
    }

    @Test
    @DisplayName("Check dbusername and return true if dbusername present")
    public void CallingGetConnection_ReturnValidUsername(){
        Connection connection = ConnectionFactory.getConnection();
        assertNotNull(connection.getMetaData().getUserName());
    }

    @Test
    @DisplayName("Check dbconnect properties file and return true if present")
    public void ReturnTrueIfPropertiesFilePresent(){
        File f = new File("src/main/resources/dbconnect.properties");
        assertTrue((f.exists()));
    }

    @Test
    @DisplayName("Given no connection return connection when getConnection method is called")
    public void CallingGetConnection_ReturnConnection(){
        Connection connection = ConnectionFactory.getConnection();
        assertEquals(connection, ConnectionFactory.getConnection());
    }

}