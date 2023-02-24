package com.sparta.app;

import com.sparta.entities.Employee;

import java.util.List;
import java.util.Scanner;

public class Creator {


    public static void Create() {


    }

  /*  public static void Ask(List<Employee> employeeList, Scanner scanner) {
        System.out.print("Enter desired file type (json/xml): ");
        String fileType = scanner.nextLine().toLowerCase();

        switch (fileType) {
            case "json":
                convertToJson(employeeList);
                break;
            case "xml":
                convertToXml(employeeList);
                break;
            default:
                System.out.println("Invalid file type entered.");
        }
    } */


    public static void Ask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired file type (json/xml): ");
        String fileType = scanner.nextLine().toLowerCase();

        Factory(fileType);

    }

    public static void Factory(String fileType) {
//    convertToJson(employeeList);
        //     convertToXml(employeeList);
        switch (fileType) {
            case "json":
            //pass arraylist to json convertor
                break;
            case "xml":
         // pass arraylist to xml convertor
                break;
            default:
                System.out.println("Invalid file type entered.");
                Ask();
        }
    }


}
