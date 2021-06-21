/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 3 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */
package ex46;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

public class App {
    public static ArrayList<Word> wordFrequencyFinder(String fName) {
        File input = new File(fName);
        ArrayList<Word> words = new ArrayList<>();
        StringBuilder rawData = new StringBuilder();
        String[] lineList, wordList;

        // for line in file
        try(Stream<String> stream = Files.lines(input.toPath(), StandardCharsets.UTF_8)) {
            stream.forEach(s -> rawData.append(s).append("\n"));

            lineList = rawData.toString().split("\n"); // split file string into lines
            for(String line : lineList) { // for line in lines[]

                wordList = line.split(" "); // split line into words
                for(String word : wordList) { // for word in words[]
                    int index = -1;
                    for(int i = 0; i < words.size(); i++) { // check if word exists in arraylist and get index
                        if(words.get(i).val.equalsIgnoreCase(word)) {
                            index = i;
                        }
                    }
                    if(index > -1) { // word exists
                        words.get(index).freq++;

                    } else { // word does not exist
                        words.add(new Word(word));

                    }
                }
            }


        } catch(IOException io) {
            System.out.println("input file not found");
        }
        return words;
    }

    public static ArrayList<Word> sortByFreq(ArrayList<Word> unsorted) {
        ArrayList<Word> buf = unsorted;
        ArrayList<Word> sorted = new ArrayList<>(unsorted.size());
        int max, maxIndex = 0;
        for(int i = 0; i < unsorted.size(); i++) {
            max = Integer.MIN_VALUE;
            for(int j = 0; j < buf.size(); j++) {
                if(buf.get(j).freq > max)
                    max = buf.get(j).freq;
                    maxIndex = j;
            }
            sorted.add(buf.get(maxIndex));
            buf.remove(maxIndex);
        }
        return sorted;
    }

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\exercise46_input.txt";
        ArrayList<Word> unsorted_words = wordFrequencyFinder(filePath);
//        ArrayList<Word> sorted_words = sortByFreq(unsorted_words);

        for(Word word : unsorted_words) {
            System.out.printf("%s: ", word.val);
            for(int i = 0; i < word.freq; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class Word {
    public String val;
    public int freq;

    public Word(String value) {
        val = value;
        freq = 1;
    }
}
