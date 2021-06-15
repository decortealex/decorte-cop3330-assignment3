/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex41;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppTest {
    @Test
    void testReadFile() {
        String fileName = "D:\\COP3330\\decorte-cop3330-assignment3\\src\\main\\resources\\exercise41_input.txt";

        ArrayList<String> desired = new ArrayList<>(
                Arrays.asList("Ling, Mai",
                        "Johnson, Jim",
                        "Zarnecki, Sabrina",
                        "Jones, Chris",
                        "Jones, Aaron",
                        "Swift, Geoffrey",
                        "Xiong, Fong")
        );

        Assertions.assertEquals(desired, App.readFile(fileName));
    }
}
