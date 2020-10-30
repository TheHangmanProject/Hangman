/**
 * Program Description: 
 * 
 * Date:
 * 
 */

package hangman;

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