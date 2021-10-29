import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Word hangmanWords = new Word("");
        ArrayList<Word> chosenWords = new ArrayList<Word>();
        intro();
        int difficulty = hangmanWords.setDifficulty(chosenWords);
        String hangmanWord = hangmanWords.randomWordFromList(chosenWords).toString();
        HangmanEngine.gameStart(hangmanWord, difficulty);

    }
    public static void intro() {
        System.out.println("///////////////////////////////////////////////");
        System.out.println("               Welcome to hangman              ");
        System.out.println("///////////////////////////////////////////////");
        System.out.println("\nThe rules are as follows ");
        System.out.println("You choose one of the following 3 difficulties easy, medium or hard");
        System.out.println("When you have chosen the difficulty a random word with the given difficulty will be chosen and you will have to guess it");
        System.out.println("The word is represented with underscores that correspond to the amount of letters in the word");
        System.out.println("You will then guess one letter at a time until you either guess the word or guess wrong 6 times");
        System.out.println("If you guess wrong 6 times you hang the man and loose");

    }

}
