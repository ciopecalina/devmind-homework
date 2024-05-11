package main;

public class Exercise {
    public String solve(String restOfFileContent, String targetWord, String substituteWord) {
        return restOfFileContent.replaceAll(targetWord, substituteWord);
    }
}
