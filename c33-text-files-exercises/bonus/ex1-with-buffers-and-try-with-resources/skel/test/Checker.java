package test;

import main.Exercise;
import org.junit.Assert;

import java.io.*;

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

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String targetWord = reader.readLine();
            String substituteWord = reader.readLine();

            StringBuilder restOfFileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                restOfFileContent.append(line).append("\n");
            }

            Exercise exercise = new Exercise();
            String newFileContent = exercise.solve(restOfFileContent.toString(), targetWord, substituteWord);

            writer.write(newFileContent);

            long differingLine = filesCompareByLine(outputPath, referencePath);
            Assert.assertEquals(differingLine, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
