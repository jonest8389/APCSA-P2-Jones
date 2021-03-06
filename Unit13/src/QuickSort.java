//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		passCount = 0;
		int low = 0; int high = list.length - 1;
		quickSort(list,low,high);

	}


	private static void quickSort(Comparable[] list, int low, int high)
	{

		if (low < high)
		{
			int s = partition(list,low,high);
			quickSort(list,low,s);
			quickSort(list,s+1,high);
		}
	}
	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable p = list[low];
		int bot = low - 1; int top = high + 1;
		while (bot < top)
		{
			while (list[--top].compareTo(p) > 0);
			while (list[++bot].compareTo(p) < 0);
			if (bot >= top)
			{
				String output = " [ ";
				for (int i = 0;i < list.length;i++)
				{
					output = output + list[i] + " ";
				}
				output = output + "]";
				System.out.println("pass " + passCount + output + "\n");
				passCount++;
				return top;
			}
			Comparable temp = list[bot];
			list[bot] = list[top];
			list[top] = temp;
		}
		return 0;
	}
}