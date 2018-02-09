//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		//call set
	}
	public LetterRemover(String s, char rem)
	{
		setRemover(s,rem);
	}
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned=sentence;
		int locator = cleaned.indexOf(lookFor);
		
		while (locator != -1)
		{
			cleaned = cleaned.replace(cleaned.charAt(locator), ' ');
			locator = cleaned.indexOf(lookFor);
		}		
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n"
				 + removeLetters() + "\n";
	}
}