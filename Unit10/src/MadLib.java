//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private String madlibstory;
	
	public MadLib()
	{
		loadNouns(); loadVerbs(); loadAdjectives();
	}

	public MadLib(String fileName)
	{
	
		try{
			Scanner file = new Scanner(new File(fileName));
			int socount = 0;
			while (file.hasNext())
			{
				socount++;
			}			
			ArrayList<String> storyoutput = new ArrayList<String>(socount);
			socount = 0;
			while (file.hasNext())
			{
				storyoutput.set(socount, file.next());
				socount++;
			}
			for (int i = 0;i < storyoutput.size();i++)
			{
				if (storyoutput.get(i).equals("#"))
				{
					storyoutput.set(i, getRandomNoun());
				}
				else if (storyoutput.get(i).equals("@"))
				{
					storyoutput.set(i, getRandomVerb());
				}
				else if (storyoutput.get(i).equals("&"))
				{
					storyoutput.set(i, getRandomAdjective());
				}
			}
			String storypl = "";
			for (int j = 0;j < storyoutput.size();j++)
			{
				storypl = storypl + storyoutput.get(j) + " ";
			}
		madlibstory = storypl;
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem! (" + e + ")");
		}
		
	}

	public void loadNouns()
	{
		try{
		
		Scanner nounsfile = new Scanner(new File("nouns.dat"));
		int iter = 0;
		while (nounsfile.hasNext())
		{
			nouns.set(iter, nounsfile.next());
			iter++;
		}
		}
		catch(Exception e)
		{
			out.println("Something went wrong importing nouns (" + e + ")");
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
	
			Scanner verbsfile = new Scanner(new File("verbs.dat"));
			int iter = 0;
			while (verbsfile.hasNext())
			{
				nouns.set(iter, verbsfile.next());
				iter++;
			}
		}
		catch(Exception e)
		{
			out.println("Something went wrong importing verbs (" + e + ")");
		}
	}

	public void loadAdjectives()
	{
		try{
			
			Scanner adjfile = new Scanner(new File("adjectives.dat"));
			int iter = 0;
			while (adjfile.hasNext())
			{
				nouns.set(iter, adjfile.next());
				iter++;
			}

	
		}
		catch(Exception e)
		{
			out.println("Something went wrong importing adjectives (" + e + ")");
		}
	}

	public String getRandomVerb()
	{
		Random rand = new Random();
		int i = rand.nextInt(verbs.size()) + 1;
		return verbs.get((i - 1));
	}
	
	public String getRandomNoun()
	{
		Random rand = new Random();
		int i = rand.nextInt(nouns.size()) + 1;
		return nouns.get((i - 1));
	}
	
	public String getRandomAdjective()
	{
		
		Random rand = new Random();
		int i = rand.nextInt(adjectives.size()) + 1;
		return adjectives.get((i - 1));
	}		

	public String toString()
	{
		
	    return madlibstory + "\n\n\n";
	}
}