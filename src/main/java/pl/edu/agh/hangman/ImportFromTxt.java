package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportFromTxt {

	File txt = new File("src/main/resources/slowa.txt");

	public ArrayList<String> getWordsList() throws FileNotFoundException {

		Scanner scanner = new Scanner(txt);
		ArrayList<String> words = new ArrayList<String>();
		String word = new String();

		while (scanner.hasNext()) {
			word = scanner.nextLine();
			if (!word.contains(" ")) {
				words.add(scanner.nextLine());
			}
		}

		return words;

	}
}
