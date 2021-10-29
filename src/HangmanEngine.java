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
        }
        gameMechanics(hangmanWord);
    }

    public static void gameMechanics(String hangmanWord) {
        int wordLength = findLengthOfWord(hangmanWord);

        ArrayList<String> theWordEdit = new ArrayList<String>();
        setup(theWordEdit, wordLength);
        System.out.println("\nPlease guess a letter in the word: ");

        while (true) {
            for (int i = 0; i < theWordEdit.size(); i++) {
                System.out.print(theWordEdit.get(i));
            }
            System.out.println();

            char playerInput = getCharInput();
            String playerGuess = Character.toString(playerInput);
            playerGuess.toLowerCase();

            changeTheStringArray(theWordEdit,wordLength,isLetterInWord(playerGuess,hangmanWord),playerGuess);

        }

    }



    public static boolean isLetterInWord(String playerGuess, String hangmanWord) {
        for (int i = 0; i < hangmanWord.length(); i++) {
            if (playerGuess.equals(hangmanWord.charAt(i))) {
                return true;
            }
        }
        return false;
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

    public static void setup(ArrayList<String> theWordEdit, int wordLength) {
        for (int i = 0; i < wordLength; i++) {
            theWordEdit.add("_ ");
        }
    }

    public static ArrayList<String> changeTheStringArray(ArrayList<String> theWordEdit, int wordLength, boolean isLetterInWord, String playerGuess) {
        for (int i = 0; i < wordLength; i++) {
            int index = i;
            if (isLetterInWord) {
                //putLetterInList(theWordEdit, playerGuess, index);
                theWordEdit.set(index, playerGuess);

            }
        }
        return theWordEdit;
    }

    public static ArrayList<String> putLetterInList(ArrayList<String> theWordEdit, String playerGuess,int index){

        theWordEdit.add(index, playerGuess);

        return theWordEdit;
    }
    static char getCharInput(){
        //Neutralizes the bug that happens when you use the same char scanner multiple times.
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

}
