package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {

	private static int NUMBER_OF_MOVES = 7;

	public static final String[] HANGMANPICS = new String[] {
			"  +---+\n" + "  |   |\n" + "      |\n" + "      |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + "      |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + "  |   |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|   |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " /    |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " / \\  |\n" + "      |\n" + "========" };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean gameOn = true;

		while (gameOn) {
			//RandomWord rw = new RandomWord();
			playHangman("JAVA");//rw.drawWord());
			System.out.println("Type 'Y' if you want to play again");
			if (scanner.nextLine() != "Y") {
				gameOn = false;
			}
		}
	}

	private static void playHangman(String randomWord) {
		int move = 0;
		String maskedWord = maskWord(randomWord);
		Scanner scanner = new Scanner(System.in);
		boolean isWinner = false;
		System.out.println("The word you are looking for has " + randomWord.length() + " letters");
		while (move < NUMBER_OF_MOVES - 1 && !isWinner) {
			System.out.println("Guess a letter:");
			try {
				String letter = scanner.next().toUpperCase();
				if (!correctInput(letter)) {
					throw new Exception();
				}
				if (checkLetter(letter, randomWord)) {
					maskedWord = showNextLetter(letter, maskedWord, randomWord);
					//System.out.println(maskedWord); // do usuniecia
					isWinner = maskedWord.equals(randomWord);
					Print.print(maskedWord, HANGMANPICS[move]);
				} else {
					move++;
					Print.print(maskedWord, HANGMANPICS[move]);
					//System.out.println(HANGMANPICS[move]); // do usuniecia

				}
			} catch (Exception e) {
				System.out.println("Incorrect input");
			}
		}
		//Print.printMessage(isWinner);
		//System.out.println("Winner: " + isWinner);
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
		for (int i = 0; i < randomWordChars.length; i++) {
			if (randomWordChars[i] == letter) {
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


	private static boolean correctInput(String input) {
		if (input == null) { 
			return false;
		}
		int len = input.length();
		if (len != 1) {
			return false;
		}
		if ((Character.isLetter(input.charAt(0)) == false)) {
			return false;
		}
		return true;
	}

}
