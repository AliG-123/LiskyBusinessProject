package com.sparta.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonConverter implements Converter {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void objectToFile(Object o) throws IOException {       // Converts object to Json (serialization)
        mapper.writeValue(new File("src/main/resources/JsonObject.json"), o);
    }

    @Override
    public Object fileToObject(String path) {
        return null;
    }   // Converts Json to Object
}
