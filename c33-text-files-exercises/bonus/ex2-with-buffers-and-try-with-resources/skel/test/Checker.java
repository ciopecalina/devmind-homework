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

        File inputFile = new File("./test/in/test" + String.valueOf(testNumber) + ".in");
        File inputFile2 = new File("./test/in/test" + String.valueOf(testNumber) + "b.in");
        String outputPath = "./test/out/test" + String.valueOf(testNumber) + ".out";
        String referencePath = "./test/ref/test" + String.valueOf(testNumber) + ".ref";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
             BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            String[] nums1 = line1.split(" ");
            String[] nums2 = line2.split(" ");

            Exercise exercise = new Exercise();
            String numsOrderedAsc = exercise.solve(nums1, nums2);

            writer.write(numsOrderedAsc);

            long differingLine = filesCompareByLine(outputPath, referencePath);
            Assert.assertEquals(differingLine, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
