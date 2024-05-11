package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    public void solve(Scanner scanner, BufferedWriter writer) throws IOException {
        //Read content from file
        String[] words = readFromFile(scanner);

        //Generate WordStats
        WordStats wordStats = generateWordStats(words);

        //Write result to file
        writeToFile(writer, wordStats);
    }

    private void writeToFile(BufferedWriter writer, WordStats wordStats) throws IOException {
        writer.write(wordStats.listOfWords + "\n");

        for (String word : wordStats.shortestWord) {
            writer.write(word + "\n");
        }

        for (String word : wordStats.longestWord) {
            writer.write(word + "\n");
        }

        writer.write(wordStats.firstWordInAscOrder + "\n");
        writer.write(wordStats.lastWordInAscOrder + "\n");
        writer.write(wordStats.noOfWords + "\n");

        writer.close();
    }

    private WordStats generateWordStats(String[] words) {
        WordStats wordStats = new WordStats();

        wordStats.listOfWords = Arrays.toString(Arrays.copyOf(words, words.length));

        int minLength = Integer.MAX_VALUE, maxLength = Integer.MIN_VALUE;
        int minLengthCount = 0, maxLengthCount = 0;

        for (String word : words) {
            if (word.length() < minLength) {
                minLength = word.length();
            } else if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        for (String word : words) {
            int wordLength = word.length();
            if (wordLength == minLength) {
                minLengthCount++;
            } else if (wordLength == maxLength) {
                maxLengthCount++;
            }
        }

        wordStats.shortestWord = new String[minLengthCount];
        wordStats.longestWord = new String[maxLengthCount];
        int shortestIndex = 0, longestIndex = 0;
        for (String word : words) {
            if (word.length() == minLength) {
                wordStats.shortestWord[shortestIndex++] = word;
            } else if (word.length() == maxLength) {
                wordStats.longestWord[longestIndex++] = word;
            }
        }

        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        wordStats.noOfWords = words.length;
        wordStats.firstWordInAscOrder = words[0];
        wordStats.lastWordInAscOrder = words[words.length - 1];

        return wordStats;
    }

    private String[] readFromFile(Scanner scanner) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder words = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                words.append(line);
                words.append("\n");
            }
            return words.toString().split("\n");
        }
    }

    private static class WordStats {
        String listOfWords;
        String[] shortestWord;
        String[] longestWord;
        String firstWordInAscOrder;
        String lastWordInAscOrder;
        int noOfWords;
    }
}
