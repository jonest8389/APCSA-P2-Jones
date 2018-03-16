//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit12\\src\\lab18d.dat"));

		int size = file.nextInt();
		file.nextLine();
		
		ArrayList<Word> wordsOrder = new ArrayList<Word>(size);
		ArrayList<Integer> wLocation = new ArrayList<Integer>(size);
		
		int iter = 0;
		while (file.hasNextLine())
		{
			wordsOrder.set(iter,new Word(file.nextLine()));
			iter++;
		}
		for (int i = 0;i < wLocation.size();i++)
		{
			wLocation.set(i, i);
		}
		for (int i = 0;i < wordsOrder.size();i++)
		{
			int ii = wLocation.get(i);
			if (ii != wordsOrder.size() - 1)
			{
				while (wordsOrder.get(ii).compareTo(wordsOrder.get(ii + 1)) != -1)
				{
					Word wPh = wordsOrder.get(ii + 1);
					int iip = wLocation.get(ii + 1);
					wordsOrder.set(iip, wordsOrder.get(ii));
					wordsOrder.set(ii, wPh);
					ii = wordsOrder.indexOf(wordsOrder.get(iip));
					iip = wordsOrder.indexOf(wordsOrder.get(ii));
					wLocation.set(i, ii);
					wLocation.set(i + 1, iip);
				}
			}
		}
		for (int i = 0;i < wordsOrder.size();i++)
		{
			out.println(wordsOrder.get(i));
		}

	}
}