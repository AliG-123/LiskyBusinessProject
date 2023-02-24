package com.sparta.app;

import com.sparta.converter.Converter;
import com.sparta.converter.ConverterFactory;
import com.sparta.converter.JsonConverterFactory;
import com.sparta.converter.XmlConverterFactory;
import com.sparta.entities.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Everything runs upon Creator.Create() call.
public class Creator {

    public static void Create() {
        // This returns the needed Converter (xml or Json)
        Converter converter = getConvertFactory(Ask());

        // Ask the user for a filename
        String filename = askFileName();

        try {
            // Now we call the ObjectToFileMethod on the converter,
            // passing also the filename.
            converter.objectToFile(new Employee(), filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String Ask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired file type (json/xml): ");
        String fileType = scanner.nextLine().toLowerCase();
        return fileType;
    }

    public static String askFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        return scanner.nextLine();
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

