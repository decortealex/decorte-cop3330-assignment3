/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex43;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

    /**
     * generates website skeleton based on params
     * @param name site name
     * @param author site author
     * @param css true if a CSS folder needs to be generated
     * @param js true if a JS folder needs to be generated
     * @return root path of website skeleton
     */
    public static void genSite(String name, String author, boolean css, boolean js) throws IOException{

        String root = System.getProperty("user.dir");
        String siteWorkingDir = root + "\\src\\main\\java\\ex43\\website\\" + name + "\\";

        Files.createDirectories(Paths.get(siteWorkingDir)); // create base directory for website
        System.out.printf("Created ./website/%s/\n", name);

        if(css) { // add css folder if needed
            Files.createDirectories(Paths.get(siteWorkingDir + "css\\"));
            System.out.printf("Created ./website/%s/css/\n", name);
        }
        if(js) { // add js folder if needed
            Files.createDirectories(Paths.get(siteWorkingDir + "js\\"));
            System.out.printf("Created ./website/%s/js/\n", name);
        }

        genIndex(name, author, siteWorkingDir, root); // generate index.html

    }

    /**
     * generates index.html file with pre-filled <title> tag and <meta> tag
     * @param dir directory to create html file in
     * @return true if index.html was successfully generated
     */
    public static void genIndex(String name, String author, String dir, String root) {
        // bring template html file into memory
        File htmlTemplate = new File(root + "\\src\\main\\resources\\indextemplate.html");
        String html = null;
        try {
            html = new String(Files.readAllBytes(htmlTemplate.toPath()));

            // replace tags with dynamic content
            html = html.replace("$title", name);
            html = html.replace("$author", author);

            File newHtml = new File(dir + "index.html");
            Files.writeString(newHtml.toPath(), html); // write string to index.
        } catch(IOException ignored) {}
    }

    public static void main(String[] args) {
        String name, author;
        boolean css, js;
        Scanner in = new Scanner(System.in);

        System.out.print("Site name: ");
        name = in.nextLine();
        System.out.print("Author: ");
        author = in.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        js = "y".equalsIgnoreCase(in.nextLine());
        System.out.print("Do you want a folder for CSS? ");
        css = "y".equalsIgnoreCase(in.nextLine());

        try {
            genSite(name, author, css, js);
        } catch(IOException io) {
            System.out.println("Error occurred");
        }
    }
}
