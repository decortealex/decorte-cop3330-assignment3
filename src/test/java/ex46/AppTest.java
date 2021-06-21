/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex46;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class AppTest {
    String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\exercise46_input.txt";
    ArrayList<Word> words = App.wordFrequencyFinder(filePath);

    @Test
    void testWordFreqFinder() {
        int[] freqs = {7, 2, 1};

        for(int i = 0; i < freqs.length; i++) {
            Assertions.assertEquals(freqs[i], words.get(i).freq);
        }
    }

    @Test
    void testSort() {
        int[] sortedFreqs = {7, 2, 1};
        ArrayList<Word> sortedWords = App.sortByFreq(words);

        for(int i = 0; i < sortedFreqs.length; i++) {
            Assertions.assertEquals(sortedFreqs[i], sortedWords.get(i).freq);
        }
    }
}
