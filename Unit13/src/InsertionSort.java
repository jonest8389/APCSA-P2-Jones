//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		list = new ArrayList<String>();
	}

	//modfiers
	public void add( String  word)
	{
		int loc = -1;
		if (list.size() > 0)
		{
			loc = Collections.binarySearch(list, word);
		}
		if (loc < 0)
		{
			list.add(word);
		}
		sortlist();
	}
	public void remove(String word)
	{
		int loc = -1;
		if (list.size() > 0)
		{
			loc = Collections.binarySearch(list, word);
		}
		if (loc > -1)
		{
			list.remove(word);
		}
		sortlist();
	}
	public void sortlist()
	{
		ArrayList<String> newlist = new ArrayList<String>(list.size());
		if (list.size() > 1)
		{
			newlist = new ArrayList<String>(list.size());
		}
		char min = '{';
		int loc = 0;
		for (int i = 0;i < list.size();i++)
		{
			for (int j = 0;j < list.size();j++)
			{
				if ((int)(list.get(j).charAt(0)) <= (int)min && !(list.get(j).equals("null")))
				{
					min = list.get(j).charAt(0);
				}
			}
			for (int k = 0;k < list.size();k++)
			{
				if (list.get(k).charAt(0) == min)
				{
					loc = list.indexOf(list.get(k));
				}
			}
			newlist.add(list.get(loc));
			list.set(loc, "null");
			min = '}';
			loc = 0;
		}
		list = newlist;	
	}
	public String toString()
	{
		String output = "";
		for (int i = 0;i < list.size();i++)
		{
			output = output + list.get(i) + " ";
		}		
		return output;
	}
}