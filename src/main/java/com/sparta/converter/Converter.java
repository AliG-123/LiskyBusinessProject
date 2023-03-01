package com.sparta.converter;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface Converter {
    void objectToFile(Object o, String filename) throws IOException;
    Object fileToObject(String content) throws IOException;
}
