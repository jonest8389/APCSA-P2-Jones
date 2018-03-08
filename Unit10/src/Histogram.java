//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;

	public Histogram()
	{




	}

	public Histogram(char[] values, String fName)
	{
		ArrayList<Character> letters = new ArrayList<Character>(values.length);
		ArrayList<Integer> count = new ArrayList<Integer>(values.length);
		for (int j = 0; j < values.length;j++)
		{
			letters.add(values[j]);
		}
		fileName = fName;
		this.letters = letters;
		this.count = count;
		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		
		Scanner fL = new Scanner(new File(fileName));
		while (fL.hasNext())
		{
			for (int i = 0; i < fL.next().length();i++)
			{
				for (int j = 0;j < letters.size();j++)
				{
					if (letters.get(j) == fL.next().charAt(i))
					{
						count.set(j, (count.get(j) + 1));
					}
				}
			}
		}
	}

	public char mostFrequent()
	{
		int highestval = 0;
		int highest = 0;
		for (int i = 0; i < count.size();i++)
		{
			if (count.get(i) > highestval)
			{
				highestval = count.get(i);
				highest = i;
			}
		}
		return letters.get(highest);
	}

	public char leastFrequent()
	{
		int lowestval = 10000;
		int lowest = 0;
		for (int i = 0; i < count.size();i++)
		{
			if (count.get(i) < lowestval)
			{
				lowestval = count.get(i);
				lowest = i;
			}
		}
		return letters.get(lowest);
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}