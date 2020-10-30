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
    
    // A global char userLetter
    
    // A global string wordToGuess
    
    // A global string blankLines = "";
    
    // Method for lineBreak 
        // (Before and after everytime user input is taken, just like the depiction in the Hangman.pdf) 
        // For i < some number
            // Print '='
        // end loop
        // Print an empty line
    // end method
    
    // Method for printing out the topic and choosing word:
        // Choose a random topic and word: Any 1 index of the 2D array for topics and words
        // Set wordToGuess equal to the random word 
        // Print the value of row (the topic)
        // For i is less than length of the word
            // blankLine = blankLine + "-";
        // end loop
        // Print blankLine
        // Print an empty line
    // end method
    
    // Method for taking user input
        // Instantiate Scanner
        // String tempString
        // boolean isValid and set it by default to false
        // while isValid is false:
            // Ask user for a letter
            // set tempString equal to user input
            // try:
                // Set userLetter equal to the character at 0th index of tempString
                // if userLetter is a part of the guessesRemaining array:
                    // Set isValid to true
                // end if
                // else if userLetter is equal to !:
                    // Print: Enter the secret word
                    // Set tempString equal to user input
                        // if tempString equals wordToGuess
                            // Print: "Congratulations... " + wordToGuess + " is correct!"
                            // Go to optionToPlayAgain method
                            // break
                        // end if
                        // else:
                            // Print: tempString + " is incorrect! The correct answer is " + wordToGuess + "!"
                            // Go to optionToPlayAgain method
                            // break
                        // end else
                // end else if
                // else:
                    // Print: userLetter + " has already been used!"
                // end else
            // end try
            // catch NumberFormatException e:
                // Print invalid 
            // end catch
        // end loop
    // end method
    
    // Method for checking user input
        // if wordToGuess contains userLetter
            // Find the index of userLetter in wordToGuess
            // An integer indexOfLetter for the index found above
            // Replace the letter at indexOfLetter with userLetter in blankLines
            // Print blankLines
        // else:
            // Reduce guessesRemaining by 1
            // Print guessesRemaining
    // end method
    
    // Method optionToPlayAgain:
        // String tempString
        // boolean isValid = false
        // while isValid is false:
            // Print: Do you want to play again (Y or N)?
            // Set tempString equal to user input
            // try:
                // Set userLetter equal to the character at 0th index of tempString
                // Convert userLetter to upper case
                // set isValid to true
            // end try
            // catch NumberFormatException e:
               // Print invalid
            // end catch
        // end loop
        // if userLetter is Y:
            // Go to taking user input method
            // Convert userLetter to upper case
        // end if
        // else if userLetter is N:
            // Go to end method 
        // end else if
        // else:
            // Print invalid
        // end else
    // end method
    
    // Method end
        // Print: Thank you for playing
    // end method
}
