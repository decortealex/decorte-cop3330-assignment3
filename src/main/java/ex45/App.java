/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex45;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
public class App {
    public static String findAndReplace(String target, String toReplace, String replaceWith) {
        return target.replace(toReplace, replaceWith);
    }

    public static void main(String[] args) {
        String outName,fileContent, root = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        Scanner in = new Scanner(System.in);
        File input = new File(root + "exercise45_input.txt");

        System.out.print("What should the output file be called: ");
        outName = in.nextLine();
        File output = new File(root + outName);

        try {
            fileContent = Files.readString(input.toPath());
            fileContent = findAndReplace(fileContent, "utilize", "use");
            Files.writeString(output.toPath(), fileContent);
        } catch(IOException io) {
            System.out.println("Input file could not be found.");
        }
    }
}
