//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit13\\src\\lab15d.dat"));
		int size = file.nextInt();
		file.nextLine();
		for (int i = 0;i < size;i++)
		{
			FancyWords test = new FancyWords(file.nextLine());
			System.out.println(test);
			
		}
	}
}