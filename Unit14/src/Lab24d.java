//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit14\\src\\lab24d.dat"));

		int size = file.nextInt();
		file.nextLine();
		for (int i = 0;i < size;i++)
		{
			String word = file.nextLine();
			TicTacToe test = new TicTacToe(word);
			System.out.println(test);	
		}
	}
}



