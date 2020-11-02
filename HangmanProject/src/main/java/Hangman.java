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
 * End Date: November 1
 */

// Importing everything from java.util
import java.util.*;

/**
 * 
 * @author Yatin Malhotra and Joey Bodner
 */

public class Hangman {
	// Constant for number of guesses
	public static final int NUM_GUESSES = 6;
	
	// Constant for empty string
	public static final String EMPTY_STRING = "";
	
	// A global string for invalid response
	public static String invalid = "Invalid response";

	// A global char for user letter
	public static char userLetter;

	// A global String for the word to be guessed
	public static String wordToGuess;

	// A global String for blank lines
	public static String blankLines = EMPTY_STRING;

	// A global integer for guesses remaining
	// Initializing it to 6
	public static int guessesRemaining = NUM_GUESSES;

	// A a global 2D array for topics and words
	// Includes 10 topics and 10 words
	 public static String topicsAndWords[][] = { 
			 { "MOVIES", "HARRY POTTER","LA LA LAND", "MADAGASCAR", "THE LION KING", "TITANIC", "ICE AGE", "SUPERMAN", "STAR WARS", "TOY STORY", "AVENGERS" }, 
			 { "BOARD GAMES", "MONOPOLY", "CHESS", "CHECKERS", "SNAKES AND LADDERS", "THE GAME OF LIFE", "CLUE", "SCRABBLE", "BATTLESHIP", "CANDY LAND", "SORRY" }, 
			 { "ACTORS/ACTRESSES", "DWAYNE JOHNSON", "JONAH HILL", "WILL FARRELL", "MARK WAHLBURG", "JENNIFER LAWRENCE", "SCARLETT JOHANSSON", "EMMA WATSON","MEGAN FOX", "TOM HANKS", "BRAD PITT" }, 
			 { "SONGS", "LIFE IS A HIGHWAY", "IMAGINE", "HEY JUDE", "SMELLS LIKE TEEN SPIRIT", "SWEET HOME ALABAMA", "THUNDERSTRUCK", "UPTOWN FUNK", "I GOTTA FEELING", "SHAPE OF YOU", "WHAT A WONDERFUL WORLD" }, 
			 { "ANIMALS", "ELEPHANT", "TURTLE", "TIGER", "LION", "DOG", "CAT", "HORSE", "COW", "PIG", "CROCODILE" }, 
			 { "VEHICLES", "CAR", "TRUCK", "PLANE", "BOAT", "HELICOPTER", "SUBMARINE", "SPACESHIP", "TRAIN", "MOTORCYCLE", "BICYCLE" }, 
			 { "CAR MANUFACTURERS", "HYUNDAI", "HONDA", "NISSAN", "MITSUBITHI", "VOLKSWAGON", "SUBARU", "BUICK", "CHEVORLET", "RAM", "FORD" }, 
			 { "COUNTRIES", "CANADA", "BRAZIL", "RUSSIA", "CHINA", "SPAIN", "AUSTRALIA", "JAPAN", "MEXICO", "FRANCE", "UNITED STATES OF AMERICA" }, 
			 { "FOOD", "BANANA", "PIZZA", "CEREAL", "HAMBURGER", "CHICKEN", "STEAK", "SALAD", "APPLE", "CAKE", "PINEAPPLE" }, 
			 { "MYTHICAL CREATURES", "DRAGON", "CYCLOPS", "MINOTAUR", "UNICORN", "MERMAID", "FAIRY", "WEREWOLF", "GRYPHON", "YETI", "LEPRECHAUN" } };
	 
	// A global array for the letters remaining
	// Initializing it to all the alphabets
	public static Character lettersRemaining[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	// An array list for the remaining letters
	public static List<Character> lettersRemainingList = new ArrayList<Character>(Arrays.asList(lettersRemaining));

	// Global string for letters used
	public static String lettersUsed = EMPTY_STRING;

	// Global string for topic
	public static String topic = EMPTY_STRING;

	/**
	 * Description: This method is used to create a line break whenever required
	 */
	public static void lineBreak() {
		// Integer numTimes is used to print the 50 number
		// of times
		int numTimes = 70;

		// For loop to print "=" numTimes times
		for (int i = 0; i < numTimes; i++) {
			// Printing lineBreak
			System.out.print("=");
		}

		// Printing an empty line
		System.out.println("");
	}

	/**
	 * The method below is used to choose a random topic and a word Then prints out
	 * the topic and hyphens instead of the letters of the word
	 *
	 * @return blankLines		The string with hyphens instead number of letters
	 */
	public static String chooseTopicAndWord() {
		// An integer for the random row between 0 and 9
		int randomNumRow = (int) Math.round(Math.random() * 9);

		// An integer for the random column between 1 and 10
		int randomNumCol = (int) Math.round(Math.random() * 9 + 1);

		// Setting word to guess equal to the randomized word
		wordToGuess = topicsAndWords[randomNumRow][randomNumCol];

		// Setting topic equal to a random topic from the pre-defined 10 topics
		topic = topicsAndWords[randomNumRow][0];
		
		// Printing topic
		System.out.println("Topic:\t\t\t\t\t" + topic);

		// Loop to print out the '-'s instead of the letters of the word
		System.out.print("Secret word:\t\t\t\t");
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (wordToGuess.charAt(i) == ' ') {
				// Adding a space in blankLines
				blankLines = blankLines + " ";
			} else {
				// Adding hyphen in blankLines
				blankLines = blankLines + "-";
			}
		}

		// Returns blankLines
		return blankLines;
	}

	/**
	 * Method to:
	 * 1. Take user input
	 * 2. Check if the user input is valid
	 * 3. Checking if user input is remaining
	 * 4. Checking if user input is a part of the secret word
	 * 5. Printing the results 
	 */
	public static void takeUserInput() {
		// Instantiate the Scanner
		Scanner userInput = new Scanner(System.in);

		// Temporary String for validating user input
		String tempString;

		// Boolean to validate user input
		boolean isValid = false;

		// while false
		while (isValid == false) {
			// Ask user for letter
			System.out.print("Enter a letter (! to guess the word):\t");

			// Set tempString equal to user input after converting it to upper case
			tempString = userInput.nextLine().toUpperCase();

			if (!tempString.equals(EMPTY_STRING)) {
				// if user input is !
				if (tempString.charAt(0) == '!') {
	
					// Ask to print the word
					System.out.print("\nEnter the secret word:\t\t\t");
	
					// Set tempString equal to user input after converting it to upper case
					tempString = userInput.nextLine().toUpperCase();
	
					// go to checkWord method -> tempString argument
					checkWord(tempString);
					
					// set isValid to true
					isValid = true;
	
				} else {
					// Set userLetter equal to character at 0th index of tempString
					userLetter = tempString.charAt(0);
					
					// if userLetter is a letter
					if (Character.isLetter(tempString.charAt(0)) == true) {
						// A boolean to check if user letter is in lettersRemainingList
						// Initializing it to false
						boolean isRemaining = false;
	
						// Checking if user letter is in the lettersRemainingList
						isRemaining = lettersRemainingList.contains(userLetter);
	
						// if user letter is a part of lettersRemainingList
						if (isRemaining == true) {
							// an integer for the index of user letter
							int indexOfLetter = wordToGuess.indexOf(userLetter);
	
							// if index is equal to -1
							if (indexOfLetter == -1) {						
								// Printing out that the letter is not a part of word
								System.out.println("The letter " + userLetter + " is not in the word!");
								
								// Decrementing guesses remaining by 1
								guessesRemaining--;
								
								if (guessesRemaining == 0) {
									// Printing game over message
									System.out.println("\nGAME OVER! The secret word was " + wordToGuess + "!\n");
									
									// go to option to play again method
									optionToPlayAgain();
									
									// breaking loop
									break;
								} else {
									// Setting lettersUsed to it and userLetter
									lettersUsed = lettersUsed + String.valueOf(userLetter);
		
									// Removing that letter from the list
									lettersRemainingList.remove(Character.valueOf(tempString.charAt(0)));
		
									// go to line break method
									lineBreak();
		
									// Printing out the topic
									System.out.println("Topic:\t\t\t\t\t" + topic);
									
									// Printing blankLines
									System.out.println("Secret word:\t\t\t\t" + blankLines + "\n");
		
									// Printing the remaining letters
									printRemainingLetters();
		
									// Printing letters used
									System.out.println("Letters used:\t\t\t\t" + lettersUsed);
		
									// go to print guesses left
									printGuessesLeft();
								}
							}
							// else
							else {
								// Setting lettersUsed to it and userLetter
								lettersUsed = lettersUsed + String.valueOf(userLetter);
	
								// Removing that letter from the list
								lettersRemainingList.remove(Character.valueOf(tempString.charAt(0)));
	
								// go to line break method
								lineBreak();
	
								// Printing out the topic
								System.out.println("Topic:\t\t\t\t\t" + topic);
								
								// go to replacingBlanks -> indexOfLetter as argument
								System.out.println("Secret word:\t\t\t\t" + replaceBlanks(userLetter) + "\n");
	
								// if blankLines is equal to wordToGuess
								if (blankLines.equals(wordToGuess)) {
									// Printing congratulations message
									System.out.println("Congratulations... " + blankLines + " is the correct word!\n");
									
									// go to option to play again
									optionToPlayAgain();
									
									// breaking loop
									break;
									
								} else {
									// Printing the remaining letters
									printRemainingLetters();
	
									// Printing lettersUsed
									printLettersUsed();
	
									// Printing guessesLeft
									printGuessesLeft();
								}
							}
						}
						// else
						else {
							// Printing userLetter has been used
							System.out.println(userLetter + " has already been used!");
							
							// Line break
							lineBreak();
							
							// Printing out the topic
							System.out.println("Topic:\t\t\t\t\t" + topic);
							
							// Printing blankLines
							System.out.println("Secret word:\t\t\t\t" + blankLines + "\n");
							
							// Printing out remaining letters
							printRemainingLetters();
							
							// Printing out letters used
							printLettersUsed();
							
							// Printing guesses left
							printGuessesLeft();
							
							// Taking user input
							takeUserInput();
						}
						// Set isValid to true
						isValid = true;
					}
					// else
					else {
						// Print invalid statement
						System.out.println(invalid);
						
						// Line break
						lineBreak();
						
						// Printing out the topic
						System.out.println("Topic:\t\t\t\t\t" + topic);
						
						// Printing blankLines
						System.out.println("Secret word:\t\t\t\t" + blankLines + "\n");
						
						// Printing out remaining letters
						printRemainingLetters();
						
						// Printing out letters used
						printLettersUsed();
						
						// Printing guesses left
						printGuessesLeft();
						
						// Taking user input
						takeUserInput();
					}
				} 
			} else {
				// Printing invalid statement
				System.out.println(invalid);
				
				// Line break
				lineBreak();
				
				// Printing out the topic
				System.out.println("Topic:\t\t\t\t\t" + topic);
				
				// Printing blankLines
				System.out.println("Secret word:\t\t\t\t" + blankLines + "\n");
				
				// Printing out remaining letters
				printRemainingLetters();
				
				// Printing out letters used
				printLettersUsed();
				
				// Printing guesses left
				printGuessesLeft();
				
				// Taking user input
				takeUserInput();
			}
		}
		// Go back to takeUserInput method
		takeUserInput();

	}

	/**
	 * Method to give option to play again
	 */
	public static void optionToPlayAgain() {
		// Instantiate Scanner
		Scanner sc = new Scanner(System.in);

		// Asking user if he / she wants to play again
		System.out.print("Do you want to play again? (Y or N):\t");

		// Setting option equal to user input
		String option = sc.nextLine().toUpperCase();

		// If option does not equal empty string
		if (!option.equals(EMPTY_STRING)) {
			// Set optionChar equal to character at 0th index
			char optionChar = option.charAt(0);
	
			// if optionChar is a letter
			if (Character.isLetter(optionChar)) {
				// if optionChar is equal to Y
				if (optionChar == 'Y') {
					// go to reset method
					reset();
					
					// go to game method
					game();
				}
				// else if optionChar is equal to N
				else if (optionChar == 'N') {
					// go to end method
					end();
				}
				// else
				else {
					// Print invalid statement
					System.out.println(invalid);
	
					// go back to optionToPlayAgain method
					optionToPlayAgain();
				}
			}
			// else
			else {
				// Print invalid statement
				System.out.println(invalid);
	
				// go back to option to play again method
				optionToPlayAgain();
			}
		} 
		// else
		else {
			// Print invalid statement
			System.out.println(invalid);
			
			// go back to option to play again method
			optionToPlayAgain();
		}
	}

	/**
	 * Method to print remaining letters
	 */
	public static void printRemainingLetters() {
		// Printing remaining letters
		System.out.print("Letters Remaining:\t\t\t");
		
		// For loop to print the letters in the lettersRemainingList
		for (char letters : lettersRemainingList) {
			System.out.print(letters);
		}
		// Printing a blank line
		System.out.println("");
	}

	/**
	 * Method to replace hyphen with userLetter
	 * 
	 * @param indexOfLetter index of user letter
	 * @return blankLines the string for secret word
	 */
	public static String replaceBlanks(char userLetter) {
		// Replacing hyphen with userLetter
		StringBuffer strBuff = new StringBuffer(blankLines);
		
		// Loop to replace the hyphens with userLetter
		for (int i = 0; i < wordToGuess.length(); i++) {
			// If the character at i in wordToGuess is equal to userLetter
			if (wordToGuess.charAt(i) == userLetter) {
				// Then replace the character at i to i+1 with userLetter
				strBuff.replace(i, i + 1, String.valueOf(userLetter));
			}
		}
		// Adding blankLines to strBuff after converting it to String
		blankLines = strBuff.toString();
		
		// returning blankLines
		return blankLines;
	}

	/**
	 * Method to end the game
	 */
	public static void end() {
		// Printing thank you message
		System.out.println("Thank you for playing! Goodbye!");
		
		// Exiting the program
		System.exit(0);
	}

	/**
	 * Method to print the guesses left
	 */
	public static void printGuessesLeft() {
		// Printing guesses left
		System.out.println("Guesses Remaining:\t\t\t" + guessesRemaining);
		
		// Go to line break method
		lineBreak();
	}

	/**
	 * Method to print the letters used
	 */
	public static void printLettersUsed() {
		// Printing letters used
		System.out.println("Letters Used:\t\t\t\t" + lettersUsed);
	}

	/**
	 * Method that checks if the word entered is correct or not
	 * @param tempString		The string entered by user
	 */
	public static void checkWord(String tempString) {
		// if tempString is equal to wordToGuess
		if (tempString.equals(wordToGuess)) {
			// Print congratulations message
			System.out.println("Congratulations... " + tempString + " is the correct!\n");

			// Go to option to play again method
			optionToPlayAgain();

		} else {

			// Print incorrect message
			System.out.println(tempString + " is incorrect! The correct answer was " + wordToGuess + "!");

			// Go to option to play again method
			optionToPlayAgain();
		}
	}

	/**
	 * Method to call the game
	 */
	public static void game() {
		// Go to line break method
		lineBreak();
		
		// Printing choose topic and word method
		System.out.println(chooseTopicAndWord() + "\n");
		
		// Go to print remaining letters method
		printRemainingLetters();
		
		// Go to print letters used method
		printLettersUsed();
		
		// Go to print guesses left
		printGuessesLeft();
		
		// Go to take user input
		takeUserInput();
	}

	/**
	 * Method to reset values to default
	 */
	public static void reset() {
		// Reset blankLines to an empty string
		blankLines = EMPTY_STRING;
		
		// Reset lettersUsed 
		lettersUsed = EMPTY_STRING;
		
		// Reset lettersRemaining
		lettersRemainingList = new ArrayList<Character>(Arrays.asList(lettersRemaining));
		
		// Reset guessesRemaining
		guessesRemaining = NUM_GUESSES;
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		// Print the title of the game
		System.out.println("\t\t\tWELCOME TO HANGMAN!");
		
		// Go to game method
		game();
	}
}
