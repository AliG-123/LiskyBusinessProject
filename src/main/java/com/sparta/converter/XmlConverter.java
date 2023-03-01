package com.sparta.converter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.entities.Employee;

import java.io.File;
import java.io.IOException;

public class XmlConverter implements Converter{

    private final XmlMapper mapper = new XmlMapper();

    @Override
    public void objectToFile(Object o, String filename) throws IOException {
        mapper.writeValue(new File("src/main/resources/" + filename + ".xml"), o);
    }


    @Override
    public Object fileToObject(String pathname) throws IOException {
        Object employeeFromXml = mapper.readValue(new File(pathname), Object.class);
        System.out.println( employeeFromXml );
        return employeeFromXml;
    }
}
