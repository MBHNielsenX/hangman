import java.util.ArrayList;
import java.util.Scanner;
public class HangmanEngine {
    //A counter that keeps track of incorrect letters
    static int incorrectWordCount = 0;
    //A counter that keeps track of correct letters
    static int correctWordCount = 0;
    public static void gameStart(String hangmanWord, int difficulty) {
        Scanner sc = new Scanner(System.in);
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
        //An arrayList that keeps the word before and after it being edited
        ArrayList<String> theWordEdit = new ArrayList<String>();
        //An array of the letters that the user types in
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        //A method that sets up the underscores in the array
        setup(theWordEdit, wordLength);

        System.out.println("\nPlease guess a letter in the word: ");
        //A while loop that loops the game functions
        while (true) {
            //A for loop that prints the word array
            for (int i = 0; i < theWordEdit.size(); i++) {
                System.out.print(theWordEdit.get(i));
            }
            System.out.println();
            System.out.print("Guessed letters: ");
            //A for loop that prints the guessedLetters array
            for (int i = 0; i < guessedLetters.size(); i++) {
                System.out.print(" " + guessedLetters.get(i));
            }
            System.out.println();


            char playerGuess = getCharInput();
            //Method that adds the guessed letter to the letter array
            guessedLettersTracker(guessedLetters,playerGuess);
            clearScreen();
            //A method that changes the elements in the string array
            changeTheStringArray(theWordEdit,wordLength,playerGuess,hangmanWord);
            //A method prints when all of the letters are guessed
            winChecker(wordLength, hangmanWord);
            //A method that prints the hangman depending on the amount of incorrect letters
            theHangedMan(hangmanWord);
        }

    }

    public static ArrayList<Character> guessedLettersTracker(ArrayList<Character> guessedLetters, char playerGuess) {
        guessedLetters.add(playerGuess);
        return guessedLetters;
    }

    public static void winChecker(int wordLength, String hangmanWord) {
        //An if statement that prints when the amount of correct letters is equal to the length of the word
        //It will make a system exit with exit code 0
        if (correctWordCount == wordLength) {
            System.out.println();
            System.out.println("You win");
            System.out.println();
            System.out.println("The man survived");
            System.out.println();
            System.out.println("The word was: " + hangmanWord);
            System.exit(0);
        }
    }

    public static void theHangedMan(String hangmanWord) {
        //An if else statement that calls upon a printing method in another class depending on the amount of incorrect words
        //This method makes a system exit with exit code 0 if the max amount of incorrect words is reached
        if (incorrectWordCount == 1) {
            TheHangedMan.gallows();
        } else if (incorrectWordCount == 2) {
            TheHangedMan.head();
        } else if (incorrectWordCount == 3) {
            TheHangedMan.body();
        } else if (incorrectWordCount == 4) {
            TheHangedMan.leftArm();
        } else if (incorrectWordCount == 5) {
            TheHangedMan.rightArm();
        } else if (incorrectWordCount == 6) {
            TheHangedMan.leftLeg();
        } else if (incorrectWordCount == 7) {
            TheHangedMan.rightLeg();
        } else if (incorrectWordCount > 7) {
            System.out.println();
            System.out.println("You lose");
            System.out.println();
            System.out.println("The man was hanged");
            System.out.println();
            System.out.println("The word was: " + hangmanWord);
            System.exit(0);
        }
    }

    public static boolean isLetterInWord(char playerGuess, String hangmanWord, int index) {
        //A method that uses and if statement to check if the players guess is equal to the letter.
        if (playerGuess == hangmanWord.charAt(index)  ) {
            return true;
        }
        return false;
    }

    public static void clearScreen() {
        //A method that prints multiple times making it so it looks like the terminal is cleared
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
        //Adds underscores to the array. Placeholders for the actual letters
        for (int i = 0; i < wordLength; i++) {
            theWordEdit.add("_ ");
        }
    }

    public static ArrayList<String> changeTheStringArray(ArrayList<String> theWordEdit, int wordLength, char playerGuess, String hangmanWord) {
        boolean validation = false;
        //A for loop that goes through the hangmanWord and checks if the player guess matches a letter in it
        for (int i = 0; i < wordLength; i++) {
            int index = i;
            if (isLetterInWord(playerGuess,hangmanWord,index)) {
                validation = true;
                //Making the char into a string so that it can be inserted into the String array
                String playerGuessString = Character.toString(playerGuess);
                theWordEdit.set(index, playerGuessString + " ");
                //Makes the word count go up for each time the if statement is activated
                correctWordCount++;
            }
        }
        //If statement that increases the incorrectWordCount if activated
        if (!validation) {
            incorrectWordCount++;
        }
        return theWordEdit;
    }

    static char getCharInput(){
        //Neutralizes the bug that happens when you use the same char scanner multiple times.
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

}
