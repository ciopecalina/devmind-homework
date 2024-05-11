package test;

import main.Exercise;
import org.junit.Assert;

import java.io.*;
import java.util.Scanner;

public class Checker {
    public static long filesCompareByLine(String path1, String path2) throws IOException {
        try (BufferedReader bf1 = new BufferedReader(new FileReader(path1));
             BufferedReader bf2 = new BufferedReader(new FileReader(path2))) {

            long lineNumber = 1;
            String line1 = "", line2 = "";
            while ((line1 = bf1.readLine()) != null) {
                line2 = bf2.readLine();
                if (line2 == null || !line1.equals(line2)) {
                    return lineNumber;
                }
                lineNumber++;
            }
            if (bf2.readLine() == null) {
                return -1;
            } else {
                return lineNumber;
            }
        }
    }

    public static void testCase(int testNumber) {

        File file = new File("./test/in/test" + String.valueOf(testNumber) + ".in");
        String outputPath = "./test/out/test" + String.valueOf(testNumber) + ".out";
        String referencePath = "./test/ref/test" + String.valueOf(testNumber) + ".ref";

        try {
            FileReader fileReader = new FileReader(file);
            FileWriter outputFile = new FileWriter(outputPath);

            Scanner scanner = new Scanner(fileReader);

            String targetWord = scanner.nextLine();
            String substituteWord = scanner.nextLine();

            Exercise exercise = new Exercise();

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String replacedWordsLine = exercise.solve(nextLine, targetWord, substituteWord);
                outputFile.write(replacedWordsLine);
                outputFile.write("\n");
            }

            scanner.close();
            fileReader.close();
            outputFile.close();

            long differingLine = filesCompareByLine(outputPath, referencePath);
            Assert.assertEquals(differingLine, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
