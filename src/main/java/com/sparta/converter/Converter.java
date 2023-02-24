package com.sparta.converter;

import java.io.IOException;

public interface Converter {
//    void objectToFile(String path, Object o) throws IOException;
    void objectToFile(Object o) throws IOException;
    Object fileToObject(String path);

}
