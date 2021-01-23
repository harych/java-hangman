package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportFromTxt {
	
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	File txt = new File(classLoader.getResource("slowa.txt").getFile());
	
	public ArrayList<String> getWordsList () throws FileNotFoundException {
		
		Scanner scanner = new Scanner(txt);
		ArrayList<String> words = new ArrayList<String>();
	
		while(scanner.nextLine() != null) {
		
		words.add(scanner.nextLine());
		
		}
		
		return words;
		
	}


	public static void main(String[] args) throws FileNotFoundException  {


		ImportFromTxt abc = new ImportFromTxt();
		ArrayList<String> lala =  abc.getWordsList();
		System.out.println(lala.toString());
	
     				
    }

}
