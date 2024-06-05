package user_profile;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Unique {
    String getUniqueID(); // returneaza id-ul problemei
}

class Challenge implements Unique {

    // Completati clasa
    private final String id;
    private final int maxScore;
    private int score;
    private int attempts;

    public Challenge(String id, int maxScore) {
        this.id = id;
        this.maxScore = maxScore;
    }

    @Override
    public String getUniqueID() {
        return this.id;
    }

    public void setScore(int score) {
        if (score > this.score) {
            this.score = score;
        }
        this.attempts += 1;
    }

    public int getScore() {
        return this.score;
    }

    public int getAttempts() {
        return this.attempts;
    }

    @Override
    public String toString() {
        return "Challenge " + this.id
                + ": Score: " + this.score + "/" + this.maxScore
                + " (Attempts: " + this.attempts + ")";

    }
}

interface ILogging {
    boolean login(String password);

    void logout();

    boolean isLoggedIn();
}

class UserLogging implements ILogging {
    private final String username;
    private String password;
    // Definiti toate campurile necesare aici
    private boolean isAlreadyLoggedIn;

    public UserLogging(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAlreadyLoggedIn = false;
    }

    @Override
    public boolean login(String password) {
        if ((password == this.password) && (isAlreadyLoggedIn == false)) {
            isAlreadyLoggedIn = true;
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        isAlreadyLoggedIn = false;
    }

    @Override
    public boolean isLoggedIn() {
        return isAlreadyLoggedIn;
    }
}

class UserProfile extends UserLogging implements Comparable<UserProfile> {

    private int score;
    private Map<String, Integer> solved = new HashMap<>();

    // Completati clasa
    public UserProfile(String username, String password) {
        super(username, password);
        this.score = 0;
    }

    @Override
    public int compareTo(UserProfile o) {
        return Integer.compare(this.getScore(), o.getScore());
    }

    // Completati clasa

    public int getScore() {
        return this.score;
    }

    public void solve(Challenge newChallange) {
        String idNewChallange = newChallange.getUniqueID();
        int newScore = newChallange.getScore();

        if (solved.containsKey(idNewChallange)) {
            int currentScore = solved.get(idNewChallange);
            if (newScore > currentScore) {
                this.score = this.score + newScore - currentScore;

                solved.put(idNewChallange, newScore);
            }
        } else {
            this.score += newScore;
            solved.put(idNewChallange, newScore);
        }
    }
}

  /*-----------------------------------------------------------
  * The methods below are used for Testing Purposes only.
  * Do not modify them.
  -----------------------------------------------------------*/

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testNumber = sc.nextInt();
        sc.close();

        switch (testNumber) {
            case 0:
                // TEST 0 - Sanity check (no compilation / running errors in the system)
                System.out.println("Ok! Let's start!");
                break;
            case 1:
                // TEST 1 - Testing class Challenge functionality
                Challenge ch = new Challenge("#213456", 30);
                System.out.println("Initial score: " + ch.getScore());
                System.out.println("Challenge Unique ID: " + ch.getUniqueID());

                ch.setScore(10);
                ch.setScore(15);

                System.out.println("\nChallenge new score: " + ch.getScore());
                System.out.println("Number of attempts: " + ch.getAttempts());

                ch.setScore(13);

                System.out.println("\n" + ch);
                break;
            case 2:
                // TEST 2 -  Testing class UserLogging
                UserProfile usr1 = new UserProfile("bill.gates", "#msft123!");

                System.out.println("Is user logged in (initially)? R: " + usr1.isLoggedIn());
                System.out.println("Trying to log in using a wrong password. R: " + usr1.login("dummyPwd"));
                System.out.println("Is user logged in (after incorrect password)? R: " + usr1.isLoggedIn());
                System.out.println("Trying to log in with the right password. R: " + usr1.login("#msft123!"));
                System.out.println("Is user logged in (after correct password)? R: " + usr1.isLoggedIn());
                System.out.println("Trying to log in AGAIN with the right password. R: " + usr1.login("#msft123!"));
                System.out.println("Is user STILL logged in? R: " + usr1.isLoggedIn());
                usr1.logout();
                System.out.println("Is user logged in (after log out)? R: " + usr1.isLoggedIn());
                System.out.println("Trying to log in with the right password. R: " + usr1.login("#msft123!"));
                System.out.println("Is user logged in (after correct password)? R: " + usr1.isLoggedIn());
                break;
            case 3:
                // TEST 3 - Testing class UserProfile: user solving new challenges (one time)
                Challenge ch1 = new Challenge("#13134", 30);
                Challenge ch2 = new Challenge("#43215", 20);
                UserProfile usr11 = new UserProfile("jeff.dean", "#ggl310*");

                ch1.setScore(20);
                usr11.solve(ch1);
                System.out.println("User total score after solving 1 challenge is: " + usr11.getScore());
                ch2.setScore(20);
                usr11.solve(ch2);
                System.out.println("User total score after solving one more challenge is: " + usr11.getScore());
                break;
            case 4:
                // TEST 4 - Testing class UserProfile:  user solving challenges (multiple times, different scores)
                Challenge ch31 = new Challenge("#13134", 45);
                Challenge ch32 = new Challenge("#43215", 30);
                UserProfile usr2 = new UserProfile("jeff.dean", "#ggl310*");

                ch31.setScore(10);
                usr2.solve(ch31);
                ch32.setScore(15);
                usr2.solve(ch32);
                System.out.println("User total score after solving 2 challenges is: " + usr2.getScore());

                ch31.setScore(15);
                ch32.setScore(25);
                usr2.solve(ch31);
                usr2.solve(ch32);
                System.out.println("User total score after solving again the first two challenge: " + usr2.getScore());

                ch31.setScore(10);
                Challenge ch33 = new Challenge("#33134", 20);
                ch33.setScore(20);
                usr2.solve(ch33);
                System.out.println("User total score after solving again the first challenge and a new one: " + usr2.getScore());
                break;
            case 5:
                // [HARD] TEST 5 - Testing class UserProfile: test user ranking functionality (Comparable interface)
                UserProfile usr3 = new UserProfile("steve.jobs", "#appl$214");
                Challenge och1 = new Challenge("#21341", 30);
                Challenge och2 = new Challenge("#41232", 20);
                Challenge otherCh = new Challenge("#97453", 40);

                och2.setScore(15);
                usr3.solve(och2);
                och1.setScore(4);
                usr3.solve(och1);
                otherCh.setScore(20);
                usr3.solve(otherCh);

                System.out.println("User3 score after multiple challenges solved: " + usr3.getScore());

                otherCh.setScore(29);
                usr3.solve(otherCh);
                otherCh.setScore(18);
                usr3.solve(otherCh);
                och1.setScore(5);
                usr3.solve(och1);
                och2.setScore(10);
                usr3.solve(och2);
                System.out.println("User3 score after re-solving some challenges: " + usr3.getScore());

                UserProfile usr4 = new UserProfile("mark.zuckerberg", "#fb$@16");
                Challenge ch41 = new Challenge("#13134", 30);
                Challenge ch42 = new Challenge("#43215", 20);

                ch41.setScore(20);
                usr4.solve(ch41);
                ch42.setScore(20);
                ch41.setScore(15);
                usr4.solve(ch41);
                usr4.solve(ch42);
                ch41.setScore(15);
                usr4.solve(ch41);

                System.out.println("User4 score after multiple challenges solved: " + usr4.getScore());

                // Testing the comparison function Comparing the users
                System.out.println("Compare: User4 vs. User 3: " + usr4.compareTo(usr3));
                System.out.println("Compare: User3 vs. User 4: " + usr3.compareTo(usr4));
                System.out.println("Compare: User3 vs. User 3: " + usr3.compareTo(usr3));

                ch41.setScore(30);
                usr4.solve(ch41);

                System.out.println("User4 score after solving again a challenge: " + usr4.getScore());
                System.out.println("Compare: User3 vs. User 4: " + usr3.compareTo(usr4));

                break;
            default:
                System.err.println("No such test case. Number: " + testNumber);
        }
    }
}
