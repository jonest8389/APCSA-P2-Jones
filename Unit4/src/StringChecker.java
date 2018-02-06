//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StringChecker
{
	private String word;

	public StringChecker()
	{
		

	}

	public StringChecker(String s)
	{
		setString(s);

	}

   public void setString(String s)
   {
   		word=s;
   }

	public boolean findLetter(char c)
	{
		for (int i = 0; i < (word.length() + 1); i++) {
			if (c == word.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public boolean findSubString(String s)
	{
		if (word.contains(s)) {
			return true;
		}

		return false;
	}

 	public String toString()
 	{
 		return "\n\n";
	}
}