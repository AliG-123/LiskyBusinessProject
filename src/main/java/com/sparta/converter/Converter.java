package com.sparta.converter;

public interface Converter {
    void objectToFile(String path, Object o);
    Object fileToObject(String path);

}
