/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex44;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;

public class App {
    public static void parseJsonInventory(String fName) {
        Gson gson = new Gson();
        String data;
        try {
            data = Files.readString(Path.of(fName));
            String[][] products = gson.fromJson(data, String[][].class);
            System.out.print(products);
        } catch(IOException ignored) {}
    }
    public static void main(String[] args) {
        String fp = "D:\\COP3330\\decorte-cop3330-assignment3\\src\\main\\resources\\exercise44_input.json";
        parseJsonInventory(fp);
    }
}

class Product {
    public String name;
    public double price;
    public int quant;
}
