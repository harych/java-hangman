package pl.edu.agh.hangman;
import java.util.ArrayList;
import java.util.Random;

public class RandomWord {
	
	private static ImportFromTxt imp = new ImportFromTxt();
	
	public String drawWord () {
		
		ArrayList<String> wordsToDraw = imp.getWordsList();
		Random generator = new Random();
		
		int drawnIndex = generator.nextInt(wordsToDraw.size()-1);
		
		return wordsToDraw.get(drawnIndex);
		
	}

}
