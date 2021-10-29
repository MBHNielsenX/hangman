import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Word hangmanWords = new Word("");
        Scanner sc = new Scanner(System.in);
        //An empty arrayList that is to be filled later
        ArrayList<Word> chosenWords = new ArrayList<Word>();
        //Method that displays the intro message
        intro(sc);
        //A variable that uses the setDifficulty method in the Word class to set the difficulty
        int difficulty = hangmanWords.setDifficulty(chosenWords);
        //A String that uses  the randomWordFromList method in the Word class
        String hangmanWord = hangmanWords.randomWordFromList(chosenWords).toString();
        //Starts the game in the HangmanEngine class
        HangmanEngine.gameStart(hangmanWord, difficulty);

    }

    public static void intro(Scanner sc) {

        try {
            System.out.println("///////////////////////////////////////////////");
            System.out.println("               Welcome to hangman              ");
            System.out.println("///////////////////////////////////////////////");
            System.out.println("\nPress 1 to see rules or anything else to continue");
            int playerInput = sc.nextInt();
            if (playerInput == 1) {
                rules(sc);
            }
            //Catches the InputMismatchException thrown by typing in anything else than a number
        }catch(InputMismatchException e){
            System.out.println("");

        }
    }

    public static void rules(Scanner sc) {
        System.out.println("\nThe rules are as follows ");
        System.out.println("You choose one of the following 3 difficulties easy, medium or hard");
        System.out.println("When you have chosen the difficulty a random word with the given difficulty will be chosen and you will have to guess it");
        System.out.println("The word is represented with underscores that correspond to the amount of letters in the word");
        System.out.println("You will then guess one letter at a time until you either guess the word or guess wrong 6 times");
        System.out.println("If you guess wrong 6 times you hang the man and loose\n");
        System.out.println("Press anything to continue");
        sc.nextInt();
    }

}
