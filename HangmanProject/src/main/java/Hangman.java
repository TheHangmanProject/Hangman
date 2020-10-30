/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 334033701
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    // Pseudocode below:
    
    // Import Scanner
    // Create a global 2D array for topics and words
        // 10 topics and 10 words in each topic
    // A global integer for guesses remaining:
        // Set it to 6 by default
    // A global array for the letters remaining
        // Default value: All alphabets
    // A global string invalid for "Invalid Response"
    // Method for lineBreak 
        // (Before and after everytime user input is taken, just like the depiction in the Hangman.pdf) 
    // Method for taking user input
        // Instantiate Scanner
        // String tempString
        // char userLetter
        // boolean isValid and set it by default to false
        // while isValid is false:
            // Ask user for a letter
            // set tempString equal to user input
            // try:
                // Set userLetter equal to the character at 0th index of tempString
                // Set isValid to true
            // end try
            // catch NumberFormatException e:
                // Print invalid 
            // end catch
        // end loop
    
}
