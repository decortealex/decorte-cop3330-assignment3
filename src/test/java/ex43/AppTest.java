/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex43;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppTest {

    String name = "Test-Site", author = "test";
    boolean css = true, js = true;

    String root = System.getProperty("user.dir");
    String siteDir = root + "\\src\\main\\java\\ex43\\website\\" + name + "\\";

    @Test
    void testGenSite() throws IOException {

        App.genSite(name, author, css, js);

        Assertions.assertTrue(Files.exists(Path.of(siteDir)));

        Assertions.assertTrue(Files.exists(Path.of(siteDir + "css\\")));

        Assertions.assertTrue(Files.exists(Path.of(siteDir + "js\\")));
    }

    @Test
    void testGenIndex() {
        App.genIndex(name, author, siteDir, root);

        Assertions.assertTrue(Files.exists(Path.of(siteDir + "index.html")));
    }
}
