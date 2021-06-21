/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex45;

import org.junit.jupiter.api.*;

public class AppTest {

    @Test
    void testFindAndReplace() {
        String input = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "utilizes an IDE to write her Java programs\".";

        String desired = "One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "uses an IDE to write her Java programs\".";

        Assertions.assertEquals(desired, App.findAndReplace(input, "utilize", "use"));
    }
}
