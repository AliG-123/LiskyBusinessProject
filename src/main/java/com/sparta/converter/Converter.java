package com.sparta.converter;

import java.io.IOException;

public interface Converter {
    void objectToFile(Object o, String filename) throws IOException;
    Object fileToObject(String path);
}
