package com.sparta.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.entities.Employee;

import java.io.File;
import java.io.IOException;

public class JsonConverter implements Converter {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void objectToFile(Object o, String filename) throws IOException {       // Converts object to Json (serialization)
        mapper.writeValue(new File("src/main/resources/" + filename + ".json"), o);
    }


    // pass it a json string
    @Override
    public Object fileToObject(String jsonString) throws JsonProcessingException {
        return mapper.readValue(jsonString, Employee.class);
    }
}
