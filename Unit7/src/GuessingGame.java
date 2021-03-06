//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound, currentnum, compnum, tries;
	private double percentcorrect;
	private int stopint;

	public GuessingGame(int stop)
	{
		stopint = stop;
		percentcorrect = 0.0; currentnum = 0; compnum = 0; tries = 0;
		playGame();
	}

	public void playGame()
	{
		if (stopint == 1)
		{
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Guessing Game - how many numbers?");
			upperBound = keyboard.nextInt();
			Random rand = new Random();
			compnum = rand.nextInt(upperBound) + 1;
			while (compnum != currentnum)
			{
				Scanner guess = new Scanner(System.in);
				System.out.println("Enter a number between 1 and "
				+ upperBound + " ");
				currentnum = guess.nextInt();
				if ((currentnum > upperBound) || (currentnum < 1))
				{
					System.out.println("Number out of range!");
				}
				else
				{
					tries++;
				}
			}
			if (currentnum == compnum)
			{
				percentcorrect = (((double)tries - 1.0) / (double)tries) * 100.0;
				percentcorrect = (int)percentcorrect;
			}
		}
	}

	public String toString()
	{
		String output="\nIt took " + tries + " guesses to guess " 
				+ compnum + ".\nYou guessed wrong " + percentcorrect 
				+ " percent of the time.\n";
		return output;
	}
}