package com.sparta.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeConverterTest {

    @Nested
    @DisplayName("tests formatting")
    class TestingFormatting {

        @Test
        @DisplayName("tests employee gets set to json format")
        public void givenEmployee_ReturnDetailsInJsonFormat() {

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