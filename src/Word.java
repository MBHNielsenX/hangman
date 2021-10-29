import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Word {
    private String word;


    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
    public int setDifficulty(ArrayList<Word> chosenWords) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPress 1 for easy, press 2 for medium or press 3 for hard: ");
        int difficulty = sc.nextInt();

        if(difficulty == 1) {
        setWordList(chosenWords,1);
        } else if (difficulty == 2) {
        setWordList(chosenWords,2);
        } else if (difficulty == 3) {
        setWordList(chosenWords,3);
        } else {
            setDifficulty(chosenWords);
        }

        return difficulty;
    }

    public ArrayList<Word> setWordList(ArrayList<Word> chosenWords, int chosenDifficulty) {
        if (chosenDifficulty == 1) {
            File easyHangman = new File ("src/hangmanwordsEasy.csv");
            try {
                Scanner sc = new Scanner(easyHangman);
                while(sc.hasNextLine()){
                    String word = sc.nextLine();
                    Word currentWord = new Word(word);
                    chosenWords.add(currentWord);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found");
                e.printStackTrace();
            }

        } else if (chosenDifficulty == 2) {
            File mediumHangman = new File ("src/hangmanwordsMedium.csv");
            try {
                Scanner sc = new Scanner(mediumHangman);
                while(sc.hasNextLine()){
                    String word = sc.nextLine();
                    Word currentWord = new Word(word);
                    chosenWords.add(currentWord);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found");
                e.printStackTrace();
            }

        } else if (chosenDifficulty == 3) {
            File hardHangman = new File ("src/hangmanwordsHard.csv");
            try {
                Scanner sc = new Scanner(hardHangman);
                while(sc.hasNextLine()){
                    String word = sc.nextLine();
                    Word currentWord = new Word(word);
                    chosenWords.add(currentWord);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found");
                e.printStackTrace();
            }
        }

        return chosenWords;
    }

    public Word randomWordFromList(ArrayList<Word> chosenWords) {
        Random rand = new Random();
        int upperbound = chosenWords.size();
        int randomNum = rand.nextInt(upperbound);

        return chosenWords.get(randomNum);
    }




}
