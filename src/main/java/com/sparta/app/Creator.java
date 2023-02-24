package com.sparta.app;

import com.sparta.converter.Converter;
import com.sparta.converter.ConverterFactory;
import com.sparta.converter.JsonConverterFactory;
import com.sparta.converter.XmlConverterFactory;
import com.sparta.entities.Employee;

import java.util.List;
import java.util.Scanner;

public class Creator {

    public static void Create() {
        getConvertFactory(Ask());
    }

    public static String Ask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired file type (json/xml): ");
        String fileType = scanner.nextLine().toLowerCase();
        return fileType;
    }

    public static Converter getConvertFactory(String fileType) {

        ConverterFactory cFactory = null;
        switch (fileType) {
            case "json":
                cFactory = new JsonConverterFactory();
                break;
            case "xml":
                cFactory = new XmlConverterFactory();
                break;
            default:
                System.out.println("Invalid file type entered.");
                return getConvertFactory(Ask());
        }
        return cFactory.getConverter();
    }
}

