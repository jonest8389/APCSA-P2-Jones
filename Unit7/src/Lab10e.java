//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		String response = "y";
		int stopint = 1;
		while (!response.equals("n"))
		{
			if (!response.equals("n"))
			{
				stopint = 1;
			}
			else
			{
				stopint = 2;
			}
			GuessingGame test = new GuessingGame(stopint);
			System.out.println(test.toString());
			
			Scanner keyboard = new Scanner(System.in);
			System.out.println("\n\nWant to play?");
			response = keyboard.nextLine();
		}
	}
}