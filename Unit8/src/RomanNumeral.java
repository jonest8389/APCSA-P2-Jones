//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

import java.util.Arrays;

public class RomanNumeral
{
	private Integer number = 0;
	private String roman = "";
	private int wasroman = 0;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		setRoman(str);
	}

	public RomanNumeral(Integer orig)
	{
		setNumber(orig);
	}

	public void setNumber(Integer num)
	{
		roman = "";
		number = num;
		int newnum = number;
		for (int i = 0;i < NUMBERS.length;i++)
		{
			while (newnum - NUMBERS[i] >= 0)
			{
				newnum = newnum - NUMBERS[i];
				roman = roman + LETTERS[i];
			}
		}
		wasroman = 1;
	}
		

	public void setRoman(String rom)
	{
		number = 0;
		roman = rom;
		int[] cc = new int[roman.length()];
		for (int i = 0;i < roman.length();i++)
		{
			for (int k = 0; k < LETTERS.length;k++)
			{
				if (LETTERS[k].equals(Character.toString(roman.charAt(i))))
				{
					cc[i] = NUMBERS[k];
				}
			}
		}
		for (int j = 0;j < cc.length;j++)
		{
			if (j < (cc.length - 1))
			{
				if ((cc[j] < cc[j + 1]) && (cc[j] != 0))
				{
					cc[j] = cc[j + 1] - cc[j];
					cc[j + 1] = 0;
				}
			}
		}
		for (int l = 0;l < cc.length;l++)
		{
			number = number + cc[l];
		}	
		wasroman = 2;
	}

	public Integer getNumber()
	{
		return number;
	}

	public String toString()
	{
		if (wasroman == 1)
		{
			return roman + "\n";
		}
		else if (wasroman == 2)
		{
			return number + "\n";
		}
		else
		{
			return null;
		}
	}
}