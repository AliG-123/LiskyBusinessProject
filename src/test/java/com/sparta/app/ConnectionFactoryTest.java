package com.sparta.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionFactoryTest {

    public Connection getConnection() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            return connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection = getConnection();

    @Test
    @DisplayName("Given no connection return not null when getConnection method is called")
    public void CallingGetConnection_ReturnNotNull(){
        assertNotNull(connection);
    }



    @Test
    @DisplayName("Check database name and return database name")
    public void CallingGetConnection_ReturnTrueIfValidDBname() throws SQLException {
        assertEquals("employees", connection.getCatalog());
    }

    @Test
    @DisplayName("Check dburl and return dburl if method is called")
    public void CallingGetConnection_ReturnTrueIfValidDbUrl() throws SQLException {
        assertEquals("jdbc:mysql://localhost:3306/employees", connection.getMetaData().getURL());
    }

    @Test
    @DisplayName("Check dbusername and return true if dbusername present")
    public void CallingGetConnection_ReturnValidUsername() throws SQLException {
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
public void CallingGetConnection_ReturnConnection() throws SQLException, IOException {
        assertEquals(connection, ConnectionFactory.getConnection());
    }
    @Test
//    @AfterAll
    @DisplayName("Given the connection is closed return true if connection closes")
    public void CallingGetConnection_ReturnTrueIfConnectionCloses() throws SQLException {
        ConnectionFactory.closeConnection();
        assertTrue(connection.isClosed());
        connection = getConnection();
    }

}
