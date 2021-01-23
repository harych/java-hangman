package pl.edu.agh.hangman;

public class Print 
{
	public static void print(String word, String gallow)
	{
		System.out.println(gallow + "\t\tSearch word\t" + word);
	}

	public static void printMessage(boolean isWinner, String word) {
		if (isWinner) {
			System.out.println("Congrats! You won!");
		} else {
			System.out.println("You ran out of moves! The word you were looking for was " + word);
		}
	}
}



