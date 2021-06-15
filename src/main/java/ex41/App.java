/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex41;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static ArrayList<String> readFile(String fileName) {
        BufferedReader input;
        String line;
        ArrayList<String> buf = new ArrayList<>();
        boolean EOF = false;

        try {
            input = new BufferedReader(new FileReader(fileName)); // open file

            do {
                line = input.readLine(); // read contents of file into buffer line by line
                if(line != null) {
                    buf.add(line);
                } else {
                    EOF = true;
                }
            } while(!EOF); // stop reading when EOF reached

            input.close(); // close file
        }
        catch(IOException io) {
            System.out.printf("'%s' not found.\n", fileName);
        }

        return buf;
    }

    // print sorted list to file
    public static void printToFile(String fileName, ArrayList<String> data) {
        FileWriter output;

        try {
             output = new FileWriter(fileName);
            for (String line : data) {
                output.write(line);
                output.write("\n");
                output.flush();
            }
        } catch(IOException io) {
            System.out.printf("'%s' is a directory, cannot be opened, or cannot be created.", fileName);
        }
    }

    public static void sortAndPrintEmpListFromFile(String fileName) {
        ArrayList<String> data;
        String wFileName = "src\\main\\resources\\exercise41_output.txt";

        data = readFile(fileName);
        Collections.sort(data); // sort array
        printToFile(wFileName, data);
    }

    public static void main(String[] args) {
        sortAndPrintEmpListFromFile("src\\main\\resources\\exercise41_input.txt");

    }
}
