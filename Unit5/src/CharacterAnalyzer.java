//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;
	private String outType;
	

	public CharacterAnalyzer()
	{


	}

	public CharacterAnalyzer(char c)
	{
		
		setChar(c);

	}

	public void setChar(char c)
	{
		theChar = c;

	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		if (((int)getChar() >= 65) && ((int)getChar() <= 90))
		{
			return true;
		}

		return false;
	}

	public boolean isLower( )
	{

		if (((int)getChar() >= 97) && ((int)getChar() <= 112))
		{
			return true;
		}

		return false;
	}
	
	public boolean isNumber( )
	{
		if ((isUpper() == false) && (isLower() == false))
		{
			return true;
		}
		return false;
	}	

	public int getASCII( )
	{
		return (int)getChar();
	}

	public String toString()
	{
		if (isNumber() == true)
		{
			outType = "a number";
		}
		if (isLower() == true)
		{
			outType = "a lowercase letter";
		}
		if (isUpper() == true)
		{
			outType = "an uppercase letter";
		}
		
		return ""+getChar() + " is " + outType + ". ASCII == " + getASCII() + "\n";	  
	}
}