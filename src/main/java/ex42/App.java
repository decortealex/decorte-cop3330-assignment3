/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex42;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

class Employee { // Employee class to hold data for each employee
    public String fName;
    public String lName;
    public int salary;

    public Employee(String fName, String lName, int salary) {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
    }
}

class FileParser {
    private String fName;
    private String delimiter;
    private BufferedReader input;
    private ArrayList<String> data;

    /**
     * Constructor for FileParser
     * @param fName name of file
     * @param delimiter character to use in splitting data
     */
    public FileParser(String fName, String delimiter) {
        this.delimiter = delimiter;
        this.fName = fName;
        try {
            input = new BufferedReader(new FileReader(fName));
        } catch(IOException io) {
            System.out.println("File not found");
        }
    }

    /**
     * reads file line-by-line into ArrayList buffer
     * @return ArrayList buffer of type String
     */
    public ArrayList<String> readFile() {
        data = new ArrayList<>();
        String line = "";
        boolean EOF = false;

        try {
            do {
                line = input.readLine();
                if(line == null) {
                    EOF = true;
                } else {
                    data.add(line);
                }
            } while(!EOF);
        } catch(IOException io) {
            System.out.println("Error encountered.");
        }
        return data;
    }

    /**
     * separates data in buffer based on delimiter
     * @param data buffer ArrayList generated in readFile()
     * @return ArrayList of Employee objects populated with the file data
     */
    public ArrayList<Employee> parseData(ArrayList<String> data) {
        ArrayList<Employee> employees = new ArrayList<>();
        String[] buf;

        for (String line : data) {
            buf = line.split(delimiter);
            employees.add(new Employee(buf[1], buf[0], Integer.parseInt(buf[2])));
        }

        return employees;
    }

    /**
     * reads file into buffer, parses data, and prints it out to System.out stream
     */
    public void parseAndPrintRecords() {
        ArrayList<Employee> employees;

        employees = parseData(data);

        System.out.printf("%10s%10s%10s\n", "Last", "First", "Salary");
        for(Employee employee : employees) {
            System.out.printf("%10s%10s%10d\n", employee.lName, employee.fName, employee.salary);
        }

    }
}

public class App {
    public static void main(String[] args) {
        final String filePath = "D:\\COP3330\\decorte-cop3330-assignment3\\src\\main\\resources\\exercise42_input.txt";
        FileParser empRecords = new FileParser(filePath, ",");

        empRecords.parseAndPrintRecords();
    }
}


