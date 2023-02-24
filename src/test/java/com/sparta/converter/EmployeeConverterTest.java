package com.sparta.converter;

import com.sparta.app.ConnectionFactory;
import com.sparta.entities.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeConverterTest {

    @Nested
    @DisplayName("tests formatting")
    class TestingFormatting {

        @Test
        @DisplayName("tests employee gets set to json format")
        public void givenEmployee_ReturnDetailsInJsonFormat() throws FileNotFoundException {
            ConverterFactory cFactory = new JsonConverterFactory();
            Converter converter = cFactory.getConverter();
            Employee employee = new Employee();
            converter.objectToFile("src/main/resources/employees.json", employee);
            assertEquals("", new FileReader("src/main/resources/employees.json"));
        }

        @Test
        @DisplayName("tests employee gets set to xml format")
        public void givenEmployee_ReturnDetailsInXMLFormat() {

        }

    }

    @Nested
    @DisplayName("tests writing to file")
    class TestingWriting {

        @Test
        @DisplayName("tests employee gets written to json file")
        public void givenEmployee_DetailsAreWrittenToJsonFile() {

        }

        @Test
        @DisplayName("tests employee gets written to XML file")
        public void givenEmployee_DetailsAreWrittenToXmlFile() {

        }
    }

}