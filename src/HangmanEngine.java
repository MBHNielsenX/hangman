import java.util.ArrayList;
import java.util.Scanner;
public class HangmanEngine {
    static Scanner sc = new Scanner(System.in);
    public static void gameStart(String hangmanWord, int difficulty) {
        String difficultySet = "";
        if (difficulty == 1) {
            difficultySet = "Easy";
        } else if (difficulty == 2) {
            difficultySet = "Medium";
        } else if (difficulty == 3) {
            difficultySet = "Hard";
        }
        System.out.println("\nThe chosen difficulty is " + difficultySet.toLowerCase());
        System.out.println("Type anything to start the game:");
        if (sc.hasNext()) {
            clearScreen();
        } else {
            System.out.println("Please type anything to start the game");
        }
        int wordLength = findLengthOfWord(hangmanWord);

        ArrayList<String> theWordUnderscore = new ArrayList<String>();
        setup(theWordUnderscore, wordLength);
        System.out.println(hangmanWord);


    }

    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static int findLengthOfWord(String hangmanWord) {
        int count = 0;
        for (int i = 0; i < hangmanWord.length(); i++) {
            count++;
        }
        return count;

    }

    public static void setup(ArrayList<String> theWordUnderscore, int wordLength) {
        for (int i = 0; i < wordLength; i++) {
            theWordUnderscore.add("_ ");
        }
        for (int i = 0; i < theWordUnderscore.size() ; i++) {
            System.out.print(theWordUnderscore.get(i));
        }
    }

}
