//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown
	
	private static int getNumDigits(int number)
	{
		int count = 0;
		while (number / 10 > 0)
		{
			number = number / 10;
			count++;
		}
		return count + 1;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int size = getNumDigits(number);
		int[] sorted = new int[size];
		for (int i = 0; i < sorted.length;i++)
		{
			sorted[i] = (number % 10);
			number = number / 10;
		}
		int min = Integer.MAX_VALUE;
		int[] newsorted = new int[size];
		for (int j = 0;j < newsorted.length;j++)
		{
			for (int k = 0;k < sorted.length;k++)
			{
				if (sorted[k] != -1)
				{				
					if (sorted[k] < min)
					{
						min = sorted[k];
					}
				}
			}
			for (int l = 0;l < sorted.length;l++)
			{
				if (sorted[l] == min)
				{
					newsorted[j] = sorted[l];
					sorted[l] = -1;
					min = Integer.MAX_VALUE;
					break;
				}
			}
		}
		sorted = newsorted;
		return sorted;
	}
}