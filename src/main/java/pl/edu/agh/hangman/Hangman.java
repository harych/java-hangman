package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {
	
	private static int NUMBER_OF_MOVES = 7;

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	boolean gameOn = true;
    	
    	while (gameOn) {
    		playHangman("JAVA"); // klasa random uzyta tutaj
    		System.out.println("Type 'Y' if you want to play again");
    		if (scanner.nextLine()!="Y") {
    			gameOn = false;
    		}
    	}
    }
    private static void playHangman(String randomWord) {
    	int move = 0;
    	randomWord = randomWord.toUpperCase();
    	String maskedWord = maskWord(randomWord);
    	Scanner scanner = new Scanner(System.in);
    	boolean isWinner = false;
    	while (move < NUMBER_OF_MOVES && !isWinner) {
    		System.out.println("Give a letter");
    		String letter = scanner.nextLine().toUpperCase();
    		if (checkLetter(letter,randomWord)) {
    			maskedWord = showNextLetter(letter, maskedWord, randomWord);
    			System.out.println(maskedWord); // do usuniecia
    			isWinner = isWinner(randomWord, maskedWord);
    			//print(maskedWord, HANGMANPICS[move]);
    		} else {
    			System.out.println(HANGMANPICS[move]); // do usuniecia
    			//print(maskedWord, HANGMANPICS[move]);
    			move++;
    		}
    	}
    	System.out.println("Winner: " + isWinner);
    }
    private static boolean checkLetter(String letter, String word) {
    	if (word.contains(letter)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    private static String showNextLetter(String letter2, String wordWithBlanks, String randomWord) {
        char letter = letter2.charAt(0);
    	char[] randomWordChars = randomWord.toCharArray();
    	char[] wordWithBlanksChars = wordWithBlanks.toCharArray();
        for (int i=0; i<randomWordChars.length;i++) {
        		if(randomWordChars[i] == letter) {
        			wordWithBlanksChars[i] = letter;
        	}
        }
        return new String(wordWithBlanksChars);
    }
    private static String maskWord(String randomWord) {
    	String maskedWord = new String();
    	for (int i = 0; i < randomWord.length(); i++) {
    		maskedWord = maskedWord + "_";
    	}
    	return maskedWord;
    }
    private static boolean isWinner(String randomWord, String maskedWord) {
    	if (randomWord.equals(maskedWord)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
}
