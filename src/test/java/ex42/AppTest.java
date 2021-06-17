/*
 *  UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex42;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AppTest {
    final String filePath = "D:\\COP3330\\decorte-cop3330-assignment3\\src\\main\\resources\\exercise42_input.txt";
    FileParser underTesting = new FileParser(filePath, ",");
    ArrayList<String> rawData = new ArrayList<>(
            Arrays.asList("Ling,Mai,55900", "Johnson,Jim,56500", "Jones,Aaron,46000",
                    "Jones,Chris,34500", "Swift,Geoffrey,14200", "Xiong,Fong,65000", "Zarnecki,Sabrina,51500")
    );

    ArrayList<Employee> empData = new ArrayList<>(
            Arrays.asList(new Employee("Mai", "Ling", 55900),
                    new Employee("Jim", "Johnson",56500),
                    new Employee("Aaron", "Jones",46000),
                    new Employee("Chris", "Jones",34500),
                    new Employee("Geoffrey", "Swift", 14200),
                    new Employee("Fong", "Xiong", 65000),
                    new Employee("Sabrina", "Zarnecki", 51500))
    );

    @Test
    void testReadFile() { Assertions.assertEquals(rawData, underTesting.readFile()); }

    @Test
    void testParseData() {
        ArrayList<Employee> result = underTesting.parseData(rawData);
        for(int i = 0; i < result.size(); i++) {
            Assertions.assertNotNull(result.get(i));
            Assertions.assertEquals(empData.get(i).fName, result.get(i).fName);
            Assertions.assertEquals(empData.get(i).lName, result.get(i).lName);
            Assertions.assertEquals(empData.get(i).salary, result.get(i).salary);
        }
    }

}
