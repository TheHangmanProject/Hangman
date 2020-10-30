/*
 * Program Description: 
 * This program is a version of the famous game: Hangman.
 * This program has 10 topics and  10 words in each topic.
 * A random topic and word is chosen. The topic is displayed and
 * the word is displayed with letters replaced with '-'.
 * The user would have to guess a letter and the program would check if
 * the letter was in the random word. 
 * If yes:
 * Replace the '-' with the letter in all the places
 * If no:
 * Deduct remaining guesses by 1.
 * The game out end either when the number of remaining guesses becomes 0 or 
 * the user guesses the word.
 * The user is given an option to play again. If user chooses to play again,
 * then the program starts again. Otherwise, the game ends.
 *
 * Start Date: October 30, 2020
 * End Date: 
 */

// Importing Scanner
import java.util.Scanner;

/**
 * 
 * @author Yatin Malhotra
 */

public class YHangman {
    
    // A global string for invalid response
    public static String invalid = "Invalid response";
    
    // A global char for user letter
    public static char userLetter;
    
    // A global String for the word to be guessed
    public static String wordToGuess;
    
    // A global String for blank lines
    public static String blankLines = "";
    
    // A global integer for guesses remaining
    // Initializing it to 6
    public static int guessesRemaining = 6;
    
    // A a global 2D array for topics and words
    // Includes 10 topics and 10 words
    public static String topicsAndWords[][] = new String[10][11];
    
    // A global array for the letters remaining
    // Initializing it to all the alphabets
    public static String lettersRemaing[] = {"A", "B", "C", "D". "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    /**
     * Description:
     * This method is used to create a line break 
     * whenever required 
     */
    public static void lineBreak() {
        // Integer numTimes is used to print the 50 number
        // of times
        int numTimes = 50;
        
        // For loop to print "=" numTimes times
        for (int i = 0; i < numTimes; i++) { 
            System.out.print("=");
        } 
        
        // Printing an empty line
        System.out.println("");
    }
    
    
}
